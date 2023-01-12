package naveenAutomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import naveenAutomation.Base.TestBase;

public class WishListPage extends TestBase {
	public WishListPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tr:last-of-type td.text-right a")
	WebElement deleteLinkForLastProduct;
	@FindBy(css = "div.alert.alert-success ")
	WebElement successBannerAfterDeletingProduct;

	public String titleOfPage() {
		String title = driver.getTitle();
		return title;

	}

	public void deleteProduct(String ProductName, MyWishList column, By Locator) {
		getElementFromTheTable(ProductName, column).findElement(Locator).click();
	}

	public String successBannerAfterDeletingProductFromWishList() {

		return successBannerAfterDeletingProduct.getText();
	}

	public WebElement getElementFromTheTable(String ProductName, MyWishList column) {

		int columnIndex = getIndexForColumn(column);// find index of column by this method and store into columnindex
													// varibale

		List<WebElement> rowsInTable = driver// findrows of table
				.findElements(By.cssSelector("table.table.table-bordered.table-hover tbody tr"));
//find list of rows in table
		for (int i = 0; i < rowsInTable.size(); i++) // go over each row of table
		{
			List<WebElement> cells = rowsInTable.get(i).findElements(By.cssSelector("td"));// find cells of each row
			String orderIdText = cells.get(1).getText();// find text of first cell of row that is unique id
			if (orderIdText.equals(ProductName))// if order id given is same as unique id given
			{
				return cells.get(columnIndex);// then return that particular cell whose index is same as given index
			}

		}

		System.out.println("Column name was not found!!!");
		return null;
	}

	public int getIndexForColumn(MyWishList column) {
		List<WebElement> headers = driver
				.findElements(By.cssSelector("table.table.table-bordered.table-hover thead tr td"));// find all headers
																									// in table

		for (WebElement webElement : headers)// iterate over headers
		{
			String headerText = webElement.getText();// find text of each heading
			if (headerText.equals(column.getName()))
			// if text of heading matches with column name we pss then find index of that
			// header
			{
				return headers.indexOf(webElement);
			}

		}
		System.out.println("Column does not exist.....");
		return -1;
	}

	public enum MyWishList {
		IMAGE("Image"),
		PRODUCTNAME("Product Name"), 
		MODEL("Model"), 
		STOCK("Stock"),
		UNITPRICE("Unit Price"),
		ACTION("Action");

		String name;

		private MyWishList(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

}
