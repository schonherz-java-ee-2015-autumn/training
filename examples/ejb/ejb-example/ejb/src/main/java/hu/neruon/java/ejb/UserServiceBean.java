package hu.neruon.java.ejb;

import hu.neruon.java.ejb.client.service.UserServiceBeanLocal;
import hu.neruon.java.ejb.client.service.UserServiceBeanRemote;
import hu.neruon.java.ejb.client.vo.UserVO;
import hu.neruon.java.ejb.converter.RoleConverter;
import hu.neruon.java.ejb.converter.UserConverter;
import hu.neuron.java.common.dao.RoleDAO;
import hu.neuron.java.common.dao.UserDAO;
import hu.neuron.java.common.dto.RoleDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

/**
 * Session Bean implementation class UserServiceBean
 */

@Stateless(mappedName = "UserServiceBean")
@Interceptors({ SpringBeanAutowiringInterceptor.class, SimpleInterceptor.class })
public class UserServiceBean implements UserServiceBeanRemote, UserServiceBeanLocal {
	@Autowired
	UserDAO userDAO;

	@Autowired
	RoleDAO roleDAO;

	@EJB
	RoleConverter roleConverter;

	@EJB
	UserConverter userConverter;

	public UserServiceBean() {
	}

	@Override
	public UserVO findUserByName(String name) throws Exception {
		return userConverter.toVO(userDAO.findUserByName(name));
	}

	@Override
	public void registrationUser(UserVO userVO) throws Exception {

		Long userId = userDAO.save(userConverter.toDTO(userVO));
		RoleDTO userRole = roleDAO.findRoleByName("USER");
		roleDAO.addRoleToUser(userRole.getId(), userId);
	}

}
