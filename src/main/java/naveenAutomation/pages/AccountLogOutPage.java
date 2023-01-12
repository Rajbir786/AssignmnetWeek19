package naveenAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import naveenAutomation.Base.TestBase;

public class AccountLogOutPage extends TestBase {
	public AccountLogOutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h1")
	WebElement accountLogOut;
	@FindBy(css = "div.buttons div.pull-right a")
	WebElement continueButtonForLogOut;

	public String AccountLogOutText() {
		return accountLogOut.getText();

	}

	public String TitleOfAccountLogOut() {
		return driver.getTitle();
	}

	public HomePage AccountLogOutDetails() {
		continueButtonForLogOut.click();
		return new HomePage();

	}

}
