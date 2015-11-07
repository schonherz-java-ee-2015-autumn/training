package hu.neuron.java.common.dao;

import hu.neuron.java.common.dto.UserDTO;

public interface UserDAO extends BaseDAO<UserDTO> {

	UserDTO findUserByName(String name) throws Exception;

}
