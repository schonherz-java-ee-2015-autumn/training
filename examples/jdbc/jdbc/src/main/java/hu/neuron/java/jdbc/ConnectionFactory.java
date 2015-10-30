package hu.neuron.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String URL = "jdbc:mysql://localhost:3306/training";
	private static final String USER = "root";
	private static final String PASS = "mysql";

	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(URL, USER, PASS);
		return conn;
	}
}
