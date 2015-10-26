package com.epam.training.spring;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.util.Assert;

public class SimpleJdbcInsertMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context =
			new ClassPathXmlApplicationContext("spring-part2-datasource.xml", "test-db.xml");
		
		DataSource dataSource =
			(DataSource) context.getBean("dataSource");
		
		SimpleJdbcInsert insertCustomer =
			new SimpleJdbcInsert(dataSource)
				.withTableName("customer");
		
		Customer customer = new Customer("Tiffany", "White");
		SqlParameterSource sqlParams =
			new BeanPropertySqlParameterSource(customer);
		
		int rows = insertCustomer.execute(sqlParams);
		Assert.isTrue(rows == 1);
		
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
