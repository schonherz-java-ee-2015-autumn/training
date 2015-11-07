package hu.neuron.java.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import hu.neuron.java.common.dao.RoleDAO;
import hu.neuron.java.common.dao.UserDAO;
import hu.neuron.java.common.dto.UserDTO;
import hu.neuron.java.core.entity.User;
import hu.neuron.java.core.repository.UserRepository;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class UserDaoImpl implements BaseConvertDao<User, UserDTO>, UserDAO {

	@Autowired
	UserRepository userRepository;

	@Override
	public User toEntity(UserDTO dto, User entity) {
		User ret = entity;
		if (dto.getId() == null || entity == null) {
			ret = new User();
			ret.setId(dto.getId());

		}
		ret.setId(dto.getId());
		ret.setUserName(dto.getUserName());
		ret.setPassword(dto.getPassword());

		return ret;
	}

	@Override
	public UserDTO toDto(User entity) {
		UserDTO ret = new UserDTO();
		if (entity == null) {
			return null;
		}
		ret.setId(entity.getId());
		ret.setUserName(entity.getUserName());
		ret.setPassword(entity.getPassword());

		return ret;
	}

	@Override
	public UserDTO findUserByName(String name) throws Exception {
		User rv = userRepository.findUserByUserName(name);
		return toDto(rv);
	}

	@Override
	public Long save(UserDTO dto) throws Exception {
		return saveEntity(toEntity(dto, null));
	}

	@Override
	public void update(UserDTO dto) throws Exception {
		User entity = toEntity(dto, null);
		this.updateEntity(entity);

	}

	@Override
	public void delete(Long id) throws Exception {
		deleteEntity(id);
	}

	@Override
	public UserDTO find(Long id) throws Exception {
		return toDto(findEntity(id));
	}

	@Override
	public List<UserDTO> findAll() throws Exception {
		List<User> resultList = findAllEntity();
		List<UserDTO> rv = new ArrayList<UserDTO>();
		for (User e : resultList) {
			rv.add(toDto(e));
		}
		return rv;
	}

	@Override
	public Long saveEntity(User entity) throws Exception {
		User user = userRepository.save(entity);
		return user.getId();
	}

	@Override
	public void updateEntity(User entity) throws Exception {
		userRepository.save(entity);

	}

	@Override
	public void deleteEntity(Long id) throws Exception {
		userRepository.delete(id);

	}

	@Override
	public User findEntity(Long id) throws Exception {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findAllEntity() throws Exception {
		return userRepository.findAll();
	}

}
