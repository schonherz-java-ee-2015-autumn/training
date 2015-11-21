package hu.neuron.java.core.example.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloWordRunner {
	@Autowired
	private HelloWordBean helloWordBean;

	public HelloWordBean getHelloWordBeanXML() {
		return helloWordBean;
	}

	public void setHelloWordBeanXML(HelloWordBean helloWordBean) {
		this.helloWordBean = helloWordBean;
	}

	public void run() {
		helloWordBean.hello();

	}
}
