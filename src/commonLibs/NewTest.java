package commonLibs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import projectUtility.excelDriver;

public class NewTest {
	
	private WebDriver wDriver;
    private static commonDriver doMethod;
    private static getWebDriver driverGetter = new getWebDriver();
    private static excelDriver oExcelDriver;
    
    @FindBy(id = "menu-posts")
    private static WebElement postsButton;
    
  @Test
  public void clickPostsButton() {
	  doMethod.click(postsButton);
	  
  }
}
