package hu.neuron.java.web;

import java.io.Serializable;

public class Helper implements Serializable {

	private static final long serialVersionUID = 1L;

	private String label;
	private String value;

	public Helper() {
	}

	public Helper(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
