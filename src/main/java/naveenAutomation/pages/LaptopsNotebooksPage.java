package naveenAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import naveenAutomation.Base.TestBase;

public class LaptopsNotebooksPage extends TestBase {

	public LaptopsNotebooksPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyTitleOfPage() {
		return driver.getTitle();
	}

	@FindBy(css = "select#input-sort.form-control")
	WebElement sortByDropDown;
	@FindBy(css = "select#input-sort.form-control")
	WebElement selectRatingHighToLowSelectFromSortByDropDown;
	@FindBy(css = "button[onclick=\"wishlist.add('46');\"]")
	WebElement firstProductAddToWishList;
	@FindBy(css = "button[onclick=\"wishlist.add('45');\"]")
	WebElement secondProductAddToWishList;
	@FindBy(css = "button[onclick=\"wishlist.add('44');\"]")
	WebElement thirdProductAddToWishList;
	@FindBy(css = "div.alert.alert-success.alert-dismissible a:last-of-type")
	WebElement wishListLink;
	@FindBy(css = "div.alert.alert-success")
	WebElement successBannerAtWishListPage;

	public String successBannerOfAddedProductToWishList() {
		return successBannerAtWishListPage.getText();

	}

	public void sortByDropDown() {
		selectByIndex(selectRatingHighToLowSelectFromSortByDropDown, 5);
	}

	public void clickOnFirstProduct() {
		firstProductAddToWishList.click();
		sleep();
		successBannerOfAddedProductToWishList();
	}

	public void clickOnSecondProduct() {
		secondProductAddToWishList.click();
		sleep();

		successBannerOfAddedProductToWishList();
	}

	public void clickOnThirdProduct() {
		thirdProductAddToWishList.click();

		sleep();
		successBannerOfAddedProductToWishList();

	}


	public WishListPage wishLinkClick() {
		wishListLink.click();
		return new WishListPage();
	}

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String successbanner() {
		return successBannerAtWishListPage.getText();

	}

	public void selectByIndex(WebElement element, int index) {
		Select sc = new Select(selectRatingHighToLowSelectFromSortByDropDown);
		sc.selectByIndex(5);
	}

}
