package com.epam.training.spring.common;

public interface NetworkResource {

	String downloadFileContents(String path);

	void uploadFileContent(String path, String content);

}