package DEMO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JDemo {
	
	static Logger logger = LogManager.getLogger(Log4JDemo.class);

	
	public static void main(String[] args) {
		
		System.out.println("\nHello world\n");
		
		logger.trace("This is trace message");
		logger.info("This is info message");
		logger.error("This is an error message");
		logger.warn("This is an warning message");
		logger.fatal("This is an fatal message");

		System.out.println("\nCompleted");
	}
}
