package hu.neuron.java.jdbc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementPopulator {

	void populate(PreparedStatement statement) throws SQLException;

}
