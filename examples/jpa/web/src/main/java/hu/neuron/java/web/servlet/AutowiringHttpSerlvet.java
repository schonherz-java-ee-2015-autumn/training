package hu.neuron.java.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public abstract class AutowiringHttpSerlvet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		WebApplicationContext wac =
			WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		wac.getAutowireCapableBeanFactory().autowireBean(this);
	}

	
	
}
