package hu.neuron.java.service.vo;

import java.io.Serializable;
import java.util.List;

public class UserVO implements Serializable {

	private static final long serialVersionUID = 5932000328505763772L;

	private Long id;
	private String username;
	private String password;
	private List<RoleVO> roles;

	private byte[] image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
