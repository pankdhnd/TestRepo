package commonLibs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;


public class mainClass {
	
	static WebDriver mainWebDriver;
	static getWebDriver driverGetter = new getWebDriver();
	static appWordpress apress;
	static AppWordPress2 apress2;
	
	public mainClass(){
		mainWebDriver = driverGetter.getDriver("opera");
		apress = new appWordpress(mainWebDriver);	
		//apress.Login2("admin", "demo123");
	//	apress.verifyPageTitle();		
	//	apress2 = new AppWordPress2(mainWebDriver);
		
	//	apress2.Login2("admin", "demo123", null);
	//	apress2.verifyPageTitle();
		
		
	}
	
	
	
	
	
	
	
//  @Test
//  public void verifyPageTitle()	{
//		apress.Login2("admin", "demo123");
//		//System.out.println(apress.getPageTitle());
//		Assert.assertEquals("Dashboard ‹ WordPress Demo Install — WordPress", apress.getPageTitle());
//	}
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
