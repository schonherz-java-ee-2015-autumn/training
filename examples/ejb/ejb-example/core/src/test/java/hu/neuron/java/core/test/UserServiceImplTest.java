//package hu.neuron.java.core.test;
//
//import hu.neruon.java.ejb.vo.UserVO;
//import hu.neuron.java.common.dao.UserService;
//
//import org.apache.log4j.Logger;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("/spring-test-core.xml")
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class UserServiceImplTest {
//	private static final Logger logger = Logger.getLogger(UserDAOTest.class);
//
//	@Autowired
//	UserService service;
//
//	@Test
//	public void test1Reg() {
//		UserVO userVO = new UserVO();
//		userVO.setUserName("Alma");
//		userVO.setPassword("Alma");
//		try {
//			service.registrationUser(userVO);
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw new RuntimeException(e);
//		}
//	}
//
//	@Test
//	public void test2Find() {
//
//		try {
//			UserVO userVO = service.findUserByName("Alma");
//
//			logger.debug(userVO);
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw new RuntimeException(e);
//		}
//	}
//
//}
