package hu.neruon.java.ejb;

import java.util.Date;

import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Singleton;

import org.apache.log4j.Logger;

@Singleton
public class SimpleTimer {

	private static final Logger logger = Logger.getLogger(SimpleTimer.class);

	@Schedules({ @Schedule(hour = "*", minute = "*", second = "10"),
			@Schedule(hour = "*", minute = "*", second = "45") })
	public void printTime() {
		logger.debug(getClass().getName() + ": " + new Date());
	}
}
