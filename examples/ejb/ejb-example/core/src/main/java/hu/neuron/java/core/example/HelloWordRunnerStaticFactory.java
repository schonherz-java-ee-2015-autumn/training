package hu.neuron.java.core.example;

public class HelloWordRunnerStaticFactory {

	private static HelloWordBeanXML helloWordBeanXML = new HelloWordBeanXML();
	private static HelloWordRunnerXML helloWordRunnerXML = new HelloWordRunnerXML();

	private HelloWordRunnerStaticFactory() {
	}

	public static HelloWordRunnerXML createInstance() {
		helloWordRunnerXML.setHelloWordBeanXML(helloWordBeanXML);
		return helloWordRunnerXML;
	}
}
