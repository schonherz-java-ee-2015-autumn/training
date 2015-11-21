package hu.neuron.java.core.example.annotation;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class HelloWordBean {
	private static final Logger logger = Logger.getLogger(HelloWordBean.class);

	public void hello() {
		logger.debug(this.toString() + " say: Hello Word!");

	}
}
