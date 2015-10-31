package com.epam.training.spring.xmlconfig;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;

import com.epam.training.spring.common.BusinessLogic;
import com.epam.training.spring.common.DatabaseResource;
import com.epam.training.spring.common.NetworkResource;

public class BusinessLogicImpl implements BusinessLogic, InitializingBean {
	
	private NetworkResource server;
	private DatabaseResource database;
	
	public BusinessLogicImpl() {
		System.out.println("BusinessLogicImpl constructor");
	}
	
	public void setDatabase(DatabaseResource database) {
		System.out.println("setDatabase");
		this.database = database;
	}
	
	public void setServer(NetworkResource server) {
		System.out.println("setServer");
		this.server = server;
	}
	
	@PostConstruct
	public void initAnnotation() {
		System.out.println("init postconstruct");
	}
	
	public void initMethod() {
		System.out.println("init method");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if( this.server == null ) {
			throw new NullPointerException("server is null");
		}
		System.out.println("Initialized in afterPropertiesSet()");
	}
	
	@Override
	public void doBusiness(String path) {

		String content = server.downloadFileContents(path);
		
		if( content.contains("1") ) {
			database.saveContentToDatabase(content);
		} else if( content.contains("2") ) {
			content = database.getContentFromDatabase();
			server.uploadFileContent(path, content);
		}
		
	}
}
