package hu.neuron.java.web.impl;

import javax.jws.WebService;

import hu.neuron.java.web.WebServiceExample;

@WebService(endpointInterface = "hu.neuron.java.web.WebServiceExample")
public class WebServiceExampleImpl implements WebServiceExample {

	public String echo(String message) {
		System.out.println(message);
		return "WebServiceExample: " + message;
	}
}
