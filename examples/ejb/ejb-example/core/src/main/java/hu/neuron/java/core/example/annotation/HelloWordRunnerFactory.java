package hu.neuron.java.core.example.annotation;

import org.springframework.stereotype.Component;

@Component
public class HelloWordRunnerFactory {

	private HelloWordBean helloWordBean;
	private static HelloWordRunner helloWordRunner = new HelloWordRunner();

	private HelloWordRunnerFactory() {
	}

	public HelloWordRunner createInstance() {
		helloWordRunner.setHelloWordBeanXML(helloWordBean);
		return helloWordRunner;
	}

	public HelloWordBean getHelloWordBeanXML() {
		return helloWordBean;
	}

	public void setHelloWordBeanXML(HelloWordBean helloWordBean) {
		this.helloWordBean = helloWordBean;
	}
}
