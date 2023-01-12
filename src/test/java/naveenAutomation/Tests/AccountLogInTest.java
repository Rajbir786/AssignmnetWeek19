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

public class AccountLogInTest extends TestBase {

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
	
	@Test(dataProvider = "AccountInfoDataProvider")
	public void verifyAccountInfoOfUsers(String username, String password,String firstname,String lastname,String email,String telephone) 
	
	{
		HomePage myAccClikOnHomPage = new HomePage();
		 myAccClikOnHomPage.clickMyAccountDropDown();
		AccountLoginPage accountLoginPage = new AccountLoginPage();
		MyAccountPage myAccount=accountLoginPage.login(username, password);
		Assert.assertEquals(myAccount.titleOfPage(),"My Account","You are not successfuly login");
		EditAccountInformationPage editAccInfo=myAccount.clickEditInformation();
		Assert.assertEquals(editAccInfo.firstNameFieldFilledAlready(),firstname,"Wrong firstname");
		Assert.assertEquals(editAccInfo.lastNameFieldFilledAlready(),lastname,"Wrong firstname");
		Assert.assertEquals(editAccInfo.emailFieldFilledAlredy(),email,"Wrong firstname");
		Assert.assertEquals(editAccInfo.telephoneFieldFilledAlready(),telephone,"Wrong firstname");
		
	}
	@DataProvider(name = "AccountInfoDataProvider")
	///any method provide data use dataprovider=name to which  method
	public String[][] provideAccountInfo() throws IOException {
		String filePath = "C:\\Users\\Rajbir\\eclipse-workspace\\naveenAutomation\\Test Data\\LoginDetails.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath,"Sheet5");
		int colCount = ExcelUtils.getColumnCount(filePath,"Sheet5",rowCount);
	     String[][] AccountInfoData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				AccountInfoData[i - 1][j] = ExcelUtils.getCellValue(filePath,"Sheet5", i, j);
			}
		}
		
		return AccountInfoData;

	}




	@AfterMethod
	public void tearDown() {
		quitBrowser();

	}
}