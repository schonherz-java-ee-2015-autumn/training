package hu.schonherz.training.java.api.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample4 {
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
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

		for (int i = 0; i < 10; i++) {
			executorService.scheduleAtFixedRate(new WorkerTask("start" + i), 2l, 2l, TimeUnit.SECONDS);

		}

		
	}
}
