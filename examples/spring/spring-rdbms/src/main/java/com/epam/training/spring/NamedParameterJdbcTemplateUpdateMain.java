package com.epam.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.util.Assert;

public class NamedParameterJdbcTemplateUpdateMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context =
			new ClassPathXmlApplicationContext("spring-part2-datasource.xml",
					"test-db.xml");
		
		NamedParameterJdbcTemplate template =
			(NamedParameterJdbcTemplate) context.getBean("namedParameterJdbcTemplate");

		Customer customer = new Customer(1, "Tiffany", "White");
		SqlParameterSource sqlParams =
			new BeanPropertySqlParameterSource(customer);
		
		int rows = template.update(
			"update customer set first_name = :firstName " 
				+ "where id = :id",
			sqlParams);
		Assert.isTrue(rows == 1);
		
		String name = template.getJdbcOperations().queryForObject(
			"select concat(first_name, ' ', last_name) from customer " 
				+ "where id = ?",
			String.class, customer.getId());
		System.out.println(name);
	
	}
	
	private static class Customer {
		private long id;
		private String firstName, lastName;

		public Customer(long id, String firstName, String lastName) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public long getId() {
			return id;
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
