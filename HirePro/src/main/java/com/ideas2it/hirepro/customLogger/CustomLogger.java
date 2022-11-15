package com.ideas2it.hirepro.customLogger;

import java.lang.Throwable;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.ideas2it.hirepro.constants.Constants;
public class CustomLogger {
    private Logger logger;
 
    public CustomLogger(Class<?> className) {
        logger = LogManager.getLogger(className);
    }
        
    public void info(String message) {
        logger.info(message);
    }

    public void trace(String message) {
        logger.trace(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void fatal(String message) {
        logger.fatal(message);// use codes here also 
    }

    public void error(String message) {
        logger.error(Constants.getErrorCode().get(message));
    }

    public void error(String message, Throwable info) {
        logger.error(message, info);
    }
}