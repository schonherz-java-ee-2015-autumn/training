package hu.neuron.java.jdbc.dao;

import hu.neuron.java.jdbc.ConnectionFactory;
import hu.neuron.java.jdbc.dao.impl.RegistrationDAOImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOFactory {
	private Connection connection;
	private boolean scopeMarked = false;
	private RegistrationDAOImpl registrationDAOImpl;

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return new DAOFactory();
	}

	public RegistrationDAO getRegistrationDAO() throws Exception {
		if (connection == null)
			throw new Exception();
		if (registrationDAOImpl == null) {
			registrationDAOImpl = new RegistrationDAOImpl(connection);
		}
		return registrationDAOImpl;
	}

	public void beginConnectionScope() throws DAOException {
		// System.out.println(Thread.currentThread().getId() + " "
		// + this.toString() + " begin");
		if (scopeMarked) {
			throw new DAOException("The beginning of scope is already marked.");
		} else {
			try {
				connection = ConnectionFactory.getConnection();
			} catch (Exception e) {
				scopeMarked = false;
				throw new DAOException(e);
			}
		}
		scopeMarked = true;
	}

	public void endConnectionScope() throws DAOException {
		// System.out.println(Thread.currentThread().getId() + " "
		// + this.toString() + " closed");
		if (!scopeMarked) {
			throw new DAOException(Thread.currentThread().getId()
					+ " The end of scope is already marked.");
		} else {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				} finally {
					connection = null;
					scopeMarked = false;
				}
			}
		}
	}

	public void beginTransaction() throws DAOException {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void endTransaction() throws DAOException {
		try {
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void abortTransaction() throws DAOException {
		try {
			connection.rollback();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
