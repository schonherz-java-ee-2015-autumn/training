package com.epam.training.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.util.Assert;

public class NamedParameterJdbcTemplateInsertMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context =
			new ClassPathXmlApplicationContext("spring-part2-datasource.xml", "test-db.xml");
		
		NamedParameterJdbcTemplate template =
			(NamedParameterJdbcTemplate) context.getBean("namedParameterJdbcTemplate");

		Customer customer = new Customer("Tiffany", "White");
		SqlParameterSource sqlParams =
			new BeanPropertySqlParameterSource(customer);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstName", "Will");
		map.put("lastName", "Smith");
			
		//sqlParams = new MapSqlParameterSource(map);
		
		int rows = template.update(
			"insert into customer " 
				+ "(first_name, last_name) values (:firstName, :lastName)",
			sqlParams);
		Assert.isTrue(rows == 1);
		
		Integer count = template.queryForObject(
			"select count(*) from customer " 
				+ "where first_name = :firstName and " 
				+ "last_name = :lastName", sqlParams, Integer.class);
		System.out.println(count);
	
	}
	
	private static class Customer {
		private String firstName, lastName;

		public Customer(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		@SuppressWarnings("unused")
		public String getFirstName() {
			return firstName;
		}
		
		@SuppressWarnings("unused")
		public String getLastName() {
			return lastName;
		}
		
	}

}
