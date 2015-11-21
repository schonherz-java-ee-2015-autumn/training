package hu.neuron.java.core.example;


public class HelloWordRunnerXML {

	private HelloWordBeanXML helloWordBeanXML;

	public HelloWordBeanXML getHelloWordBeanXML() {
		return helloWordBeanXML;
	}

//	@Required
	public void setHelloWordBeanXML(HelloWordBeanXML helloWordBeanXML) {
		this.helloWordBeanXML = helloWordBeanXML;
	}

	public void run() {
		helloWordBeanXML.hello();

	}
}
