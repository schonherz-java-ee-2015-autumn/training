package com.epam.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.spring.common.BusinessLogic;

public class AnnotationConfigMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(
						"example-annotationconfig.xml");
		
		BusinessLogic businessLogic =
				context.getBean("businessLogic", BusinessLogic.class);
			
		businessLogic.doBusiness("http://example.org/remotefile");
    	
    	System.out.println("Application ended");
	}
	
}
