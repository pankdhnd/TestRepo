package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import projectUtility.dataProvider;
import commonLibs.appWordPress3;
import commonLibs.commonDriver;
import org.testng.Assert;
import commonLibs.getWebDriver;
import projectUtility.Log;


public class testCase001 {
	
	
	
	static WebDriver mainWebDriver;// = getWebDriver.wDriver;
	//static getWebDriver driverGetter = new getWebDriver();
	static appWordPress3 apress3;
	 private static dataProvider  testData = new dataProvider();	
	 
	 public testCase001(){
		 
	 }
	 
	 
	@BeforeTest  
    public void prepare(){
		DOMConfigurator.configure("log4j.xml");
		Log.startOfTestCase("testCase001_LoginAndVerifications");
		Log.info("inside BeforeText, configuring elements...");		
    	String browserType = "opera";    
    	Log.info("Getting WebDriver instance");
    	getWebDriver.initiateDriver(browserType);
    	//driverGetter.getDriver(browserType);
    	
    	mainWebDriver = getWebDriver.wDriver;
    	Log.info("WebDriver intance received, now pasing to appWordPres3");
    	apress3 = new appWordPress3(mainWebDriver);    	  	    	
    }
	
	
  @Test
  public void testCase001_LoginAndVerifications() {
	 Log.info("Strting actual tets case execution");
	 String ExpectedLoginPageTitle = "WordPress Demo Install › Log In";
	  //Open URL of login page
	  apress3.OpenURL();		  
	  
	 //Verify title for login page	 
	 Assert.assertEquals(apress3.getPageTitle(), ExpectedLoginPageTitle);
	  
	 //Verify if username textbox is visible
	 Assert.assertTrue(apress3.isUserTextBoxDisplayed());
//	 
//	 //Verify if password textbox is displayed
	 Assert.assertTrue(apress3.isPasswordTextBoxDisplayed());
//	 
//	 //Verify if login button is displayed
	 Assert.assertTrue(apress3.isLoginButtonDisplayed());
	 apress3.Login2();
	 //Assert
//	  String[] tempLoginData = new String[2];
//	  tempLoginData = testData.getLoginDetails();
//	  apress3.Login2(tempLoginData[0], tempLoginData[1]);
//	  apress3.verifyPageTitle();
  }
  
  
  
  
  
  
}
