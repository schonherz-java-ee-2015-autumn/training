package com.epam.training.spring.xmlconfig;

import com.epam.training.spring.common.BusinessLogic;
import com.epam.training.spring.common.DatabaseResource;
import com.epam.training.spring.common.NetworkResource;

public class BusinessLogicImpl implements BusinessLogic {
	
	private NetworkResource server;
	private DatabaseResource database;
	
	public void setDatabase(DatabaseResource database) {
		this.database = database;
	}
	
	public void setServer(NetworkResource server) {
		this.server = server;
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
