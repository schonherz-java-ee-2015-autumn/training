package hu.neuron.java.core.test.example;

import hu.neuron.java.core.example.java.AppConfig;
import hu.neuron.java.core.example.java.HelloWordBeanJava;
import hu.neuron.java.core.example.java.HelloWordRunnerJava;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWordTestJava {

	@Test
	public void test() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.scan("hu.neuron.java.core.example.java");
		ctx.refresh();

		HelloWordBeanJava bean = ctx.getBean(HelloWordBeanJava.class);
		bean.hello();

		HelloWordRunnerJava runnerJava = ctx.getBean(HelloWordRunnerJava.class);

		runnerJava.run();
		((ConfigurableApplicationContext) ctx).close();
	}

}
