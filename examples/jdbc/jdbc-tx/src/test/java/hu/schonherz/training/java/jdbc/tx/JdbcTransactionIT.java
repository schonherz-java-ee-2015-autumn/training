package hu.schonherz.training.java.jdbc.tx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

public class JdbcTransactionIT {

	private static final String URL = "jdbc:mysql://localhost:3306/pelda";
	private static final String USER = "root";
	private static final String PASS = "mysql";
	private static final String SQL = "select c.id from car c join car_model m on c.car_model_id = m.car_model_id where c.number_plate = ?";
	private static final String UPDATE = "update car set color = ? where id = ?";

	@Test
	public void testJdbcTransactionWithoutAutoCommit() throws SQLException {
		
		Connection connection = DriverManager.getConnection(URL, USER, PASS);
		connection.setAutoCommit(false);
		connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
		
		try {
			Long carId = null;

			PreparedStatement statement = null;
			ResultSet resultSet = null;
			
			try {
				statement = connection.prepareStatement(SQL);
				statement.setString(1, "ABC-123");
				
				resultSet = statement.executeQuery();
				
				while(resultSet.next()) {
					carId = resultSet.getLong(1);
				}
				
			} finally {
				if( resultSet != null ) {
					resultSet.close();
				}

				if( statement != null ) {
					statement.close();
				}
				
				statement = null;
				resultSet = null;
			}
			
			Assert.assertNotNull(carId);
			
			try {
				statement = connection.prepareStatement(UPDATE);
				statement.setString(1, "orange");
				statement.setLong(2, carId);
				
				int result = statement.executeUpdate();
				Assert.assertEquals(1, result);
			} finally {
				if( statement != null ) {
					statement.close();
				}
				
				statement = null;
			}

			connection.commit();
			
		} catch(Exception e) {
			connection.rollback();
			Assert.fail("Transaction failed");
		} finally {
			connection.close();
		}
		
	}
	
}
