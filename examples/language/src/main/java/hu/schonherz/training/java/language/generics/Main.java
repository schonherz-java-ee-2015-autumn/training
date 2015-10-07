package hu.schonherz.training.java.language.generics;

public class Main {

	public static void main(String[] args) {

		Box<String> stringBox = new Box<>();
		stringBox.set("10");
		System.out.println(stringBox);

		Util.print("Test");

		Util.print(stringBox);

		Box<String> rawBox = stringBox;
		System.out.println(stringBox);

		String string = stringBox.get();

	}
}
