package com.epam.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epam.training.spring.common.BusinessLogic;

public class AnnotationConfigMain2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext(
						"com.epam.training.spring.annotationconfig");
		
		BusinessLogic businessLogic =
				context.getBean("businessLogic", BusinessLogic.class);
			
		businessLogic.doBusiness("http://example.org/remotefile");
    	
    	System.out.println("Application ended");
	}
	
}
