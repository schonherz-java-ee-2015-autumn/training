package hu.schonherz.training.java.language.object;

public class OuterClassTestMain {

	public static void main(String[] args) {
		 OuterClass outerClass = new OuterClass("test");
		
		 outerClass.print();
		
		 OuterClass.InnerClass innerClass = outerClass.new
		 InnerClass("test inner");
		
		 innerClass.print();
	}

}
