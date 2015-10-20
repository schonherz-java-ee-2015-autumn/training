package hu.neuron.java.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class SessionAttributeListener
 * 
 */
public class SessionAttributeListener implements HttpSessionAttributeListener {

	/**
	 * Default constructor.
	 */
	public SessionAttributeListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("Session : " + event.getSession().getId()
				+ "removed " + event.getName() + " " + event.getValue());
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("Session : " + event.getSession().getId()
				+ " Added " + event.getName() + " " + event.getValue());
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("Session : " + event.getSession().getId()
				+ "Replaced " + event.getName() + " " + event.getValue());
	}

}
