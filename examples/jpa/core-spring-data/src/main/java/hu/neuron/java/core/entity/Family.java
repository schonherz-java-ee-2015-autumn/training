package hu.neuron.java.core.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Family extends BaseEntity {

	private static final long serialVersionUID = 1056773191597068617L;

	private String description;

//	@OneToMany(mappedBy = "family", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Person> members = new ArrayList<Person>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public List<Person> getMembers() {
//		return members;
//	}
//
//	public void setMembers(List<Person> members) {
//		this.members = members;
//	}

	@Override
	public String toString() {
		return "Family [description=" + description
		// + ", members=" + members
				+ "]";
	}

}