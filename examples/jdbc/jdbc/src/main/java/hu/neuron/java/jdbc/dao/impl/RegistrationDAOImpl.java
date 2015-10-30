package hu.neuron.java.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.neuron.java.jdbc.dao.DAOException;
import hu.neuron.java.jdbc.dao.RegistrationDAO;
import hu.neuron.java.jdbc.dto.RegistrationDTO;

public class RegistrationDAOImpl extends AbstractJdbcDAOImpl implements RegistrationDAO {
	public RegistrationDAOImpl(Connection connection) {
		super(connection);
	}

	@Override
	public Long save(RegistrationDTO dto) throws DAOException {

		Long rv = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO REGISTRATION( last,first,age ) VALUES ( ?,?,? ) ";
			statement = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, dto.getLastName());
			statement.setString(2, dto.getFirstName());
			statement.setInt(3, dto.getAge());
			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next()) {
				rv = rs.getLong(1);
			}

		} catch(SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
			try {
				statement.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		return rv;
	}

	@Override
	public int update(final RegistrationDTO dto) throws DAOException {
		String sql = "UPDATE REGISTRATION set last=? ,first=?, age=? where id=?";
		
		return updateInternally(sql, 
				statement -> {
					statement.setString(1, dto.getLastName());
					statement.setString(2, dto.getFirstName());
					statement.setInt(3, dto.getAge());
					statement.setLong(4, dto.getId());
				}
		);
//				new StatementPopulator() {
//			
//			@Override
//			public void populate(PreparedStatement statement) throws SQLException {
//				statement.setString(1, dto.getLastName());
//				statement.setString(2, dto.getFirstName());
//				statement.setInt(3, dto.getAge());
//				statement.setLong(4, dto.getId());
//			}
//				);
	}

	@Override
	public void delete(Long id) throws DAOException {
		PreparedStatement statement = null;
		try {
			String sql = "DELETE FROM REGISTRATION where id=? ";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
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

	@Override
	public RegistrationDTO find(Long id) throws DAOException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		RegistrationDTO rv = null;
		try {

			String sql = "select * from REGISTRATION where id = ?";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long rvid = resultSet.getLong("id");
				String firstName = resultSet.getString(2);
				String lastName = resultSet.getString("last");
				Integer age = resultSet.getInt("age");
				rv = new RegistrationDTO(rvid, lastName, firstName, age);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
			try {
				statement.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}

		}
		return rv;
	}

	@Override
	public List<RegistrationDTO> findAll() throws DAOException {

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<RegistrationDTO> rv = new ArrayList<RegistrationDTO>();
		try {

			String sql = "select * from REGISTRATION order by id asc";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String firstName = resultSet.getString(2);
				String lastName = resultSet.getString("last");
				Integer age = resultSet.getInt("age");
				rv.add(new RegistrationDTO(id, lastName, firstName, age));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
			try {
				statement.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}

		}
		return rv;
	}

}
