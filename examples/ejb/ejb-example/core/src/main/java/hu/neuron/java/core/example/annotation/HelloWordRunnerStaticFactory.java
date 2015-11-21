package hu.neuron.java.core.example.annotation;

public class HelloWordRunnerStaticFactory {

	private static HelloWordBean helloWordBean = new HelloWordBean();
	private static HelloWordRunner helloWordRunner = new HelloWordRunner();

	private HelloWordRunnerStaticFactory() {
	}

	public static HelloWordRunner createInstance() {
		helloWordRunner.setHelloWordBeanXML(helloWordBean);
		return helloWordRunner;
	}
}
