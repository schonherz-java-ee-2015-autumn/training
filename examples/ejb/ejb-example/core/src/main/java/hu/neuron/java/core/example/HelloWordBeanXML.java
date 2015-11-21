package hu.neuron.java.core.example;

import org.apache.log4j.Logger;

public class HelloWordBeanXML {
	private static final Logger logger = Logger
			.getLogger(HelloWordBeanXML.class);

	public void hello() {
		logger.debug(this.toString()+" say: Hello Word!");

	}
}
