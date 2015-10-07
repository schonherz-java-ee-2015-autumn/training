package hu.schonherz.training.java.language.annotations;

@SourceLevelAnnotation(part = @SourceLevelAnnotationPart(description = "classTest"), test = "classTest")
@RuntimeLevelAnnoation(test = "test")
public class Impl {
	@SourceLevelAnnotation(part = @SourceLevelAnnotationPart(description = "classTest"), test = "classTest")
	private String string;

	@SourceLevelAnnotation(part = @SourceLevelAnnotationPart(description = "classTest"), test = "classTest")
	public Impl() {
	}

	@SourceLevelAnnotation(part = @SourceLevelAnnotationPart(description = "classTest"), test = "classTest")
	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

}
