package com.epam.training.spring.bare;

public class DataBaseResource {

	private String[] contents =
		new String[] {"database content 1", "database content 2"};
	private int index = (int) (Math.random() * contents.length);
	
	public String getContentFromDatabase() {
		System.out.println("I am using database");
		return contents[index++ % contents.length];
	}
	
	public void saveContentToDatabase(String content) {
		System.out.println("I am using database");
	}
	
}
