package hu.neuron.java.core.test.example;

import hu.neuron.java.core.example.HelloWordBeanXML;
import hu.neuron.java.core.example.HelloWordRunnerConstXML;
import hu.neuron.java.core.example.HelloWordRunnerXML;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWordXMLTest {

	@Test
	public void testXML() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-example.xml");
		((ConfigurableApplicationContext) context).close();
	}

	@Test
	public void testBean() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-example.xml");

		HelloWordBeanXML beanXML = (HelloWordBeanXML) context
				.getBean("helloWordBeanXML");

		beanXML.hello();

		HelloWordBeanXML beanXML2 = (HelloWordBeanXML) context
				.getBean("helloWordBeanXML");

		beanXML2.hello();
		((ConfigurableApplicationContext) context).close();
	}

	@Test
	public void testBeanPrototype() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-example.xml");

		HelloWordBeanXML beanXML = (HelloWordBeanXML) context
				.getBean("helloWordBeanXMLPrototype");

		beanXML.hello();

		HelloWordBeanXML beanXML2 = (HelloWordBeanXML) context
				.getBean("helloWordBeanXMLPrototype");

		beanXML2.hello();
		((ConfigurableApplicationContext) context).close();
	}

	@Test
	public void testXMLDI() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-example.xml");

		HelloWordRunnerXML helloWordRunnerXML = (HelloWordRunnerXML) context
				.getBean("helloWordRunnerXML");

		helloWordRunnerXML.run();

		HelloWordRunnerConstXML helloWordRunnerConstXML = context
				.getBean(HelloWordRunnerConstXML.class);

		helloWordRunnerConstXML.run();
		((ConfigurableApplicationContext) context).close();
	}

	@Test
	public void testXMLFactoy() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-example.xml");
		HelloWordRunnerXML helloWordRunnerXMLFromFactory = (HelloWordRunnerXML) context
				.getBean("helloWordRunnerXMLFromFactory");

		helloWordRunnerXMLFromFactory.run();
		
		HelloWordRunnerXML helloWordRunnerXMLFromFactory2 = (HelloWordRunnerXML) context
				.getBean("helloWordRunnerXMLFromFactory");

		helloWordRunnerXMLFromFactory2.run();

		HelloWordRunnerXML helloWordRunnerXMLFromStaticFactory = (HelloWordRunnerXML) context
				.getBean("helloWordRunnerXMLFromStaticFactory");

		helloWordRunnerXMLFromStaticFactory.run();
		

		HelloWordRunnerXML helloWordRunnerXMLFromStaticFactory2 = (HelloWordRunnerXML) context
				.getBean("helloWordRunnerXMLFromStaticFactory");

		helloWordRunnerXMLFromStaticFactory2.run();
		((ConfigurableApplicationContext) context).close();
	}

}
