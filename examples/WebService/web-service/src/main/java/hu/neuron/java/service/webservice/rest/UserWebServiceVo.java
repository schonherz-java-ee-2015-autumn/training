package hu.neuron.java.service.webservice.rest;

import hu.neuron.java.service.vo.RoleVO;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserVo")
public class UserWebServiceVo implements Serializable {

	private static final long serialVersionUID = 5932000328505763772L;

	private String username;
	private String password;
	private List<RoleVO> roles;

	private byte[] image;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RoleVO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleVO> roles) {
		this.roles = roles;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
