package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	WaitUtility waitutil= new WaitUtility();
	
	public LoginPage(WebDriver driver)

	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")WebElement Uname;
	@FindBy(name="password")WebElement Psw;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")WebElement Signin;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement Dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement logintext;
	
	
	public LoginPage enterUserName(String UserNameValues)// replaced void by LoginPage since there is no redirection happening.only entering the value . so same page is given as return type
	{
		Uname.sendKeys(UserNameValues);
		return this;// same page
	}
	
	public LoginPage enterPassword(String PasswordValues)
	{
		Psw.sendKeys(PasswordValues);
		return this;
	}
	
	public HomePage clickingButton()// void replaced by homepage because when clicking signin btn page redirects to homepage
	{
		waitutil.waitUntilElementToBeClickable(driver, Signin);
		Signin.click();
		return new HomePage(driver);
	}
	
	public boolean isdasboardDisplayed()
	{
		return Dashboard.isDisplayed();
	}
	
	public String isTextpresent()
	{
		return logintext.getText();
		
	}

}
