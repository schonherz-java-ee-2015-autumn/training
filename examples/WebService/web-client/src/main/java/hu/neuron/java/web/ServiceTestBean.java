package hu.neuron.java.web;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.namespace.QName;

@ManagedBean("serviceTestBean")
@SessionScoped
public class ServiceTestBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;

	private String echo;

	public void test() {
		URL wsdl = null;
		try {
			wsdl = new URL(
					"http://localhost:7001/service/WebServiceExampleImplService?wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		QName qName = new QName("http://web.java.neuron.hu/",
				"WebServiceExampleImplService");
		WebServiceExampleImplService exampleImplService = new WebServiceExampleImplService(
				wsdl, qName);

		WebServiceExample exampleImpl = exampleImplService
				.getWebServiceExampleImplPort();

		echo = exampleImpl.echo(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEcho() {
		return echo;
	}

	public void setEcho(String echo) {
		this.echo = echo;
	}
}
