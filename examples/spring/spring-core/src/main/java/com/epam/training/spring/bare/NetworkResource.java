package com.epam.training.spring.bare;

public class NetworkResource {
	
	private String[] contents =
		new String[] {"network content 1", "network content 2"};
	private int index = (int) (Math.random() * contents.length);
	
	public String downloadFileContents(String path) {
		System.out.println("I am using network");
		return contents[index++ % contents.length];
	}
	
	public void uploadFileContent(String path, String content) {
		System.out.println("I am using network");
	}
	
}
