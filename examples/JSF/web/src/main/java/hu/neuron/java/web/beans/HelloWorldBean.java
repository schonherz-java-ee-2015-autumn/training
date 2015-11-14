package hu.neuron.java.web.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloWorldBean {

	private String message = "Hello World!";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
