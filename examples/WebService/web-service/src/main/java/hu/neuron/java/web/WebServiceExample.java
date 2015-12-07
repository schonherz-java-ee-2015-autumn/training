package hu.neuron.java.web;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService 
public interface WebServiceExample {
	@WebMethod(operationName="echoService")
	@WebResult(name="response")
	public String echo(@WebParam(name="message") String message);
}
