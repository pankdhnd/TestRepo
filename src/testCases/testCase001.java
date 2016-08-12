package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import projectUtility.dataForTesting;
import commonLibs.appWordPress3;
import commonLibs.commonDriver;
import commonLibs.getWebDriver;
import projectUtility.Log;
import projectUtility.excelDriver;

public class testCase001 {
	static WebDriver mainWebDriver;
	static getWebDriver driverGetter = new getWebDriver();
	static appWordPress3 apress3;
	 private static dataForTesting  testData = new dataForTesting();	
	 
	 public testCase001(){
		 
	 }
	 
	 
	@BeforeTest  
    public void prepare(){ 
    	
    	String browserType = "opera";
    
    	mainWebDriver = driverGetter.getDriver(browserType);
    	
    	apress3 = new appWordPress3(mainWebDriver);
    	  	    	
    }
	
	
  @Test
  public void f() {
	  apress3.OpenURL();
	
	  String[] tempLoginData = new String[2];
	  tempLoginData = testData.getLoginDetails();
	  apress3.Login2(tempLoginData[0], tempLoginData[1]);
	  apress3.verifyPageTitle();
  }
  
  
  
  
  
  
}
