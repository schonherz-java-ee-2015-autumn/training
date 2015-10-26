package com.epam.training;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.training.spring.common.BusinessLogic;
import com.epam.training.spring.javaconfig.ExampleConfig;
import com.epam.training.spring.xmlconfig.BusinessLogicImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ExampleConfig.class)
public class SpringBusinessLogicIntegrationTest {
	
	@Autowired
	private BusinessLogic businessLogic;
	
	@Test
	public void contextShouldBeInitialized() throws Exception {
		assertNotNull(businessLogic);
		assertTrue(businessLogic instanceof BusinessLogicImpl);
		
		PrintStream original = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		String output = null;
		try(PrintStream standardOutput = new PrintStream(baos)) {
			System.setOut(standardOutput);
			businessLogic.doBusiness("somepath");
			businessLogic.doBusiness("somepath");
			
			output = baos.toString();
			assertTrue(output.contains("I am using network"));
			assertTrue(output.contains("I am using database"));
		} finally {
			System.setOut(original);
		}
		System.out.println(output);
	}
	
}
