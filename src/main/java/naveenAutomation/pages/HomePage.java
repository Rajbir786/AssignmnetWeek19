package naveenAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import naveenAutomation.Base.TestBase;

public class HomePage extends TestBase {
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement myAccountDropDown;

	@FindBy(css = "ul.dropdown-menu.dropdown-menu-right li:first-of-type a")
	WebElement RegisterOptionFromMyAccountDropDown;
	@FindBy(css = "ul.dropdown-menu.dropdown-menu-right li:nth-of-type(2) a")
	WebElement loginOptionFromMyAccountDropDown;

	public UserRegistrationPage clickMyAccountDropDown1() {
		myAccountDropDown.click();
		RegisterOptionFromMyAccountDropDown.click();
		return new UserRegistrationPage();

	}

	public AccountLoginPage clickMyAccountDropDown() {
		myAccountDropDown.click();
		loginOptionFromMyAccountDropDown.click();
		return new AccountLoginPage();

	}

}
