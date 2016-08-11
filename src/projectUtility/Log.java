package projectUtility;

import org.apache.log4j.Logger;

public class Log {
	private static Logger Log = Logger.getLogger(Log.class.getName());
	
	public static void startOfTestCase(String testCaseName){
		Log.info("****************************************************************************************");
	    Log.info("****************************************************************************************");
	    Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+testCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
	    Log.info("****************************************************************************************");
	    Log.info("****************************************************************************************");
	}
	
	public static void endOfTestCase(String testCaseName){
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
	    Log.info("X");
	    Log.info("X");
	    Log.info("X");
	    Log.info("X");
	}
	
	
	public static void info(String message){
		Log.info(message);
	}
	
	public static void error(String message){
		Log.error(message);
	}
	
	public static void warn(String message){
		Log.warn(message);
	}
	
	public static void fatal(String message){
		Log.fatal(message);
	}
	
	public static void debug(String message){
		Log.debug(message);
	}
	
	
///	private static Logger Log = Logger.getLogger(Log.class.getName()); 
	
	
}
