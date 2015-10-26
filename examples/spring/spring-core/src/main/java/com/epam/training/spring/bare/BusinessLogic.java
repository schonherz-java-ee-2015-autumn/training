package com.epam.training.spring.bare;

public class BusinessLogic {
	
	private NetworkResource server;
	private DataBaseResource database;

	public BusinessLogic() {
		server = new NetworkResource();
		database = new DataBaseResource();
	}

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
