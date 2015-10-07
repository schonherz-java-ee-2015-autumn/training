package hu.schonherz.training.java.language.object;

public class LocalClassExample {

	private String field = "test";

	public void test() {
//		final String field = "outer";

		class LocalClass {
//			 private String field = "inner";
			void print() {
				// field = "method";
				System.out.println(field);
			}
		}

		LocalClass localClass = new LocalClass();

		localClass.print();
	}

	public static void main(String[] args) {
		LocalClassExample classExample = new LocalClassExample();
		classExample.test();
	}

}
