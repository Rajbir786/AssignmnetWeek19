package naveenAutomation.Tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import naveenAutomation.Base.TestBase;
import naveenAutomation.pages.AccountLoginPage;
import naveenAutomation.pages.HomePage;
import naveenAutomation.pages.LaptopsNotebooksPage;
import naveenAutomation.pages.MyAccountPage;
import naveenAutomation.pages.WishListPage;
import naveenAutomation.pages.WishListPage.MyWishList;

public class WishListTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		launchBrowser();

	}

	@Test
	public void verifyTitleOfPageItemSelectedwithPrice() {

		HomePage myAccClikOnHomPage = new HomePage();
		AccountLoginPage accountLogin = myAccClikOnHomPage.clickMyAccountDropDown();
		MyAccountPage myAccount = accountLogin.login("rkkaler@gmail.com", "Password6");
		LaptopsNotebooksPage laptopBookPage = myAccount.clickOnAllLaptopsAndNotebook();
		laptopBookPage.sortByDropDown();
		laptopBookPage.clickOnFirstProduct();
		Assert.assertEquals(laptopBookPage.successBannerOfAddedProductToWishList(),
				"Success: You have added Sony VAIO to your wish list!\n×", "ProductNotSuccessfully added");
		laptopBookPage.clickOnSecondProduct();
		Assert.assertEquals(laptopBookPage.successBannerOfAddedProductToWishList(),
				"Success: You have added MacBook Pro to your wish list!\n×", "ProductNotSuccessfully added");
		laptopBookPage.clickOnThirdProduct();
		Assert.assertEquals(laptopBookPage.successBannerOfAddedProductToWishList(),
				"Success: You have added MacBook Air to your wish list!\n×", "ProductNotSuccessfully added");
		WishListPage wishList = laptopBookPage.wishLinkClick();
		Assert.assertEquals(wishList.titleOfPage(), "My Wish List", "PageNavigationWrong");
		String nameMackBookAir = wishList.getElementFromTheTable("MacBook Air", MyWishList.PRODUCTNAME).getText();
		Assert.assertEquals(nameMackBookAir, "MacBook Air", "WrongProduct");
		String priceMackBookAir = wishList.getElementFromTheTable("MacBook Air", MyWishList.UNITPRICE).getText();
		Assert.assertEquals(priceMackBookAir, "$1,202.00", "WrongPrice");
		String nameMackBookPro = wishList.getElementFromTheTable("MacBook Pro", MyWishList.PRODUCTNAME).getText();
		Assert.assertEquals(nameMackBookPro, "MacBook Pro", "WrongProduct");
		String priceMackBookPro = wishList.getElementFromTheTable("MacBook Pro", MyWishList.UNITPRICE).getText();
		Assert.assertEquals(priceMackBookPro, "$2,000.00", "WrongPrice");
		String nameSonyVaio = wishList.getElementFromTheTable("Sony VAIO", MyWishList.PRODUCTNAME).getText();
		Assert.assertEquals(nameSonyVaio, "Sony VAIO", "WrongProduct");
		String priceSonyVaio = wishList.getElementFromTheTable("Sony VAIO", MyWishList.UNITPRICE).getText();
		Assert.assertEquals(priceSonyVaio, "$1,202.00", "WrongPrice");
		wishList.deleteProduct("Sony VAIO",MyWishList.ACTION,By.cssSelector("a"));
		Assert.assertEquals(wishList.successBannerAfterDeletingProductFromWishList(),
				"Success: You have modified your wish list!\n×", "Unsuccessful Modification");

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();

	}

}
