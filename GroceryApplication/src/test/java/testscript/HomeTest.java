package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class HomeTest extends Base{
	HomePage hp;
	
	@Test(description="User is trying to logout from the site")
	public void verifyUserLoggedOutSuccessfully() throws IOException
	{
		String UserNameValues=ExcelUtilities.readStringData1(0,0,"LoginPage");
		String PasswordValues=ExcelUtilities.readStringData1(0,1,"LoginPage");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUserName(UserNameValues).enterPassword(PasswordValues);
		hp=lp.clickingButton();
			
		hp.adminMenuClick();
		lp=hp.LogoutMenuClick();
		
		
		boolean signindisp=hp.isSigninDisplayed();
		Assert.assertTrue(signindisp, Constant.LOGOUT);
	}
	

}
