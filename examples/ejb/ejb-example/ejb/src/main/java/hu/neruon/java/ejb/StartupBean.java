package hu.neruon.java.ejb;

import java.util.Date;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.log4j.Logger;

@Startup
@Singleton
public class StartupBean {

	private static final Logger logger = Logger.getLogger(StartupBean.class);

	@EJB
	SimpleAsynchronous asynchronous;

	@PostConstruct
	public void init() {
		try {
			Future<Date> future = asynchronous.asynchronousPrintTime();

			System.out.println("asynchronousPrintTime is done: "
					+ future.isDone());

			while (!future.isDone()) {

				Thread.sleep(1000);

				logger.debug(new Date().toString() + " Waiting ...");

			}

			logger.debug("asynchronousPrintTime is done: " + future.isDone()
					+ " at " + future.get());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}