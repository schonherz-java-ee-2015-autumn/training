package com.epam.training;

import org.junit.Test;

import com.epam.training.spring.bare.BusinessLogic;

public class BareBusinessLogicTest {
	
	@Test
	public void shouldSaveToDatabase() {
		// test when downloaded content contains 1
		BusinessLogic businessLogic = new BusinessLogic();
		businessLogic.doBusiness("somepath");
	}
	
	@Test
	public void shouldSaveToServer() {
		// test when downloaded content contains 2
		BusinessLogic businessLogic = new BusinessLogic();
		businessLogic.doBusiness("somepath");
	}
	
	
	@Test
	public void shouldDoNothing() {
		// test when downloaded content has no 1 or 2
		BusinessLogic businessLogic = new BusinessLogic();
		businessLogic.doBusiness("somepath");
	}
	
}
