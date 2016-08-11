package commonLibs;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class getWebDriver {
	public WebDriver wDriver;
	
	
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------	
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------	
public WebDriver getDriver(String sBrowserType) { 
	sBrowserType = sBrowserType.trim();	  
	   try {
		  
	    if (sBrowserType.equalsIgnoreCase("firefox") || sBrowserType.equalsIgnoreCase("ff") || sBrowserType.equalsIgnoreCase("mozilla")) {
	     wDriver = new FirefoxDriver();
	    } else if (sBrowserType.equalsIgnoreCase("chrome") || sBrowserType.equalsIgnoreCase("google chrome") || sBrowserType.equalsIgnoreCase("gc")) {
	     System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
	     wDriver = new ChromeDriver();		    
	    } else if (sBrowserType.equalsIgnoreCase("ie") || sBrowserType.equalsIgnoreCase("internet explorer")) {
	     System.setProperty("webdriver.ie.driver", "D:\\webdrivers\\IEDriverServer.exe");
	     wDriver = new InternetExplorerDriver();
	
	    } else if (sBrowserType.equalsIgnoreCase("opera")){
	    	System.setProperty("webdriver.opera.driver", "D:\\webdrivers\\operadriver.exe");
	        wDriver = new OperaDriver();		    		  
	    } else {
	     throw new Exception("Invalid browser type " + sBrowserType);	 
	     //System.out.println("Invalid driver type "+sBrowserType+" Setting default browser to Firefox...");
	     //wDriver = new FirefoxDriver();
	    }	    

	   } catch (Exception e) {
	    System.out.println("Could not open browser; here is some more detail: ");
	    e.printStackTrace();
	    return null;
	   }
	return wDriver;

	  } //END openBrowser
 //------------------------------------------------------------------------------------------------------------------------------------------------------//
	//------------------------------------------------------------------------------------------------------------------------------------------------------//

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
