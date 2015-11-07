package hu.neuron.java.core.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Person extends BaseEntity {

	private static final long serialVersionUID = -4635014160054871742L;

	private String firstName;
	private String lastName;

	@ManyToOne(fetch = FetchType.EAGER)
	private Family family;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Job job;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// Leave the standard column name of the table
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Person [id = " + getId() + " firstName=" + firstName
				+ ", lastName=" + lastName
				// + ", family=" + family
				// + ", job=" + job
				+ "]";
	}

}