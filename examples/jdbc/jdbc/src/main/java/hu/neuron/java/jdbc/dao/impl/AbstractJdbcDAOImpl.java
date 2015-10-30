package hu.neuron.java.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.neuron.java.jdbc.dao.DAOException;

public abstract class AbstractJdbcDAOImpl {

	protected Connection connection;

	public AbstractJdbcDAOImpl(Connection connection) {
		this.connection = connection;
	}

	protected int updateInternally(String sql, StatementPopulator populator) throws DAOException {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			populator.populate(statement);
			return statement.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		
	}

}
