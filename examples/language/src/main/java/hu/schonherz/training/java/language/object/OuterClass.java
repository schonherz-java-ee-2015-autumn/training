package hu.schonherz.training.java.language.object;

public class OuterClass {

	private String field;

	public OuterClass(String field) {
		this.field = field;

	}

	public void print() {
		System.out.println("outer :" + field);
		InnerClass innerClass = new InnerClass(field + " inner");
		innerClass.print();
	}

	public class InnerClass {
		private String fieldinner;

		public InnerClass(String fieldinner) {
			this.fieldinner = fieldinner;
		}

		public void print() {
			System.out.println("inner:" + fieldinner);
			System.out.println("outer:" + OuterClass.this.field);
		}
	}
}
