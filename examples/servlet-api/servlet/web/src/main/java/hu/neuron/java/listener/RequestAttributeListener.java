package hu.neuron.java.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class servlet
 * 
 */
@WebListener
public class RequestAttributeListener implements
		ServletRequestAttributeListener {

	/**
	 * Default constructor.
	 */
	public RequestAttributeListener() {
		// TODO Auto-generated constructor stub
	}

	public void attributeAdded(ServletRequestAttributeEvent event) {
		System.out.println("Request attributeAdded "
				+ ((HttpServletRequest) event.getServletRequest())
						.getRequestURL() + " " + event.getName() + " "
				+ event.getValue());
	}

	public void attributeRemoved(ServletRequestAttributeEvent event) {
		System.out.println("Request attributeRemoved "
				+ ((HttpServletRequest) event.getServletRequest())
						.getRequestURL() + " " + event.getName() + " "
				+ event.getValue());

	}

	public void attributeReplaced(ServletRequestAttributeEvent event) {
		System.out.println("Request attributeReplaced "
				+ ((HttpServletRequest) event.getServletRequest())
						.getRequestURL() + " " + event.getName() + " "
				+ event.getValue());

	}

}
