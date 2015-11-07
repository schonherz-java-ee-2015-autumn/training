package hu.neuron.java.core.test;

import hu.neuron.java.common.dao.UserDAO;
import hu.neuron.java.common.dto.UserDTO;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-core.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class UserDAOImplTest {

	private static final Logger logger = Logger.getLogger(UserDAOImplTest.class);

	private static UserDTO dto;

	@Autowired
	UserDAO dao;

	@Test
	public void test1Save() {
		try {
			dto = new UserDTO(null, "A", "B");

			Long id = dao.save(dto);
			logger.debug("id: " + id);

			dto.setId(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test2Update() {
		try {
			dto.setUserName("C");
			dao.update(dto);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test5Delete() {
		try {
			dao.delete(dto.getId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test3Find() {
		try {
			UserDTO rvDTO = dao.find(dto.getId());
			logger.debug("rv: " + rvDTO);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test4Find() {
		try {
			UserDTO rvDTO = dao.findUserByName(dto.getUserName());
			logger.debug("rv: " + rvDTO);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test5FindAll() {
		try {
			List<UserDTO> dtos = dao.findAll();
			for (UserDTO userDTO : dtos) {
				logger.debug("rv: " + userDTO);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

}
