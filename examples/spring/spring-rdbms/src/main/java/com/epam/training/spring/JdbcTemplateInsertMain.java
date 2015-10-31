package com.epam.training.spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
		
		CustomerName customerName = template.queryForObject(
			"select first_name, last_name from customer " 
				+ "where first_name = ? and " 
				+ "last_name = ?", (rs, count) -> {
								return new CustomerName(rs.getString(1), rs.getString(2));
						}, 
			"Tiffany", "White");
		System.out.println(customerName);
	}

}
