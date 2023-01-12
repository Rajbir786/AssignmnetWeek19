package naveenAutomation.Tests;

import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import naveenAutomation.Base.TestBase;
import naveenAutomation.pages.AccountLoginPage;
import naveenAutomation.pages.HomePage;
import naveenAutomation.pages.LaptopsNotebooksPage;
import naveenAutomation.pages.MyAccountPage;

public class LaptopsNotebooksTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		launchBrowser();

	}

	@Test
	public void verifyClickSortAndSelectOption() {
		HomePage myAccClikOnHomPage = new HomePage();
		AccountLoginPage accountLogin = myAccClikOnHomPage.clickMyAccountDropDown();
		MyAccountPage myAccount = accountLogin.login("rkkaler@gmail.com", "Password6");
		LaptopsNotebooksPage laptopBookPage = myAccount.clickOnAllLaptopsAndNotebook();

	}

	@AfterMethod
	public void tearDown() {
		// quitBrowser();

	}

}
