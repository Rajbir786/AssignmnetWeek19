
package naveenAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import naveenAutomation.Base.TestBase;

public class EditAccountInformationPage extends TestBase {
	public EditAccountInformationPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css ="[name='firstname']")
	WebElement firstNameInputField;
	@FindBy(css ="[name='lastname']")
	WebElement lastNameInputField;
	@FindBy(css ="[name='email']")
	WebElement emailInputField;
	@FindBy(css = "input[type='tel']")
	WebElement telephoneChangeInputField;
    @FindBy(css = "input[type='submit']")
	WebElement continueBtnForPhnNumChange;
	
	public String firstNameFieldFilledAlready() {
	String firstName=firstNameInputField.getAttribute("value");
	return firstName;
		}
	public String lastNameFieldFilledAlready() {
		String lastName=lastNameInputField.getAttribute("value");
		return lastName;
	}
	public String emailFieldFilledAlredy() {
		String email=  emailInputField.getAttribute("value");
		return email;
		
	}
	public String telephoneFieldFilledAlready() {
		String telephone=telephoneChangeInputField.getAttribute("value");
		return telephone;
	}
	private void telephoneChangeInputField(String telephoneNumb) {
		telephoneChangeInputField.clear();
		telephoneChangeInputField.sendKeys(telephoneNumb);
	}

	public MyAccountPage changePhnNumber(String telephoneNumb) {
		telephoneChangeInputField(telephoneNumb);
		continueBtnForPhnNumChange.submit();
		return new MyAccountPage();

	}

}