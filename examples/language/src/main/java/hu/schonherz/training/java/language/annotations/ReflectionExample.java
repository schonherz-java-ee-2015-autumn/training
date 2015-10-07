package hu.schonherz.training.java.language.annotations;

public class ReflectionExample {

	public static void main(String[] args) {
		Class<Impl> implClass = Impl.class;
		if (implClass.isAnnotationPresent(RuntimeLevelAnnoation.class)) {

			RuntimeLevelAnnoation annotation = implClass.getAnnotation(RuntimeLevelAnnoation.class);
			RuntimeLevelAnnoation testerInfo = (RuntimeLevelAnnoation) annotation;

			System.out.println(testerInfo.test());

		}
	}
}
