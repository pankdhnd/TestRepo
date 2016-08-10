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
	
	public mainClass(){
		mainWebDriver = driverGetter.getDriver("opera");
		apress = new appWordpress(mainWebDriver);	
		apress.Login("admin", "demo123");
	}
	
	
	
  @Test
  public void verifyPageTitle()	{
		apress.Login("admin", "demo123");
		//System.out.println(apress.getPageTitle());
		Assert.assertEquals("Dashboard ‹ WordPress Demo Install — WordPress", apress.getPageTitle());
	}
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
