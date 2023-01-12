package naveenAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import naveenAutomation.Base.TestBase;

public class NewsLetterSubscriptionPage extends TestBase {

	public NewsLetterSubscriptionPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[value='0']")
	WebElement selectUnSubscribeRadioButton;
	@FindBy(css = "input[type='submit']")
	WebElement continueButtonAfterUnSubscribtion;

	public MyAccountPage selectSubscriptionOfNewsLetter() {
		selectUnSubscribeRadioButton.isSelected();
		continueButtonAfterUnSubscribtion.click();
		return new MyAccountPage();
	}

}
