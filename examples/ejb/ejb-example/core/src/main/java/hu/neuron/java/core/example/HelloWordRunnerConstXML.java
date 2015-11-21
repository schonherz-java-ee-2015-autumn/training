package hu.neuron.java.core.example;

public class HelloWordRunnerConstXML {

	private HelloWordBeanXML helloWordBeanXML;

	public HelloWordRunnerConstXML(HelloWordBeanXML helloWordBeanXML) {
		super();
		this.helloWordBeanXML = helloWordBeanXML;
	}

	public void run() {
		helloWordBeanXML.hello();

	}

}
