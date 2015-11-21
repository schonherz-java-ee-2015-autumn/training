package hu.neuron.java.core.example.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public HelloWordBeanJava helloWordBean() {
		return new HelloWordBeanJava();
	}
}
