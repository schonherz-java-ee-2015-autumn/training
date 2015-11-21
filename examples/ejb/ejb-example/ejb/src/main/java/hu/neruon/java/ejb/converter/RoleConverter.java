package hu.neruon.java.ejb.converter;

import hu.neruon.java.ejb.SimpleInterceptor;
import hu.neruon.java.ejb.client.vo.RoleVO;
import hu.neuron.java.common.dto.RoleDTO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.interceptor.Interceptors;

@Singleton
@Interceptors(SimpleInterceptor.class)
public class RoleConverter {
	public RoleVO toVO(RoleDTO dto) {
		if (dto == null) {
			return null;
		}
		RoleVO vo = new RoleVO();
		vo.setId(dto.getId());
		vo.setName(dto.getName());
		return vo;
	}

	public List<RoleVO> toVO(List<RoleDTO> dtos) {
		if (dtos == null) {
			return null;
		}
		List<RoleVO> vos = new ArrayList<RoleVO>();
		for (RoleDTO dto : dtos) {
			vos.add(toVO(dto));
		}
		return vos;
	}

	public RoleDTO toDTO(RoleVO vo) {
		if (vo == null) {
			return null;
		}
		RoleDTO dto = new RoleDTO();
		dto.setId(vo.getId());
		dto.setName(vo.getName());
		return dto;
	}

	public List<RoleDTO> toDTO(List<RoleVO> vos) {
		if (vos == null) {
			return null;
		}
		List<RoleDTO> dtos = new ArrayList<RoleDTO>();
		for (RoleVO vo : vos) {
			dtos.add(toDTO(vo));
		}
		return dtos;
	}

}
