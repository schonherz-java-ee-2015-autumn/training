package com.epam.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.spring.common.BusinessLogic;

public class XmlConfigMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("example-xmlconfig.xml");
		
		BusinessLogic businessLogic =
			context.getBean("businessLogic", BusinessLogic.class);
		
		businessLogic.doBusiness("http://example.org/remotefile");
    	
		context.close();
    	System.out.println("Application ended");
	}
	
}
