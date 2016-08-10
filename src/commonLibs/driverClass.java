package commonLibs;

import org.openqa.selenium.WebDriver;

public class driverClass {
	
	static WebDriver mainWebDriver;
	static getWebDriver driverGetter = new getWebDriver();
	static appWordpress apress;
	
	public static void main(String[] args) {
		mainWebDriver = driverGetter.getDriver("opera");
		apress = new appWordpress(mainWebDriver);
		
		
	apress.Login("admin", "demo123$");
		
		
	}
	
	public void main()
	{ 
//		System.out.println("inside main");
//		mainWebDriver = driverGetter.getDriver("opera");
//		apress = new appWordpress(mainWebDriver);
		
	}

}
