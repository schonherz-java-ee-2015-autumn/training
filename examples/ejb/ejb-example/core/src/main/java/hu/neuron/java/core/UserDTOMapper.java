package hu.neuron.java.core;

import hu.neuron.java.common.dto.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public  final class UserDTOMapper implements RowMapper<UserDTO> {

	public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(rs.getLong("id"));
		userDTO.setUserName(rs.getString("name"));
		userDTO.setPassword(rs.getString("password"));
		return userDTO;
	}
}
