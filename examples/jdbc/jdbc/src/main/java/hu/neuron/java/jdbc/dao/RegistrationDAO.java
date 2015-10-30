package hu.neuron.java.jdbc.dao;

import hu.neuron.java.jdbc.dto.RegistrationDTO;

import java.util.List;

public interface RegistrationDAO {

	public Long save(RegistrationDTO dto) throws DAOException;

	public int update(RegistrationDTO dto) throws DAOException;

	public void delete(Long id) throws DAOException;

	public RegistrationDTO find(Long id) throws DAOException;

	public List<RegistrationDTO> findAll() throws DAOException;

}
