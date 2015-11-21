package hu.neuron.java.web.servlet;

import hu.neruon.java.ejb.client.service.UserServiceBeanLocal;
import hu.neruon.java.ejb.client.vo.UserVO;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * This servlet handles the message box.
 */
@WebServlet(name = "/RegistrationServlet", urlPatterns = "/RegistrationServlet")
@EJB(name = "ejb.UserServiceBeanLocal", beanInterface = UserServiceBeanLocal.class)
public class RegistrationServlet extends HttpServlet {
	@EJB
	UserServiceBeanLocal service;

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(RegistrationServlet.class);

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");

			if (!password.equals(password2)) {
				request.setAttribute("error", "Password not match");
			} else if (service.findUserByName(username) != null) {
				request.setAttribute("error", "Username exits");
			} else {

				UserVO userVO = new UserVO();

				BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
				String encPassword = bCryptPasswordEncoder.encode(password);

				userVO.setPassword(encPassword);
				userVO.setUserName(username);

				service.registrationUser(userVO);

				request.setAttribute("msg", "Success");

			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		request.getRequestDispatcher("/public/registration.jsp").forward(
				request, response);
	}
}
