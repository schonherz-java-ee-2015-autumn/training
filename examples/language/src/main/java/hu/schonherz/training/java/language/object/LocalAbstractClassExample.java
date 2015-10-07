package hu.schonherz.training.java.language.object;

public class LocalAbstractClassExample {

	private String field = "test";

	public void test() {
		// final String field = "outer";

		abstract class LocalClass {
			private String field = "inner";

			abstract void print();
		}

		LocalClass localClass = new LocalClass() {

			@Override
			void print() {
				// field = "method";
				System.out.println(super.field);

			}
		};

		localClass.print();
	}

	public static void main(String[] args) {
		LocalAbstractClassExample classExample = new LocalAbstractClassExample();
		classExample.test();
	}

}
