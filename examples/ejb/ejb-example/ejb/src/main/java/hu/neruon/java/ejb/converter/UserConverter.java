package hu.neruon.java.ejb.converter;

import hu.neruon.java.ejb.SimpleInterceptor;
import hu.neruon.java.ejb.client.vo.UserVO;
import hu.neuron.java.common.dao.RoleDAO;
import hu.neuron.java.common.dto.RoleDTO;
import hu.neuron.java.common.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Singleton
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class UserConverter {

	@Autowired
	RoleDAO roleDAO;

	@EJB
	RoleConverter roleConverter;

	@Interceptors(SimpleInterceptor.class)
	public UserVO toVO(UserDTO dto) {
		if (dto == null) {
			return null;
		}
		UserVO vo = new UserVO();
		vo.setId(dto.getId());
		vo.setPassword(dto.getPassword());
		vo.setUserName(dto.getUserName());
		List<RoleDTO> roles = roleDAO.findRolesByUserId(dto.getId());
		vo.setRoles(roleConverter.toVO(roles));
		return vo;
	}

	@Interceptors(SimpleInterceptor.class)
	public List<UserVO> toVO(List<UserDTO> dtos) {
		if (dtos == null) {
			return null;
		}
		List<UserVO> vos = new ArrayList<UserVO>();
		for (UserDTO dto : dtos) {
			vos.add(toVO(dto));
		}
		return vos;
	}

	public UserDTO toDTO(UserVO vo) {
		if (vo == null) {
			return null;
		}
		UserDTO dto = new UserDTO();
		dto.setId(vo.getId());
		dto.setPassword(vo.getPassword());
		dto.setUserName(vo.getUserName());
		return dto;
	}

	public List<UserDTO> toDTO(List<UserVO> vos) {
		if (vos == null) {
			return null;
		}
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		for (UserVO vo : vos) {
			dtos.add(toDTO(vo));
		}
		return dtos;
	}
}
