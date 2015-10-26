package com.epam.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

public class JdbcTemplateDeleteMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context =
			new ClassPathXmlApplicationContext("spring-part2-datasource.xml",
				"test-db.xml");
		
		JdbcTemplate template =
			(JdbcTemplate) context.getBean("jdbcTemplate");

		Integer count = template.queryForObject("select count(*) from product", Integer.class);
		System.out.println(count);
		
		int rows = template.update("delete from product");
		Assert.isTrue(rows == 3);
		
		count = template.queryForObject("select count(*) from product", Integer.class);		
		
		System.out.println(count);
	}

}
