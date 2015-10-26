package com.epam.training.spring.common;

public interface DatabaseResource {

	String getContentFromDatabase();

	void saveContentToDatabase(String content);

}