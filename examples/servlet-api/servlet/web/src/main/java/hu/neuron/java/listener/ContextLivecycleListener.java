package hu.neuron.java.listener;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextListener
 * 
 */
@WebListener
public class ContextLivecycleListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public ContextLivecycleListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent event) {
//		System.out.println("Context: contextInitialized ContextPath: "
//				+ event.getServletContext().getContextPath());

		ServletContext c = event.getServletContext();
		for (Enumeration<String> iterator = c.getInitParameterNames(); iterator
				.hasMoreElements();) {
			String param = iterator.nextElement();
			System.out.println("Context:" + param + " "
					+ c.getInitParameter(param));
		}
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Context: contextDestroyed");
	}

}
