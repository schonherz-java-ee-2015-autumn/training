package hu.neuron.java.core.test.example;

import hu.neuron.java.core.example.annotation.HelloWordBean;
import hu.neuron.java.core.example.annotation.HelloWordBeanPrototype;
import hu.neuron.java.core.example.annotation.HelloWordRunner;
import hu.neuron.java.core.example.annotation.HelloWordRunnerConst;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWordTest {

	@Test
	public void testXML() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-example-annotation.xml");
		((ConfigurableApplicationContext) context).close();
	}

	@Test
	public void testBean() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-example-annotation.xml");

		HelloWordBean beanXML = (HelloWordBean) context
				.getBean("helloWordBean");

		beanXML.hello();

		HelloWordBean beanXML2 = (HelloWordBean) context
				.getBean("helloWordBean");

		beanXML2.hello();
		((ConfigurableApplicationContext) context).close();
	}

	@Test
	public void testBeanPrototype() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-example-annotation.xml");

		HelloWordBeanPrototype beanXML = (HelloWordBeanPrototype) context
				.getBean("helloWordBeanPrototype");

		beanXML.hello();

		HelloWordBeanPrototype beanXML2 = (HelloWordBeanPrototype) context
				.getBean("helloWordBeanPrototype");

		beanXML2.hello();

		((ConfigurableApplicationContext) context).close();
	}

	@Test
	public void testDI() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-example-annotation.xml");

		HelloWordRunner HelloWordRunner = (HelloWordRunner) context
				.getBean("helloWordRunner");

		HelloWordRunner.run();

		HelloWordRunnerConst helloWordRunnerConstXML = context
				.getBean(HelloWordRunnerConst.class);

		helloWordRunnerConstXML.run();
		((ConfigurableApplicationContext) context).close();
	}

}
