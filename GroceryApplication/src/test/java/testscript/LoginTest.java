package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base {
	HomePage home;
	@Test(priority=1,description="User is trying to login with valid credentials", groups= {"smoke"})
	public void verifyLoginPageWithValidData() throws IOException
	{
		String UserNameValues=ExcelUtilities.readStringData1(0,0,"LoginPage");
		String PasswordValues=ExcelUtilities.readStringData1(0,1,"LoginPage");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUserName(UserNameValues).enterPassword(PasswordValues);//dot is used here because there is no redirection to another page for these two and also retain on same page
		home=lp.clickingButton();
		boolean dashbrddisp=lp.isdasboardDisplayed();
		Assert.assertTrue(dashbrddisp,Constant.VALIDCREDENTIALERROR);
		
		
	}
	@Test(priority=2,description="User trying to login with invalid data",retryAnalyzer=retry.Retry.class)
	public void verifyLoginPageWithInvalidData() throws IOException
	{
		
		String UserNameValues=ExcelUtilities.readStringData1(10,0,"LoginPage");
		String PasswordValues=ExcelUtilities.readStringData1(1,1,"LoginPage");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUserName(UserNameValues).enterPassword(PasswordValues).clickingButton();
		String expected="7rmart supermarket";
		String actual=lp.isTextpresent();
		Assert.assertEquals(expected, actual,Constant.INVALIDCREDENTIALERROR);
		
	}
	@Test(priority=3, description="User is trying to login with invalid user name but valid password")
	public void verifyLoginPageWithInvalidUsernameValidPsw() throws IOException
	{
		
		String UserNameValues=ExcelUtilities.readStringData1(2,0,"LoginPage");
		String PasswordValues=ExcelUtilities.readStringData1(2,1,"LoginPage");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUserName(UserNameValues).enterPassword(PasswordValues).clickingButton();
		String expected="7rmart supermarket";
		String actual=lp.isTextpresent();
		Assert.assertEquals(expected, actual,Constant.INVALIDUSERNAMEVALIDPSWERROR);
		
	}
	
	@Test(priority=4,description="user is trying to login with valid user name but invalid password",groups= {"smoke"},dataProvider="loginProvider")
	public void verifyLoginPageWithValidUsernameInValidPsw(String UserNameValues, String PasswordValues) throws IOException
	{
		
		//String UserNameValues=ExcelUtilities.readStringData1(3,0,"LoginPage");// removed bcz data provider is used
		//String PasswordValues=ExcelUtilities.readStringData1(3,1,"LoginPage");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUserName(UserNameValues).enterPassword(PasswordValues).clickingButton();
		String expected="7rmart supermarket";
		String actual=lp.isTextpresent();
		Assert.assertEquals(expected, actual,Constant.VALIDUSERNAMEINVALIDPSWERROR);
		
	}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException { // syntax of data provider to create method

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },// TC will run 2 times
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}
	
}
