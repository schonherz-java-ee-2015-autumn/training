package hu.neuron.java.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class servlet
 * 
 */
@WebListener
public class RequestListener implements ServletRequestListener {

	/**
	 * Default constructor.
	 */
	public RequestListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
	 */
	public void requestDestroyed(ServletRequestEvent event) {
		System.out.println("Request: requestDestroyed: "
				+ ((HttpServletRequest)event.getServletRequest()).getRequestURL());
	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 */
	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("Request: requestInitialized: "
				+ ((HttpServletRequest)event.getServletRequest()).getRequestURL());
	}

}
