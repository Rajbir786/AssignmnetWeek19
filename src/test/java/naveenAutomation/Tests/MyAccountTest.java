package naveenAutomation.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import naveenAutomation.Base.TestBase;
import naveenAutomation.Utils.ExcelUtils;
import naveenAutomation.pages.AccountLoginPage;
import naveenAutomation.pages.EditAccountInformationPage;
import naveenAutomation.pages.HomePage;
import naveenAutomation.pages.LaptopsNotebooksPage;
import naveenAutomation.pages.MyAccountPage;
import naveenAutomation.pages.NewsLetterSubscriptionPage;

public class MyAccountTest extends TestBase {

	HomePage myAccClikOnHomPage = new HomePage();

	SoftAssert sf = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		launchBrowser();

	}

	

	@Test
	public void verifyClickOnAllLaptopsAndNotebook() {
		myAccClikOnHomPage = new HomePage();
		AccountLoginPage accountLogin = myAccClikOnHomPage.clickMyAccountDropDown();
		MyAccountPage myAccount = accountLogin.login("rkkaler@gmail.com", "Password6");
		LaptopsNotebooksPage laptopBookPage = myAccount.clickOnAllLaptopsAndNotebook();
		Assert.assertEquals(laptopBookPage.verifyTitleOfPage(), "Laptops & Notebooks", "Wrong Page Navigation");

	}

	@Test
	public void verifyUserAbleToSubscribe() {
		myAccClikOnHomPage = new HomePage();
		AccountLoginPage accountLogin = myAccClikOnHomPage.clickMyAccountDropDown();
		MyAccountPage myAccount = accountLogin.login("rkkaler@gmail.com", "Password6");
		NewsLetterSubscriptionPage newsSubsPage = myAccount.subscribeOrNonSubscribeNewsLetter();
		myAccount = newsSubsPage.selectSubscriptionOfNewsLetter();
		Assert.assertEquals(myAccount.subscribeorUnsubscribeSuccessMessage(),
				"Success: Your newsletter subscription has been successfully updated!",
				"Subscribe/Unsubscribe not successfuly done");

	}

	@Test
	public void verifyUserAbleToChangePhnNumber() {
		myAccClikOnHomPage = new HomePage();
		AccountLoginPage accountLogin = myAccClikOnHomPage.clickMyAccountDropDown();
		MyAccountPage myAccount = accountLogin.login("rkkaler@gmail.com", "Password6");
		EditAccountInformationPage editInformation = myAccount.clickEditInformation();
		editInformation.changePhnNumber("2365569901");
		Assert.assertEquals(myAccount.getPhnNumberChangeSuccessMessage(),
				"Success: Your account has been successfully updated.", "Phn number does not change");

	}

	@Test(dataProvider = "LoginDataProvider")
	public void verifyAccountInfoOfFiveUsers(String userName, String password) 
	
	{
		HomePage myAccClikOnHomPage = new HomePage();
		 myAccClikOnHomPage.clickMyAccountDropDown();
		AccountLoginPage accountLoginPage = new AccountLoginPage();
		MyAccountPage myAccount=accountLoginPage.login(userName, password);
		Assert.assertEquals(myAccount.titleOfPage(),"My Account","You are not successfuly login");
		EditAccountInformationPage editAccInfo=myAccount.clickEditInformation();
	    Assert.assertFalse(editAccInfo.firstNameFieldFilledAlready().isEmpty());
	    Assert.assertFalse(editAccInfo.lastNameFieldFilledAlready().isEmpty());
	    Assert.assertFalse(editAccInfo.emailFieldFilledAlredy().isEmpty());
	    Assert.assertFalse(editAccInfo.telephoneFieldFilledAlready().isEmpty());
		
		
	}

	@DataProvider(name = "LoginDataProvider")
	///any method provide data use dataprovider=name to which  method
	public String[][] provideLoginData() throws IOException {
		String filePath = "C:\\Users\\Rajbir\\eclipse-workspace\\naveenAutomationAssignment\\Test Data\\LoginDetails.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath,"Sheet3");
		int colCount = ExcelUtils.getColumnCount(filePath,"Sheet3",rowCount);
	     String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath,"Sheet3", i, j);
			}
		}
		return loginData;

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();

	}

}
