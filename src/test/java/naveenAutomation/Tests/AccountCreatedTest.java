package naveenAutomation.Tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import naveenAutomation.Base.TestBase;
import naveenAutomation.pages.AccountCreatedPage;
import naveenAutomation.pages.AccountLoginPage;
import naveenAutomation.pages.RegisterAccountPage;

public class AccountCreatedTest extends TestBase {
	//this is account class
	AccountLoginPage accountLoginPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		accountLoginPage = new AccountLoginPage(driver,true).get();
	}

	@Test
	public void VerifyUserIsAbleToSignUpSuccessFully() {

		RegisterAccountPage registerAccountPage = accountLoginPage.clickContinueButton();

		AccountCreatedPage accountCreated = registerAccountPage.signUp("Jasmeet", "Kaur", "Jassi1234@gmail.com",
				"6472152994", "Password1", "Password1");

		Assert.assertEquals(accountCreated.getSuccessAccountCreatedTxt(), AccountCreatedPage.RegisterAccountText.ACCOUNT_CREATED_TXT,
				"Account not created");

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
