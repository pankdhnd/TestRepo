package commonLibs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class appWordpress {

	WebDriver wDriver;
	commonDriver doMethod;
	
	@FindBy(linkText = "WordPress Demo Install")
	private WebElement LogoLinkText;
	
	@FindBy(id = "user_login")
	private static WebElement txtUsername;
	
	@FindBy(id = "user_pass")
	private static WebElement txtPassword;
	
	@FindBy(id = "wp-submit")
	private WebElement loginButton;
	
	@FindBy(linkText = "Home")
	private WebElement linkHome;
	
		
	public appWordpress(WebDriver tempDriver){				
		this.wDriver = tempDriver;
        PageFactory.initElements(wDriver, this);
        doMethod = new commonDriver(this.wDriver);	
	}
	
	public String getPageTitle(){
		return doMethod.getTitle();
	}


	public void openURL(String sURL){
		doMethod.openURL(sURL);

	}
	
	
	
	
	
	public String Login (String userName, String passWord){	
		try {
			doMethod.openURL("http://demo.opensourcecms.com/wordpress/wp-login.php");
//			oDriver.openBrowser("opera", "http://demo.opensourcecms.com/wordpress/wp-login.php");
			doMethod.setText(txtUsername, userName);
			doMethod.setText(txtPassword, passWord);
			doMethod.click(loginButton);
			return "Login Successful";
		} catch (Exception e) {
			System.out.println("appWordpress()->Login()->Error occupred. Detils :");
			e.printStackTrace();		
			}
		return "appWordpress()->Login()->ERROR";
	}
	

}
