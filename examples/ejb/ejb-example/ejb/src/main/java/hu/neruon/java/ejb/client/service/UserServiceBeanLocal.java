package hu.neruon.java.ejb.client.service;

import hu.neruon.java.ejb.client.vo.UserVO;

import javax.ejb.Local;

@Local
public interface UserServiceBeanLocal {

	public UserVO findUserByName(String name) throws Exception;

	public void registrationUser(UserVO userVO) throws Exception;
}
