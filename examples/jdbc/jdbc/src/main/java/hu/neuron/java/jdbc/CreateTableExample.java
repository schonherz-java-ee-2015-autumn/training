package hu.neuron.java.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableExample {

	public void createTable() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = ConnectionFactory.getConnection();

			statement = connection.createStatement();
			String sql = "CREATE TABLE REGISTRATION "
					+ "(ID int NOT NULL AUTO_INCREMENT, "
					+ " first VARCHAR(255), " + " last VARCHAR(255), "
					+ " age INTEGER, " + " PRIMARY KEY ( id ))";

			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
