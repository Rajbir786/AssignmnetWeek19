package naveenAutomation.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import naveenAutomation.Base.TestBase;
import naveenAutomation.Utils.ExcelUtils;
import naveenAutomation.pages.AccountLoginPage;

public class AccountLoginTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}

	@Test(dataProvider = "LoginDataProvider")
	public void verifyAlertBannerForInvalidLoginCredentials(String username, String password) {
		AccountLoginPage accountLoginPage = new AccountLoginPage(driver,true).get();
		accountLoginPage.login(username, password);
		Assert.assertEquals(accountLoginPage.getTextFromAlertBanner(),
				"Warning: No match for E-Mail Address and/or Password.", "Alert text doesn't match");
	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] provideLoginData() throws IOException {
		String filePath = "C:\\Users\\Rajbir\\eclipse-workspace\\naveenAutomation\\Test Data\\LoginDetails.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath,"Sheet3");
		System.out.println(rowCount);
		int colCount = ExcelUtils.getColumnCount(filePath,"Sheet3",rowCount);
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet3", i, j);
			}
		}
		return loginData;

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
