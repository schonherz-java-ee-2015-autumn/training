package hu.neuron.java.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextListener
 * 
 */
@WebListener
public class ContextAttributeListener implements
		ServletContextAttributeListener {

	/**
	 * Default constructor.
	 */
	public ContextAttributeListener() {
		// TODO Auto-generated constructor stub
	}

	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("Context attributeAdded " + event.getName() + " "
				+ event.getValue());

	}

	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("Context attributeRemoved " + event.getName() + " "
				+ event.getValue());

	}

	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("Context attributeReplaced " + event.getName() + " "
				+ event.getValue());

	}

}
