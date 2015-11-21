package hu.neuron.java.core.example.java;

import org.apache.log4j.Logger;


public class HelloWordBeanJava {
	private static final Logger logger = Logger.getLogger(HelloWordBeanJava.class);

	public void hello() {
		logger.debug(this.toString() + " say: Hello Word!");

	}
}
