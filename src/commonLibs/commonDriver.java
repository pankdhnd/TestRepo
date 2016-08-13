package commonLibs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonDriver {
private static WebDriver wDriver = getWebDriver.wDriver;
private long pageLoadTimeOut = 60l;
private long elementDetectionTimeOut = 60l;

public commonDriver(WebDriver tempDriver){
	wDriver = tempDriver;
}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------//
public void setpageLoadTimeOut(long timeOut){
	this.pageLoadTimeOut = timeOut;
}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------//
public void setElementDetectionTimeout(long timeOut){
	this.elementDetectionTimeOut = timeOut;
}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------//
public void setText(WebElement element, String Text){
	try {
		element.sendKeys(Text);	
	} catch (Exception e) {
		System.out.println("commonLibs()->setText()-> "+e.getMessage());
	}	
}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------//
public String getTitle(){
	try {

		return wDriver.getTitle();		

	} catch (Exception e) {
		System.out.println("Could not get title of curret page; here is some more detail: ");
	    e.printStackTrace();
	}
	return "commonDriver()->getTitle()->ERROR";
}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------//
public boolean isVisible(WebElement Element) {
	   try {
	    return Element.isDisplayed();
	   } catch (Exception e) {
	    System.out.println("Could not determine element visibility; here is some more detail: ");
	    e.printStackTrace();
	    return false;
	   } 
}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------//
public void openURL(String sURL){	
	if (sURL.isEmpty()) {
	     sURL = "about:blank";
	    }		
	wDriver.manage().window().maximize();	
    wDriver.manage().deleteAllCookies();
    wDriver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS); //set page load time out
    wDriver.manage().timeouts().implicitlyWait(elementDetectionTimeOut, TimeUnit.SECONDS); // set implicit wait
	wDriver.get(sURL);
}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------//
public void click(WebElement element){
	try {	
		element.click();	
	} catch (Exception e) {
		System.out.println("commonLibs()->click()-> ");
		e.printStackTrace();
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------------------//
public void clear(WebElement Element){
	try {	
		Element.clear();	
	} catch (Exception e) {
		System.out.println("commonLibs()->click()-> ");
		e.printStackTrace();
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------------------//
public void waitTillElementVisible(By oBy, long timeOut) {
 try {
  WebDriverWait oWait = new WebDriverWait(wDriver, timeOut);
  oWait.until(ExpectedConditions.visibilityOfElementLocated(oBy));
 } catch (Exception e) {
  System.out.println("Error while waiting for element to be visible; here is some more detail: ");
  e.printStackTrace();
 }
}
//------------------------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------------------//
public void waitTillElementClickable(By oBy, long timeOut) {
 try {	 
  WebDriverWait oWait = new WebDriverWait(wDriver, timeOut);
  oWait.until(ExpectedConditions.elementToBeClickable(oBy));
 } catch (Exception e) {
  System.out.println("commonDriver()->waitTillElementClickable()->Error while waiting for element to be clickable; here is some more detail: ");
  e.printStackTrace();
 }
}
//------------------------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------------------//
public void implicitlyWait(int Seconds){
	wDriver.manage().timeouts().implicitlyWait(Seconds, TimeUnit.SECONDS);
}

//------------------------------------------------------------------------------------------------------------------------------------------------------//	
//------------------------------------------------------------------------------------------------------------------------------------------------------//
public void openBrowser(String sBrowserType, String sURL) {
 sBrowserType = sBrowserType.trim();
 sURL = sURL.trim();
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
  wDriver.manage().window().maximize();
  wDriver.manage().deleteAllCookies();
  wDriver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS); //set page load time out
  wDriver.manage().timeouts().implicitlyWait(elementDetectionTimeOut, TimeUnit.SECONDS); // set implicit wait

  if (sURL.isEmpty()) {
   sURL = "about:blank";
  }
  wDriver.get(sURL);
 } catch (Exception e) {
  System.out.println("Could not open browser; here is some more detail: ");
  e.printStackTrace();
 }

 } //END openBrowser
//------------------------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------------------//








}
