package hu.neuron.java.core;

import hu.neuron.java.common.dto.RoleDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public final class RoleDTOMapper implements RowMapper<RoleDTO> {

	public RoleDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setId(rs.getLong("id"));
		roleDTO.setName(rs.getString("name"));
		return roleDTO;
	}
}