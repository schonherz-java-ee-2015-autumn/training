package hu.neruon.java.ejb.client.service;

import hu.neruon.java.ejb.client.vo.UserVO;

import javax.ejb.Remote;

@Remote
public interface UserServiceBeanRemote {

	public UserVO findUserByName(String name) throws Exception;

	public void registrationUser(UserVO userVO) throws Exception;

}
