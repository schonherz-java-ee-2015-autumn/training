package hu.neuron.java.core.example.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class HelloWordRunnerJava {
	@Autowired
	private HelloWordBeanJava helloWordBean;

	public HelloWordBeanJava getHelloWordBeanXML() {
		return helloWordBean;
	}

	public void setHelloWordBeanXML(HelloWordBeanJava helloWordBean) {
		this.helloWordBean = helloWordBean;
	}

	public void run() {
		helloWordBean.hello();

	}
}
