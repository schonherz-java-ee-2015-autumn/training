package hu.neuron.java.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import junit.framework.TestCase;

public class InsertTest extends TestCase {

	public void testInsert() {
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		StatementExample insertStatement = new StatementExample();
		PreparedStatementExample insertPreparedStatement = new PreparedStatementExample();

		Date date = new Date();
		for (int i = 0; i < 1000; i++) {
			insertStatement.insert(i);
		}

		System.out.println("Insert with statement: "
				+ (new Date().getTime() - date.getTime()));

		date = new Date();
		for (int i = 0; i < 1000; i++) {
			
			insertPreparedStatement.insert(i);
		}

		System.out.println("Insert with preparedStatement: "
				+ (new Date().getTime() - date.getTime()));

	}
}
