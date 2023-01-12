package naveenAutomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import naveenAutomation.Base.TestBase;

public class AddressBookPage extends TestBase {

	public AddressBookPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "input[type='submit']")
	WebElement continueBtn;

	public void editAddress(String PostCode,int ColumnIndex, By locator) {
		getElementFromTheTable(PostCode,ColumnIndex).findElement(locator).click();
	
	}
	public AddressBookPage clickContinue() {
		continueBtn.click();
		return new AddressBookPage();
	}

	public WebElement getElementFromTheTable(String PostCode,int ColumnIndex) {

		// find index of column by this method and store into columnindex
		// varibale

		List<WebElement> rowsInTable = driver
				.findElements(By.cssSelector("table.table.table-bordered.table-hover tbody tr"));
		// find list of rows in table
		for (int i = 0; i < rowsInTable.size(); i++) // go over each row of table
		{
			List<WebElement> cells = rowsInTable.get(i).findElements(By.cssSelector("td"));// find cells of each row
			String fulladdressText = cells.get(0).getText();
			String[] fullTextAddressEachLineArray = fulladdressText.split("\n");
			for (int j = 0; i < fullTextAddressEachLineArray.length; j++) {
				
				String[] divisionOfEachLineAddressArray = fullTextAddressEachLineArray[j].split(" ");
				for (int k = 0; k < divisionOfEachLineAddressArray.length; k++)
					if (divisionOfEachLineAddressArray[k].equals(PostCode))// if order id given is same as unique id given
					{
						// find text of first cell of row that is unique id
						return cells.get(ColumnIndex);// then return that particular cell whose index is same as given index
					}

			}

		}
		System.out.println("Column name was not found!!!");
		return null;
	}

}
