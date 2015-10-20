package hu.neuron.java.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 * 
 */
public class SessionLivecycleListener implements HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public SessionLivecycleListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("Session: created: " + event.getSession().getId());
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("Session: destroyed: " + event.getSession().getId());
	}

}
