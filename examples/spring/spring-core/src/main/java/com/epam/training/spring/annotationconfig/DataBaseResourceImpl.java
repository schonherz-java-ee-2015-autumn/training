package com.epam.training.spring.annotationconfig;

import org.springframework.stereotype.Component;

import com.epam.training.spring.common.DatabaseResource;

@Component
public class DataBaseResourceImpl implements DatabaseResource {

	private String[] contents =
		new String[] {"database content 1", "database content 2"};
	private int index = (int) (Math.random() * contents.length);
	
	@Override
	public String getContentFromDatabase() {
		System.out.println("I am using database");
		return contents[index++ % contents.length];
	}
	
	@Override
	public void saveContentToDatabase(String content) {
		System.out.println("I am using database");
	}
	
}
