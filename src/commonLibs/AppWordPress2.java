package commonLibs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import projectUtility.excelDriver;
import com.beust.jcommander.Parameter;
import com.oracle.webservices.internal.api.databinding.DatabindingMode;

public class AppWordPress2 {

    WebDriver wDriver;
    static commonDriver doMethod;
    static excelDriver oExcelDriver;
    
    @
    FindBy(linkText = "WordPress Demo Install")
    private WebElement LogoLinkText;

    @
    FindBy(id = "user_login")
    private static WebElement txtUsername;

    @
    FindBy(id = "user_pass")
    private static WebElement txtPassword;

    @
    FindBy(id = "wp-submit")
    private WebElement loginButton;

    @
    FindBy(linkText = "Home")
    private WebElement linkHome;

    
    public AppWordPress2() {            
            PageFactory.initElements(this.wDriver, this);
            doMethod = new commonDriver(this.wDriver);
            oExcelDriver = new excelDriver();
           
        }
    
   
    @Test  (dataProvider = "getBrowserType") 
    public void prepare(String browserType, String sURL){    	
    	System.out.println("Inside dataprovider");
    	// oExcelDriver.openExcelSheet("D:\\selenium\\Framework\\InputData\\InputTestData.xlsx");
    	//eDriver.openExcelSheet("D:\\Framework\\InputData\\InputTestData.xlsx");
    	doMethod.openBrowser(browserType,sURL);    	
    }
    
    @DataProvider (name = "getBrowserType")
    public Object [][] browserType()    {    	        	
    	String excelSheetName = "prepare";
    	Object[][] browserType = new Object[1][2];
    	oExcelDriver.openExcelSheet("D:\\selenium\\Framework\\InputData\\InputTestData.xlsx");
    	browserType[0][0] = oExcelDriver.getCellData(excelSheetName, 1, 2);
    	browserType[0][1] = oExcelDriver.getCellData(excelSheetName, 2, 2);
    	System.out.println(browserType[0][0]);
    	System.out.println(browserType[0][1]);
    	return browserType;
    }
//    @BeforeTest
//	public void openBrowser(String browserType){
//		doMethod.openURL(sURL);
//	}
    
    
//    @Test (priority = 1) 
//    public void Login2(String URL, String userName, String passWord) {
//        try {
//            doMethod.openURL(URL);
//            doMethod.setText(txtUsername, userName);
//            doMethod.setText(txtPassword, passWord);
//            doMethod.click(loginButton);
//            // return "Login Successful";
//        } catch (Exception e) {
//            System.out.println("appWordpress()->Login()->Error occupred. Detils :");
//            e.printStackTrace();
//        }
//        // return "appWordpress()->Login()->ERROR";
//    }
//
//   
//    @Test  (priority = 2)
//    public void verifyPageTitle() {
//
//        Assert.assertEquals("Dashboard ‹ WordPress Demo Install — WordPress", getPageTitle());
//    }

    public String getPageTitle() {
        return doMethod.getTitle();
    }
    
 
    
    

}