package hu.neuron.java.core.entity;

import javax.persistence.Entity;

@Entity
public class Job extends BaseEntity {
	private static final long serialVersionUID = -2169633635591756782L;

	private double salery;
	private String jobDescr;

	public double getSalery() {
		return salery;
	}

	public void setSalery(double salery) {
		this.salery = salery;
	}

	public String getJobDescr() {
		return jobDescr;
	}

	public void setJobDescr(String jobDescr) {
		this.jobDescr = jobDescr;
	}

	@Override
	public String toString() {
		return "Job [salery=" + salery + ", jobDescr=" + jobDescr + "]";
	}

}