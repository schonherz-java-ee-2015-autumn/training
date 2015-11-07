package hu.neuron.java.core.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The Class of Role.
 */
@Entity
@Table(name = "Role")
@NamedQueries({ @NamedQuery(name = "Role.findRolesByUserId", query = "select roles from User u join u.roles roles where u.id=?1") })
public class Role extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;

	@ManyToMany(fetch=FetchType.LAZY, mappedBy="roles")
	private Collection<User> user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Collection<User> getUser() {
		return user;
	}
	
	@Override
	public String toString() {
		return "Role [name=" + name + ", getId()=" + getId() + "]";
	}

}
