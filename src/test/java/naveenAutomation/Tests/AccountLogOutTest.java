package naveenAutomation.Tests;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import naveenAutomation.Base.TestBase;
import naveenAutomation.pages.AccountLogOutPage;
import naveenAutomation.pages.AccountLoginPage;
import naveenAutomation.pages.HomePage;
import naveenAutomation.pages.MyAccountPage;

public class AccountLogOutTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		launchBrowser();

	}

	@Test
	public void VerifyUserAbleToLogin() {
		HomePage myAccClikOnHomPage = new HomePage();
		AccountLoginPage accountLogin = myAccClikOnHomPage.clickMyAccountDropDown();
		MyAccountPage myAccount = accountLogin.login("rkkaler@gmail.com", "Password6");
		AccountLogOutPage logOut = myAccount.LogOut();
		Assert.assertEquals(logOut.AccountLogOutText(), "Account Logout");
		Assert.assertEquals(logOut.TitleOfAccountLogOut(), "Account Logout");
		logOut.AccountLogOutDetails();

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();

	}

}
