package hu.neuron.java.service;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import hu.neuron.java.service.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-service.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class UserServiceTest {

	@Autowired
	UserService userService;

	@Test
	public void test1() {
		UserVO userVO = new UserVO();
		userVO.setUsername("test");
		userVO.setPassword("test");

		try {
			userService.registrationUser(userVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {

	}

}
