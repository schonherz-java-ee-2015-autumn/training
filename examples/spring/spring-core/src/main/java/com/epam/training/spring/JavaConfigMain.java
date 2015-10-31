package com.epam.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epam.training.spring.common.BusinessLogic;
import com.epam.training.spring.javaconfig.ExampleConfig;

public class JavaConfigMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ExampleConfig.class);
		
		BusinessLogic businessLogic =
				context.getBean("businessLogic", BusinessLogic.class);
			
		businessLogic.doBusiness("http://example.org/remotefile");

		BusinessLogic businessLogic2 =
				context.getBean("businessLogic2", BusinessLogic.class);
			
		businessLogic2.doBusiness("http://example.org/remotefile");
		
    	System.out.println("Application ended");
		
	}
	
}
