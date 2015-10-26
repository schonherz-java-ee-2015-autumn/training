package com.epam.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

public class JdbcTemplateInsertMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context =
			new ClassPathXmlApplicationContext("spring-part2-datasource.xml", "test-db.xml");
		
		JdbcTemplate template =
			(JdbcTemplate) context.getBean("jdbcTemplate");

		int rows = template.update(
			"insert into customer " 
				+ "(first_name, last_name) values (?, ?)",
			"Tiffany", "White");
		Assert.isTrue(rows == 1);
		
		Integer count = template.queryForObject(
			"select count(*) from customer " 
				+ "where first_name = ? and " 
				+ "last_name = ?", Integer.class, 
			"Tiffany", "White");
		System.out.println(count);
	}

}
