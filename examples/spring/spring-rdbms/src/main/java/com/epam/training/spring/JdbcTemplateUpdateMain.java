package com.epam.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

public class JdbcTemplateUpdateMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context =
			new ClassPathXmlApplicationContext("spring-part2-datasource.xml",
					"test-db.xml");
		
		JdbcTemplate template =
			(JdbcTemplate) context.getBean("jdbcTemplate");

		int rows = template.update(
			"update customer set first_name = ? where id = ?",
			"Tiffany", 1);
		Assert.isTrue(rows == 1);
		
		String name = template.queryForObject(
			"select concat(first_name, ' ', last_name) from customer " 
				+ "where first_name = ?",
			new Object[] {"Tiffany"},
			String.class);
		System.out.println(name);
	}

}
