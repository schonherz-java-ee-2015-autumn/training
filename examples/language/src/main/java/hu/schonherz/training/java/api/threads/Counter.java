package hu.schonherz.training.java.api.threads;

class Counter {
	private int c = 0;

	public void increment(String name) {
		c++;
		if (!ThreadsExample.SIMPLE) {
			System.out.println(name + " increment " + c);
		}
	}

	public void decrement(String name) {
		c--;
		if (!ThreadsExample.SIMPLE) {
			System.out.println(name + " decrement " + c);
		}
	}

	public  int value() {

		return c;

	}

}