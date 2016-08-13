package commonLibs;

import projectUtility.Log;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;
import projectUtility.dataProvider;

public class appWordPress3 {

	private WebDriver wDriver;
    private static commonDriver doMethod;
 // private static getWebDriver driverGetter = new getWebDriver();
 //   private static excelDriver oExcelDriver;
    
    @FindBy(linkText = "WordPress Demo Install")
    private static WebElement LogoLinkText;

    @FindBy(id = "user_login")
    private static WebElement txtUsername;

    @FindBy(id = "user_pass")
    private static WebElement txtPassword;

    @FindBy(id = "wp-submit")
    private static WebElement loginButton;

    @FindBy(linkText = "Home")
    private static WebElement linkHome;

    @FindBy(xpath = "//a[contains(text(),'Dashboard')]")
    private static WebElement dashboardLink;
    
    @FindBy(xpath = "//a[contains(text(),'Howdy, admin')]")
    private static WebElement myAccountLink;
    
    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    private static WebElement linkLogout;
        
    public appWordPress3(WebDriver tempDriver) {
           this.wDriver = tempDriver;
           PageFactory.initElements(this.wDriver, this);
           doMethod = new commonDriver(this.wDriver);          
        }
    
     
      
   
    @Test
    public void OpenURL(){
    	String sURL ="http://demo.opensourcecms.com/wordpress/wp-login.php";
    	doMethod.openURL(sURL);
    }
    
    

    //Test case to log into the system. Priority 1 so that it will be the first one to be executed
    @Test (priority = 1)
    public boolean Login2() {
        try {        	
        	Log.info("Inside Login, getting username and password for login");
        	String[] tempLoginData = new String[2];
        	tempLoginData = dataProvider.getLoginDetails();        	
        	String userName = tempLoginData[0];
        	String passWord = tempLoginData[1];

        	//Clearing all text controls
        	doMethod.clear(txtUsername);
        	doMethod.clear(txtPassword);        	
        	
        	//Interaging with controls
            doMethod.setText(txtUsername, userName);
            doMethod.setText(txtPassword, passWord);
            Log.info("clicking Login button");
            doMethod.click(loginButton);                     
            
            return doMethod.isVisible(dashboardLink);

            
        } catch (Exception e) {
        	Log.debug(e.getMessage());    
        	return false;
        }        
    }
    
    @Test (priority = 2)
    public boolean Logout(){
    	doMethod.moveToElement(myAccountLink);
    	doMethod.click(linkLogout);
    	return false;
    	
    	
    }
    public boolean isUserTextBoxDisplayed(){
    	return doMethod.isVisible(txtUsername);
    }

    public boolean isPasswordTextBoxDisplayed(){
    	return doMethod.isVisible(txtUsername);
    	//Assert.assertTrue(doMethod.isVisible(txtPassword));
    }
   
    public boolean isLoginButtonDisplayed(){
    	return doMethod.isVisible(loginButton);
    //	Assert.assertTrue(doMethod.isVisible(loginButton));
    }
    
    public String getPageTitle(){
    	return doMethod.getTitle();
    }
    
    

}