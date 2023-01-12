package naveenAutomation.pages;

	import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import naveenAutomation.Base.TestBase;



	public class AccountLoginPage extends TestBase {

		public AccountLoginPage() {
			PageFactory.initElements(driver, this);//intiliaze the elements and rv of driver and class,it store id inside it when we consume it 
			
		}

		@FindBy(css ="form div.form-group:first-of-type input")
		WebElement emailInputField;

		@FindBy(css ="form div.form-group:last-of-type input")
		WebElement passwordInputField;

		@FindBy(css = "input[type='submit']")
		WebElement loginBtn;

		private void enterEmailInputField(String email) {
			emailInputField.sendKeys(email);
		}

		private void enterPasswordInputField(String password) {
			passwordInputField.sendKeys(password);
		}
		@FindBy(css = "div.alert")
		WebElement alertBanner;

		public MyAccountPage login(String email, String password) {
			enterEmailInputField(email);
			enterPasswordInputField(password);
			loginBtn.submit();
			return new MyAccountPage();

		}
		public String getTextFromAlertBanner() {
			return alertBanner.getText();
		}


}
