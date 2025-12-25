package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

  public class AdminUserPage {
	
  public WebDriver driver;
  PageUtility pageutil=new PageUtility();
	
	public AdminUserPage(WebDriver driver)

	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement createnewbtn;
	@FindBy(id="username")WebElement AdminUname;
	@FindBy(id="password")WebElement Adminpsw;
	@FindBy(id="user_type")WebElement Usertype;
	@FindBy(name="Create")WebElement Save;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement srchbtn;
	@FindBy(id="un")WebElement UnameSrch;
	@FindBy(id="ut")WebElement UtypeSrch;
	@FindBy(name="Search")WebElement Submitsrch;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")WebElement Resetbtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	@FindBy(xpath="//span[text()='Active']")WebElement Active;
	@FindBy(xpath="//h1[text()='Admin Users']")WebElement AdminUsers;
	
    public AdminUserPage createNewAdminUserClick()
    {
		createnewbtn.click();
		return this;
    }
	
	public AdminUserPage enterAdminName(String UserNameValues1)
	{
		AdminUname.sendKeys(UserNameValues1);
		return this;
	}
	
	public AdminUserPage enterAdminPsw(String PasswordValues1)
	{
		Adminpsw.sendKeys(PasswordValues1);
		return this;
	}
	
	public AdminUserPage selectUserType()
	{
		pageutil.selectDropDownDWithIndex(Usertype, 2);
		//Select sl= new Select(Usertype);
		//sl.selectByIndex(2);
		return this;
		
	}
	
	public AdminUserPage clickOnSaveButton()
	{
		Save.click();
		return this;
	}
	
	public AdminUserPage clickSearch()
	
	{
		srchbtn.click();
		return this;
	}
	
	public AdminUserPage enterUnameSrchValue(String UserNameValues1)
	{
		UnameSrch.sendKeys(UserNameValues1);
		return this;
	}
	
	public AdminUserPage selectUtypeSrchValue()
	{
		
		pageutil.selectDropDownDWithIndex(UtypeSrch, 2);
		//Select sl1=new Select(UtypeSrch);
		//sl1.selectByIndex(2);
		return this;
	}
	
	public AdminUserPage submitSearchBtnClick()
	{
		Submitsrch.click();
		return this;
		
	}
	
	public AdminUserPage resetButtonClick()
	{
		Resetbtn.click();
		return this;
	}
	
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	
	public boolean isActiveDisplayed()
	{
		return Active.isDisplayed();
	}
	
	public String isAdminUserTextDisplayed()
	{
		return AdminUsers.getText();
	}
}
