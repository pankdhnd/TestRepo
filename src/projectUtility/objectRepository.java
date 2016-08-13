package projectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class objectRepository {

	public static WebDriver wDriver;
	@FindBy(linkText = "WordPress Demo Install")
    public static WebElement LogoLinkText;

    @FindBy(id = "user_login")
    public static WebElement txtUsername;

    @FindBy(id = "user_pass")
    public static WebElement txtPassword;

    @FindBy(id = "wp-submit")
    public static WebElement loginButton;

    @FindBy(linkText = "Home")
    public static WebElement linkHome;

    @FindBy(linkText = "Howdy, admin")
    public static WebElement loggedinUserName;
	
    	
	
	
}
