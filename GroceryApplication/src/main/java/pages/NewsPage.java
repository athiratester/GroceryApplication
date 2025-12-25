package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsPage {
	
		
		public WebDriver driver;
		
		public NewsPage(WebDriver driver)

		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement NewsCreatebtn;
		@FindBy(id="news")WebElement news;
		@FindBy(name="create")WebElement submit;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement Newsalert;
		
		@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement Newssearchbtn;
		@FindBy(name="un")WebElement newstitle;
		@FindBy(xpath="//button[@type='submit']")WebElement SubmitSrch;
		@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")WebElement Edit;
		
		@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")WebElement Resetnews;
		@FindBy(xpath="//h1[@class='m-0 text-dark']")WebElement Managnewstitle;
		
		public NewsPage createNewsClick()
		{
			NewsCreatebtn.click();
			return this;
		}
		
		public NewsPage enterNewsValues(String Newvalues )
		{
			news.sendKeys(Newvalues);
			return this;
		}
		
		public NewsPage submitNews()
		{
			submit.click();
			return this;
		}
		
		public boolean isNewsAlertDisplayed()
		{
			return Newsalert.isDisplayed();
		}
		
		public NewsPage searchClick()
		{
			Newssearchbtn.click();
			return this;
		}
		public NewsPage enterTitleValue(String Newvalues1)
		{
			newstitle.sendKeys(Newvalues1);
			return this;
		}
       public NewsPage newsSearchSubmit()
       {
    	   SubmitSrch.click();
    	   return this;
       }
       
       public boolean isEditDisplayed()
    	{
   		return Edit.isDisplayed();
    	}
       
       public NewsPage resetNewsClick()
       {
    	   Resetnews.click();
    	   return this;
       }
       
       public String isManageNewsTitlePresent()
       {
    	   return Managnewstitle.getText();
       }
}
