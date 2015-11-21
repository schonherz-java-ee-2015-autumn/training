package hu.neuron.java.core.example.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloWordRunnerConst {

	private HelloWordBean helloWordBean;

	@Autowired
	public HelloWordRunnerConst(HelloWordBean helloWordBean) {
		this.helloWordBean = helloWordBean;
	}

	public void run() {
		helloWordBean.hello();

	}

}
