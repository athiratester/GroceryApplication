package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
      @FindBy(xpath="//a[@data-toggle='dropdown']")WebElement AdminMenu;
     // @FindBy(xpath ="//a[contains(@href,'list-admin')]/ancestor::div[@class='small-box bg-info']")WebElement MoreInfo ;
     @FindBy(xpath ="//a[contains(@href,'list-admin') and contains(text(),'More info')]")WebElement MoreInfo;
	 @FindBy(xpath ="//div[@class='dropdown-divider']// following::a[@class='dropdown-item']")WebElement Logout;
	 @FindBy(xpath="//button[text()='Sign In']")WebElement signin;
	 
	 @FindBy(xpath ="//a[contains(@href,'list-news') and contains(text(),'More info')]")WebElement MoreInfonews;
    
   public HomePage adminMenuClick()
   {
	   AdminMenu.click();
	   return this;
   }
   
  
 public LoginPage LogoutMenuClick()
   {   
	   Logout.click();
	   return new LoginPage(driver);
   } 
 
 public AdminUserPage moreInfoClick()
 {
	   MoreInfo.click();
	   return new AdminUserPage(driver);
 }

 public NewsPage moreInfoNewsClick()
 {
	 MoreInfonews.click();
	 return new NewsPage(driver);
 }
 
 public boolean isSigninDisplayed()
	{
		return signin.isDisplayed();
	}
 
 
 
}
