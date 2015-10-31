package com.epam.training.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epam.training.spring.common.BusinessLogic;
import com.epam.training.spring.common.DatabaseResource;
import com.epam.training.spring.common.NetworkResource;
import com.epam.training.spring.xmlconfig.BusinessLogicImpl;
import com.epam.training.spring.xmlconfig.DataBaseResourceImpl;
import com.epam.training.spring.xmlconfig.NetworkResourceImpl;

@Configuration
public class ExampleConfig {

	@Bean
	public BusinessLogic businessLogic() {
		BusinessLogicImpl businessLogic = new BusinessLogicImpl();
		businessLogic.setDatabase(databaseResource());
		businessLogic.setServer(networkResource());
		return businessLogic;
	}
	
	@Bean
	public BusinessLogic businessLogic2() {
		BusinessLogicImpl businessLogic = new BusinessLogicImpl();
		businessLogic.setDatabase(databaseResource());
		businessLogic.setServer(networkResource());
		return businessLogic;
	}
	
	@Bean
	@Scope("prototype")
	public NetworkResource networkResource() {
		return new NetworkResourceImpl();
	}
	
	@Bean
	public DatabaseResource databaseResource() {
		return new DataBaseResourceImpl();
	}
}

