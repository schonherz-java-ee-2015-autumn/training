package com.epam.training.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcTemplateQueryMain {
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
		
		ApplicationContext context =
			new ClassPathXmlApplicationContext("spring-part2-datasource.xml", "test-db.xml");
		
		JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate");
		
		List<ProductName> result = template.query(
			"select short_name, long_name "
				+ "from product where is_chinese = ? and net_price > ?",
			new RowMapper<ProductName>() {
				public ProductName mapRow(ResultSet rs, int rowNum)
					throws SQLException {
						return new ProductName(rs.getString(1), rs.getString(2));
				}
			}, false, 20);
		
		for(ProductName productName : result){
			System.out.println(productName);
		}
	}
	
	private static class ProductName {
		private String shortName, longName;
		
		public ProductName(String shortName, String longName){
			this.shortName = shortName;
			this.longName = longName;
		}
				
		public String toString() {
			return shortName + " " + longName;
		}
	}

}
