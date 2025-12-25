package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtilities;

public class NewsTest extends Base {
	HomePage hp;
	NewsPage np;

	@Test(description="User is trying to create news")
	public void verifyNewsCanBeCreatedSuccessfully() throws IOException
	{
		String UserNameValues=ExcelUtilities.readStringData1(0,0,"LoginPage");
		String PasswordValues=ExcelUtilities.readStringData1(0,1,"LoginPage");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUserName(UserNameValues).enterPassword(PasswordValues);
		hp=lp.clickingButton();
		
		
		np=hp.moreInfoNewsClick();
		
		
		
		String Newvalues=ExcelUtilities.readStringData1(0,0,"News");
		np.createNewsClick().enterNewsValues(Newvalues).submitNews();
		
		boolean newalertdisp=np.isNewsAlertDisplayed();
		Assert.assertTrue(newalertdisp, Constant.NEWSCREATE);
	}
	 @Test(description="User is trying to search news")
	public void verifyNewsCanBeSearchedSuccessfully() throws IOException
	{
		String UserNameValues=ExcelUtilities.readStringData1(0,0,"LoginPage");
		String PasswordValues=ExcelUtilities.readStringData1(0,1,"LoginPage");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUserName(UserNameValues).enterPassword(PasswordValues);
		hp=lp.clickingButton();
		
		
		np=hp.moreInfoNewsClick();
		
		
		String Newvalues1=ExcelUtilities.readStringData1(0,0,"News");
		np.searchClick().enterTitleValue(Newvalues1).newsSearchSubmit();
		
		boolean editdisp=np.isEditDisplayed();
		Assert.assertTrue(editdisp,Constant.NEWSSEARCH);
	}
	 @Test(description="User is trying to reset the page")
	 public void verifyNewsPageCanBeResetSuccessfully() throws IOException
	 {
		 String UserNameValues=ExcelUtilities.readStringData1(0,0,"LoginPage");
		 String PasswordValues=ExcelUtilities.readStringData1(0,1,"LoginPage");
			
			LoginPage lp=new LoginPage(driver);
			lp.enterUserName(UserNameValues).enterPassword(PasswordValues);
			hp=lp.clickingButton();
			
			
			np=hp.moreInfoNewsClick().resetNewsClick();
			
			String expected="Manage News";
			String actual=np.isManageNewsTitlePresent();
			Assert.assertEquals(expected, actual,Constant.NEWSRESET);
	 }
}
