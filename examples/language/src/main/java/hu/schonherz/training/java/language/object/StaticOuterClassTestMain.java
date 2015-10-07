package hu.schonherz.training.java.language.object;

public class StaticOuterClassTestMain {

	public static void main(String[] args) {
		
		 StaticOuterClass staticOuterClass = new StaticOuterClass("test");
		
		 staticOuterClass.print();
		
		 StaticOuterClass.StaticInnerClass staticInnerClass = new
		 StaticOuterClass.StaticInnerClass(
		 "test");
		
		 staticInnerClass.print();
	}

}
