package com.ideas2it.hirepro.customLogger;

import java.lang.Throwable;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CustomLogger {
    private static Logger logger;
 
    public CustomLogger(Class<?> className) {
        logger = LogManager.getLogger(className);
    }
        
    public static void info(String message) {
        logger.info(message);
    }

    public static void trace(String message) {
        logger.trace(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void fatal(String message) {
        logger.fatal(message);// use codes here also 
    }

    public static void error(String message) {
        logger.error(message);
        //logger.error(Constants.getErrorCode().get(message));
    }

    public static void error(String message, Throwable info) {
        logger.error(message, info);
    }
}