package naveenAutomation.Tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import naveenAutomation.Base.TestBase;
import naveenAutomation.pages.AccountLoginPage;

public class ChangePasswordTest extends TestBase {
	AccountLoginPage accountLoginPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLoginPage = new AccountLoginPage(driver,true).get();
	}

	

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}

