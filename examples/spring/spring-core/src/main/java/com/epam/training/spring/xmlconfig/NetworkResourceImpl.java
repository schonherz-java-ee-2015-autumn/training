package com.epam.training.spring.xmlconfig;

import com.epam.training.spring.common.NetworkResource;

public class NetworkResourceImpl implements NetworkResource {
	
	private String[] contents =
		new String[] {"network content 1", "network content 2"};
	private int index = (int) (Math.random() * contents.length);
	
	@Override
	public String downloadFileContents(String path) {
		System.out.println("I am using network");
		return contents[index++ % contents.length];
	}
	
	@Override
	public void uploadFileContent(String path, String content) {
		System.out.println("I am using network");
	}
	
}
