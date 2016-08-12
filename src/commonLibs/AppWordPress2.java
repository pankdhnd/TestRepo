package commonLibs;

import projectUtility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import projectUtility.excelDriver;

public class AppWordPress2 {

	private WebDriver wDriver;
    private static commonDriver doMethod;
    private static getWebDriver driverGetter = new getWebDriver();
    private static excelDriver oExcelDriver;
    
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

    
    public AppWordPress2() {
                       
        }
    
     
    
   
    @BeforeTest  
    public void prepare(){ 
    	Log.info("Preparing environment before starting test case run");
    	//Excel sheet name where the browser type and URL are saved
    	String excelSheetName = "prepare";             
    	
    	//initialize Excel Driver
        oExcelDriver = new excelDriver();
        //Open Excel Sheet
    	oExcelDriver.openExcelSheet("D:\\selenium\\Framework\\InputData\\InputTestData.xlsx");
    	//Get browser type and URL
    	String browserType = oExcelDriver.getCellData(excelSheetName, 1, 2);
    	String sURL = oExcelDriver.getCellData(excelSheetName, 2, 2);
    	//initialize WebDiver and open browser    	
    	this.wDriver = driverGetter.getDriver(browserType);
    	//initialize Pagefactory
    	PageFactory.initElements(this.wDriver, this);
    	//initialize commonDriver
    	doMethod = new commonDriver(this.wDriver);
    	//open URL
    	doMethod.openURL(sURL);    	    	
    }
    

    //Test case to log into the system. Priority 1 so that it will be the first one to be executed
    @Test (priority = 1, dataProvider = "getLoginDetails" )
    public void Login2(String userName, String passWord) {
        try {            
            doMethod.setText(txtUsername, userName);
            doMethod.setText(txtPassword, passWord);
            doMethod.click(loginButton);  
        } catch (Exception e) {
            System.out.println("appWordpress()->Login()->Error occupred. Detils: ");
            e.printStackTrace();
        }        
    }
    
    
 

  
    

   
    @Test  (priority = 2)
    public void verifyPageTitle() {  	
    	
        Assert.assertEquals(getPageTitle(),"Dashboard ‹ WordPress Demo Install — WordPress");
    }

    public String getPageTitle() {
        return doMethod.getTitle();
    }
    
    
    
    
    
//==========================================================================================================================================    
//========================================================================================================================================== 
//================================================= DATA PROVIDER SECTION ==================================================================   
//==========================================================================================================================================
//==========================================================================================================================================
    @DataProvider (name = "getLoginDetails")
    public Object [][] loginData()    {    	        	
    	String excelSheetName = "Login";
    	Object[][] loginData = new Object[1][2];  	
    	loginData[0][0] = oExcelDriver.getCellData(excelSheetName, 1, 2);
    	loginData[0][1] = oExcelDriver.getCellData(excelSheetName, 2, 2);  	
    	return loginData;	
    }
    

}