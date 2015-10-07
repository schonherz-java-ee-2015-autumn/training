package hu.schonherz.training.java.api.threads;

public class ThreadsExample {
	public static boolean SIMPLE = false;

	public static void main(String[] args) {

		final Counter counter = new Counter();

		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					synchronized (counter) {
						String name = Thread.currentThread().getName();

						counter.increment(name);

						// if (!SIMPLE) {
						// System.out.println(name + " print " +
						// counter.value());
						// }

						if (SIMPLE) {
							System.out.println(counter.value());
						}
						counter.decrement(name);

						if (!SIMPLE) {
							System.out.println(name + " print " + counter.value());
						}

						if (SIMPLE) {
							System.out.println(counter.value());
						}

					}
				}
			});

			thread.start();
		}
	}
}
