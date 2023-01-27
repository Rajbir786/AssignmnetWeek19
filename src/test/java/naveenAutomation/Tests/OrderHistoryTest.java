package naveenAutomation.Tests;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import naveenAutomation.Base.TestBase;
import naveenAutomation.pages.AccountLoginPage;
import naveenAutomation.pages.MyAccountPage;
import naveenAutomation.pages.OrderHistoryPage;
import naveenAutomation.pages.OrderHistoryPage.OrderHistory;

public class OrderHistoryTest extends TestBase {
	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}

	@Test
	public void verifyPriceForOrder() {
		AccountLoginPage accountLoginPage = new AccountLoginPage(driver,true).get();
		MyAccountPage myAccountPage=accountLoginPage.login("iron.man@gmail.com", "Password2");
		OrderHistoryPage orderHistoryPage=myAccountPage.clickOrderHistoryLink();
		WebElement priceElement=orderHistoryPage.getElementFromTheTable("#2539", OrderHistory.CUSTOMER);
		Assert.assertEquals(priceElement.getText(), "priceElement.getText()");
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
	