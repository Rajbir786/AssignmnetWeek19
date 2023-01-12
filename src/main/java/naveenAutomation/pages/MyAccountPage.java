package naveenAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import naveenAutomation.Base.TestBase;

;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccountText;
	@FindBy(css = "#content.col-sm-9 ul.list-unstyled:first-of-type li:first-of-type a")
	WebElement editYourInformationLink;

	@FindBy(css = "div.alert-success")
	WebElement phnNumberChangesSuccessBanner;
	@FindBy(css = "div.alert.alert-success.alert-dismissible")
	WebElement subscribeOrUnSubscribeSuccessBanner;
	@FindBy(css = "#content.col-sm-9 ul.list-unstyled:nth-of-type(4) a")
	WebElement subscribeOrnonSubscribeLink;
	@FindBy(css = "div.list-group a:last-of-type")
	WebElement logOutLink;
	@FindBy(css = "ul.nav.navbar-nav li.dropdown:nth-of-type(2) a.dropdown-toggle")
	WebElement LaptopsNoteBooksDropDown;
	@FindBy(css = "li.dropdown.open div.dropdown-menu a.see-all")
	WebElement showAllLaptopsAndNoteBooksLink;
	@FindBy(css = "div.list-group a:nth-of-type(4)")
	WebElement AddressBookLink;

	public String getMyAccountText() {
		return myAccountText.getText();
	}

	public EditAccountInformationPage clickEditInformation() {
		editYourInformationLink.click();
		return new EditAccountInformationPage();

	}
	public String titleOfPage() {
		return driver.getTitle();
	}

	public String getPhnNumberChangeSuccessMessage() {
		return phnNumberChangesSuccessBanner.getText();
	}

	public String subscribeorUnsubscribeSuccessMessage() {
		return subscribeOrUnSubscribeSuccessBanner.getText();

	}
	public AddressBookPage clickAddressBookLink() {
		AddressBookLink.click();
		return new AddressBookPage();
		
		
	}

	@FindBy(css = "div.list-group a:nth-of-type(6)")
	WebElement orderHistoryLink;

	public NewsLetterSubscriptionPage subscribeOrNonSubscribeNewsLetter() {
		subscribeOrnonSubscribeLink.click();
		return new NewsLetterSubscriptionPage();

	}

	public AccountLogOutPage LogOut() {

		logOutLink.click();
		return new AccountLogOutPage();

	}

	public OrderHistoryPage clickOrderHistoryLink() {
		orderHistoryLink.click();
		return new OrderHistoryPage();
	}

	public LaptopsNotebooksPage clickOnAllLaptopsAndNotebook() {
		LaptopsNoteBooksDropDown.click();
		showAllLaptopsAndNoteBooksLink.click();
		return new LaptopsNotebooksPage();
	}

}