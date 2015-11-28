package hu.neuron.java.web;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService 
public interface WebServiceExample {
	@WebMethod
	public String echo(String message);
}
