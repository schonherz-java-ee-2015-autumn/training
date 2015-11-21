package hu.neuron.java.core.example;

public class HelloWordRunnerFactory {

	private HelloWordBeanXML helloWordBeanXML;
	private static HelloWordRunnerXML helloWordRunnerXML = new HelloWordRunnerXML();

	private HelloWordRunnerFactory() {
	}

	public HelloWordRunnerXML createInstance() {
		helloWordRunnerXML.setHelloWordBeanXML(helloWordBeanXML);
		return helloWordRunnerXML;
	}

	public HelloWordBeanXML getHelloWordBeanXML() {
		return helloWordBeanXML;
	}

	public void setHelloWordBeanXML(HelloWordBeanXML helloWordBeanXML) {
		this.helloWordBeanXML = helloWordBeanXML;
	}
}
