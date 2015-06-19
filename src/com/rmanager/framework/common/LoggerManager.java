package com.rmanager.framework.common;

import org.apache.log4j.Logger;

public class LoggerManager {
	
    private static Logger Log = Logger.getLogger(LoggerManager.class.getName());

    public static void startTestCase(String sTestCaseName){
          Log.info("=> Start Test Case: "+sTestCaseName);
    }

    public static void endTestCase(){
          Log.info("=> End Test Case");
    }

    public static void info(String message) {
          Log.info(message);
    }

    public static void warn(String message) {
          Log.warn(message);
    }

    public static void error(String message) {
          Log.error(message);
    }

    public static void fatal(String message) {
          Log.fatal(message);
    }

    public static void debug(String message) {
          Log.debug(message);
    }    
	
}
