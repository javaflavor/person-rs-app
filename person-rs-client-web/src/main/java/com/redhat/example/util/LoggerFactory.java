package com.redhat.example.util;

import java.util.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@Dependent
public class LoggerFactory {
	@Produces
	public Logger getLogger(InjectionPoint injectionPoint) throws Exception {
		// Obtain the class name on the injection point.
		String name = injectionPoint.getMember().getDeclaringClass().getName();
		return Logger.getLogger(name);
	}
}
