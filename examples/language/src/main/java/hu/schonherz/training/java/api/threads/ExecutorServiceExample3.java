package hu.schonherz.training.java.api.threads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample3 {
	public static class WorkerTask implements Callable<String> {

		private String command;

		public WorkerTask(String s) {
			this.command = s;
		}

		@Override
		public String call() {
			System.out.println(Thread.currentThread().getName() + " " + new Date() + " Start. Command = " + command);
			String localCommand = processCommand();
			System.out.println(Thread.currentThread().getName() + " End.");
			return localCommand;
		}

		private String processCommand() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return command;
		}

		@Override
		public String toString() {
			return this.command;
		}

	}

	public static void main(String[] args) {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
		List<Future<String>> futures = new ArrayList<>();
		System.out.println(new Date());
		for (int i = 0; i < 10; i++) {
			Future<String> future = executorService.schedule(new WorkerTask("start" + i), 2, TimeUnit.SECONDS);
			futures.add(future);
		}
		

		for (Future<String> future : futures) {
			try {
				System.out.println("result: " + future.get());
			} catch (Exception e) {

			}

		}

		System.out.println("Finished all threads");
	}
}
