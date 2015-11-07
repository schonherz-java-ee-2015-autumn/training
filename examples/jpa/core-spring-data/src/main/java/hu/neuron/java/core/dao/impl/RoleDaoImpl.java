package hu.neuron.java.core.dao.impl;

import hu.neuron.java.common.dao.RoleDAO;
import hu.neuron.java.common.dto.RoleDTO;
import hu.neuron.java.core.entity.Role;
import hu.neuron.java.core.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class RoleDaoImpl implements BaseConvertDao<Role, RoleDTO>, RoleDAO {
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role toEntity(RoleDTO dto, Role entity) {
		Role ret = entity;
		if (dto.getId() == null || entity == null) {
			ret = new Role();

		}
		ret.setId(dto.getId());
		ret.setName(dto.getName());
		return ret;
	}

	@Override
	public RoleDTO toDto(Role entity) {
		RoleDTO ret = new RoleDTO();
		if (entity == null) {
			return null;
		}
		ret.setName(entity.getName());
		ret.setId(entity.getId());

		return ret;
	}

	@Override
	public List<RoleDTO> findRolesByUserId(Long id) throws Exception {
		List<Role> resultList = roleRepository.findRolesByUserId(id);

		List<RoleDTO> rv = new ArrayList<RoleDTO>();
		for (Role e : resultList) {
			rv.add(toDto(e));
		}
		return rv;

	}

	@Override
	public void addRoleToUser(Long roleId, Long userId) throws Exception {
		roleRepository.addRoleToUser(roleId, userId);
	}

	@Override
	public void removeRoleFromUser(Long roleId, Long userId) throws Exception {
		roleRepository.removeRoleFromUser(roleId, userId);

	}

	@Override
	public RoleDTO findRoleByName(String name) throws Exception {
		Role rv = roleRepository.findRoleByName(name);
		return toDto(rv);
	}

	@Override
	public Long save(RoleDTO dto) throws Exception {

		return saveEntity(toEntity(dto, null));
	}

	@Override
	public void update(RoleDTO dto) throws Exception {
		Role entity = toEntity(dto, null);
		this.updateEntity(entity);

	}

	@Override
	public void delete(Long id) throws Exception {
		deleteEntity(id);
	}

	@Override
	public RoleDTO find(Long id) throws Exception {
		return toDto(findEntity(id));
	}

	@Override
	public List<RoleDTO> findAll() throws Exception {
		List<Role> resultList = findAllEntity();
		List<RoleDTO> rv = new ArrayList<RoleDTO>();
		for (Role e : resultList) {
			rv.add(toDto(e));
		}
		return rv;
	}

	@Override
	public Long saveEntity(Role entity) throws Exception {
		Role role = roleRepository.save(entity);
		return role.getId();
	}

	@Override
	public void updateEntity(Role entity) throws Exception {
		roleRepository.save(entity);

	}

	@Override
	public void deleteEntity(Long id) throws Exception {
		roleRepository.delete(id);

	}

	@Override
	public Role findEntity(Long id) throws Exception {
		return roleRepository.findOne(id);
	}

	@Override
	public List<Role> findAllEntity() throws Exception {
		return roleRepository.findAll();
	}

}
