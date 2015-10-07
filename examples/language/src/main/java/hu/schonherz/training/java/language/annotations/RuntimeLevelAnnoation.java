package hu.schonherz.training.java.language.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RuntimeLevelAnnoation {
	
	String test();

}
