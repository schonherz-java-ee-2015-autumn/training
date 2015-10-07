package hu.schonherz.training.java.language.object;

public class AnonymousExample {

	final String field = "Hello outer";

	interface InnerInterfaceForAnonymousClass {
		void print();
	}

	public static void main(String[] args) {
		AnonymousExample anonymousExample = new AnonymousExample();
		anonymousExample.test();
	}

	private void test() {
//		final String field = "Hello";
		final InnerInterfaceForAnonymousClass anonymousClassInstance = new InnerInterfaceForAnonymousClass() {
//			final String field = "Hello inner";

			@Override
			public void print() {
				System.out.println(field);
				AnonymousExample.this.print();
			}
		};

		anonymousClassInstance.print();

	}

	private void print() {
		System.out.println(field);

	}
}
