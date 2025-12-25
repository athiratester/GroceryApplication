package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base{
	HomePage hp;
	AdminUserPage newadm;
	
	
	@Test(description="User is trying to create Admin user")
	public void verifyNewAdminUserCreatedSuccessfully() throws IOException
	{
		String UserNameValues=ExcelUtilities.readStringData1(0,0,"LoginPage");
		String PasswordValues=ExcelUtilities.readStringData1(0,1,"LoginPage");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUserName(UserNameValues).enterPassword(PasswordValues);
		hp=lp.clickingButton();
		
		
		newadm=hp.moreInfoClick();
		
		
		RandomDataUtility random= new RandomDataUtility();
		String UserNameValues1=random.randomUserName();
		String PasswordValues1=random.randomPsw();
		newadm.createNewAdminUserClick().enterAdminName(UserNameValues1).enterAdminPsw(PasswordValues1).selectUserType().clickOnSaveButton();
			
		boolean alertdisp=newadm.isAlertDisplayed();
		Assert.assertTrue(alertdisp, Constant.ADMINUSERCREATE);// error msg will display on jenkin console
		
   }
	@Test(description="User is trying to search admin user")
	public void verifyAdminUserCanBeSearched() throws IOException
	{
		String UserNameValues=ExcelUtilities.readStringData1(0,0,"LoginPage");
		String PasswordValues=ExcelUtilities.readStringData1(0,1,"LoginPage");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUserName(UserNameValues).enterPassword(PasswordValues);
		hp=lp.clickingButton();
		
		
		newadm=hp.moreInfoClick();
		
		
		
		String UserNameValues1=ExcelUtilities.readStringData1(0,0,"AdminUser");
		newadm.clickSearch().enterUnameSrchValue(UserNameValues1).selectUtypeSrchValue().submitSearchBtnClick();
		
		boolean activedisp=newadm.isActiveDisplayed();
		Assert.assertTrue(activedisp, Constant.ADMINUSERSEARCH);
		
	}
	
	@Test(description="User is trying to reset the admin user page")
	public void verifyPageResetCanBeDoneSuccessfully() throws IOException
	{
		String UserNameValues=ExcelUtilities.readStringData1(0,0,"LoginPage");
		String PasswordValues=ExcelUtilities.readStringData1(0,1,"LoginPage");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUserName(UserNameValues).enterPassword(PasswordValues);
		hp=lp.clickingButton();
		
		
		newadm=hp.moreInfoClick().resetButtonClick();
		
		String expected="Admin Users";
		String actual=newadm.isAdminUserTextDisplayed();
		Assert.assertEquals(expected, actual,Constant.ADMINUSERRESET);
	}
	
	
	
}
