package hu.schonherz.training.java.api.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
	public static class WorkerTask implements Callable<String> {

		private String command;

		public WorkerTask(String s) {
			this.command = s;
		}

		@Override
		public String call() {
			System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
			String localCommand = processCommand();
			System.out.println(Thread.currentThread().getName() + " End.");
			return localCommand;
		}

		private String processCommand() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// ignore
			}
			return command;
		}

		@Override
		public String toString() {
			return this.command;
		}

	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		List<Future<String>> futures = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Future<String> future = executorService.submit(new WorkerTask("start" + i));
			futures.add(future);
		}

		for (Future<String> future : futures) {
			try {
				System.out.println("result: " + future.get());
			} catch (Exception e) {
				// ignore
			}

		}

		System.out.println("Finished all threads");
	}
}
