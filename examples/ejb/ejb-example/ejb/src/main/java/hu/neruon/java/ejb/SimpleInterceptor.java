package hu.neruon.java.ejb;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

public class SimpleInterceptor {
	private static final Logger logger = Logger
			.getLogger(SimpleInterceptor.class);

	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {

		logger.debug("BEFORE calling method :" + context.getMethod().getName());

		Object result = context.proceed();

		logger.debug("AFTER calling method :" + context.getMethod().getName());

		return result;
	}
}