package hu.schonherz.training.java.language.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SourceLevelAnnotationPart {

	String description();
	
}
