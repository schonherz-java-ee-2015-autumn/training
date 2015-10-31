package com.epam.training.spring.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.epam.training.spring.common.BusinessLogic;
import com.epam.training.spring.common.DatabaseResource;
import com.epam.training.spring.common.NetworkResource;

@Service("businessLogic")
public class BusinessLogicImpl implements BusinessLogic {

	// @Autowired
	private NetworkResource server;

	// @Autowired
	private DatabaseResource database;

	// @Autowired
	// public BusinessLogicImpl(NetworkResource server, DatabaseResource
	// database) {
	// super();
	// this.server = server;
	// this.database = database;
	// }

	@Autowired
	public void setDatabase(DatabaseResource database) {
		this.database = database;
	}

	@Autowired
	public void setServer(NetworkResource server) {
		this.server = server;
	}

	@Override
	public void doBusiness(String path) {

		String content = server.downloadFileContents(path);

		if (content.contains("1")) {
			database.saveContentToDatabase(content);
		} else if (content.contains("2")) {
			content = database.getContentFromDatabase();
			server.uploadFileContent(path, content);
		}

	}
}
