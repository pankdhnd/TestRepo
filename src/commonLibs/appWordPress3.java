package commonLibs;

import projectUtility.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import projectUtility.excelDriver;
import projectUtility.dataProvider;
import projectUtility.objectRepository;

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

    @FindBy(linkText = "Howdy, admin")
    private static WebElement welcomeText;
    
        
    public appWordPress3(WebDriver tempDriver) {
           this.wDriver = tempDriver;
           PageFactory.initElements(this.wDriver, this);
           doMethod = new commonDriver(this.wDriver);          
        }
    
     
      
//    @BeforeTest  
//    public void prepare(){ 
//    	Log.info("Preparing environment before starting test case run");
//    	//Excel sheet name where the browser type and URL are saved
//    	String excelSheetName = "prepare";             
//    	
//    	//initialize Excel Driver
//        oExcelDriver = new excelDriver();
//        //Open Excel Sheet
//    	oExcelDriver.openExcelSheet("D:\\selenium\\Framework\\InputData\\InputTestData.xlsx");
//    	//Get browser type and URL
//    	String browserType = oExcelDriver.getCellData(excelSheetName, 1, 2);
//    	String sURL = oExcelDriver.getCellData(excelSheetName, 2, 2);
//    	//initialize WebDiver and open browser    	
//    	this.wDriver = driverGetter.getDriver(browserType);
//    	//initialize Pagefactory
//    	PageFactory.initElements(this.wDriver, this);
//    	//initialize commonDriver
//    	doMethod = new commonDriver(this.wDriver);
//    	//open URL
//    	doMethod.openURL(sURL);    	    	
//    }
    
    
    @Test
    public void OpenURL(){
    	String sURL ="http://demo.opensourcecms.com/wordpress/wp-login.php";
    	doMethod.openURL(sURL);
    }
    
    

    //Test case to log into the system. Priority 1 so that it will be the first one to be executed
    @Test 
    public void Login2() {
        try {        	
        	Log.info("Inside Login, getting username and password for login");
        	String[] tempLoginData = new String[2];
        	tempLoginData = dataProvider.getLoginDetails();
        	System.out.println(tempLoginData[0]+" "+tempLoginData[1]);
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
            
            WebDriverWait oWait = new WebDriverWait(wDriver, 60);
            oWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Howdy, admin")));
            
            
            
            
            
            
            
            
            
            
//            By oBy = (By)welcomeText;            
//            doMethod.waitTillElementVisible(oBy, 60);
            
        } catch (Exception e) {
        	Log.debug(e.getMessage());            
        }        
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
    
    
    
    
    
//    @Test  (priority = 2)
//    public void verifyPageTitle() {  	
//    	
//        Assert.assertEquals(doMethod.getTitle(),"Dashboard ‹ WordPress Demo Install — WordPress");
//    }

//    public String getPageTitle() {
//        return doMethod.getTitle();
//    }
    
    
    
    
    
//==========================================================================================================================================    
//========================================================================================================================================== 
//================================================= DATA PROVIDER SECTION ==================================================================   
//==========================================================================================================================================
//==========================================================================================================================================
   
    

}