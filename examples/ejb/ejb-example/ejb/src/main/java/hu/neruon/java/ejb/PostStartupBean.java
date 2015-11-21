package hu.neruon.java.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.log4j.Logger;

@Startup
@Singleton
@DependsOn("StartupBean")
public class PostStartupBean {

	private static final Logger logger = Logger
			.getLogger(PostStartupBean.class);

	@PostConstruct
	void init() {

		logger.debug("PostStartupBean start");
	}
}