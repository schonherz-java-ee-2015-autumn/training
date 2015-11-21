package hu.neuron.java.common.dao;

import hu.neuron.java.common.dto.RoleDTO;

import java.util.List;

public interface RoleDAO extends BaseDAO<RoleDTO> {

	List<RoleDTO> findRolesByUserId(Long id);

	void addRoleToUser(Long roleId, Long userId);

	void removeRoleFromUser(Long roleId, Long userId);

	RoleDTO findRoleByName(String name);
}
