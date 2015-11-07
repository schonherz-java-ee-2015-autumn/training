package hu.neuron.java.core.test;

import java.util.List;

import hu.neuron.java.core.entity.Role;
import hu.neuron.java.core.entity.User;
import hu.neuron.java.core.repository.RoleRepository;
import hu.neuron.java.core.repository.UserRepository;

import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-core.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class RoleRepositoryTest {

	private static final Logger logger = Logger
			.getLogger(UserRepositoryTest.class);
	private static Role role;
	private static User user;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	public void test1Save() {
		role = new Role();
		role.setName("USER");
		roleRepository.save(role);
	}

	@Test
	public void test2Update() {

		role.setName("ADMIN");
		role = roleRepository.save(role);
	}

	@Test
	public void test3Find() {
		try {
			Role rolerv = roleRepository.findOne(role.getId());
			logger.info("rv: " + rolerv);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test4Find() {
		try {
			Role rolerv = roleRepository.findRoleByName(role.getName());
			logger.info("rv: " + rolerv);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test5FindAll() {

		try {
			List<Role> roles = roleRepository.findAll();
			for (Role userDTO : roles) {
				logger.info("rv: " + userDTO);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test6Delete() {
		roleRepository.delete(role.getId());

	}

	@Test
	public void test7AddRoleToUser() {
		try {
			user = new User();
			user.setUserName("test");
			user.setPassword("test");
			user = userRepository.save(user);
			logger.info("user: " + user);

			role = new Role();
			role.setName("USER");
			roleRepository.save(role);

			logger.info("role: " + role);

			roleRepository.addRoleToUser(role.getId(), user.getId());

			role = new Role();
			role.setName("ACCOUNTANT");
			roleRepository.save(role);

			logger.info("role: " + role);

			roleRepository.addRoleToUser(role.getId(), user.getId());
		
			Sort sort = new Sort(Sort.Direction.ASC, "name");
			Pageable pageRequest1 = new PageRequest(0, 1, sort);
			
			Page<Role> result1 = roleRepository.getRolesByUserId(user.getId(), pageRequest1);
			
			Pageable pageRequest2 = result1.nextPageable();
			Page<Role> result2 = roleRepository.getRolesByUserId(user.getId(), pageRequest2);
			
			logger.info("result1: " + result1);
			logger.info("result2: " + result2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test8FindRolesByUserId() {
		try {
			List<Role> roles = roleRepository.findRolesByUserId(user.getId());

			for (Role userDTO : roles) {
				logger.info("rv: " + userDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test9RemoveRoleFromUser() {
		try {
			roleRepository.removeRoleFromUser(role.getId(), user.getId());

			List<Role> roles = roleRepository.findRolesByUserId(user.getId());

			for (Role userDTO : roles) {
				logger.info("rv: " + userDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
