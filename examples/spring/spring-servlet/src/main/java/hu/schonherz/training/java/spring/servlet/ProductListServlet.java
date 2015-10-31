package hu.schonherz.training.java.spring.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.epam.training.spring.dao.ProductDTO;
import com.epam.training.spring.service.ProductService;
import com.epam.training.spring.service.ServiceException;

/**
 * Servlet implementation class ProductCreationServlet
 */
@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService service;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductListServlet() {
		super();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		WebApplicationContext ctx =
			WebApplicationContextUtils
				.findWebApplicationContext(config.getServletContext());

		this.service = ctx.getBean("productService", ProductService.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<ProductDTO> products = this.service.findAll();
			request.setAttribute("products", products);
			
			request.getRequestDispatcher("/WEB-INF/view/product/list.jsp").forward(request, response);;
		} catch (ServiceException e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
