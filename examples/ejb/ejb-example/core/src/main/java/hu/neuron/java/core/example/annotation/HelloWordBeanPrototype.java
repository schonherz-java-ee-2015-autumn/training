package hu.neuron.java.core.example.annotation;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HelloWordBeanPrototype {
	private static final Logger logger = Logger.getLogger(HelloWordBeanPrototype.class);

	public void hello() {
		logger.debug(this.toString() + " say: Hello Word!");

	}
}
