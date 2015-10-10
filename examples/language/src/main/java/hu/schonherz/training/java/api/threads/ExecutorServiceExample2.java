package hu.schonherz.training.java.api.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample2 {
	public static class WorkerTask implements Runnable {

		private String command;

		public WorkerTask(String s) {
			this.command = s;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
			processCommand();
			System.out.println(Thread.currentThread().getName() + " End.");
		}

		private void processCommand() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Override
		public String toString() {
			return this.command;
		}
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++) {
			executorService.execute(new WorkerTask("start" + i));
		}

		System.out.println(executorService);
		executorService.shutdown();

		while (!executorService.isTerminated()) {
		}
		
		System.out.println("Finished all threads");
	}
}
