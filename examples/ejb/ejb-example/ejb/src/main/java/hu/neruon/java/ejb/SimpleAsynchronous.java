package hu.neruon.java.ejb;

import java.util.Date;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Singleton;

import org.apache.log4j.Logger;

@Singleton
public class SimpleAsynchronous {

	private static final Logger logger = Logger
			.getLogger(SimpleAsynchronous.class);

	@Asynchronous
	public Future<Date> asynchronousPrintTime() {
		logger.debug("call printTime");
		try {
			Thread.sleep(5 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AsyncResult<Date>(new Date());
	}
}
