package naveenAutomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import naveenAutomation.Base.TestBase;

public class OrderHistoryPage extends TestBase {
	public WebElement getElementFromTheTable(String orderID, OrderHistory column) {

		int columnIndex = getIndexForColumn(column);// find index of column by this method and store into columnindex
													// varibale

		List<WebElement> rowsInTable = driver// findrows of table
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] tbody tr"));
//find list of rows in table
		for (int i = 0; i < rowsInTable.size(); i++) // go over each row of table
		{
			List<WebElement> cells = rowsInTable.get(i).findElements(By.cssSelector("td"));// find cells of each row
			String orderIdText = cells.get(0).getText();// find text of first cell of row that is unique id
			if (orderIdText.equals(orderID))// if order id given is same as unique id given
			{
				return cells.get(columnIndex);// then return that particular cell whose index is same as given index
			}

		}

		System.out.println("Column name was not found!!!");
		return null;
	}

//this method will find index of coulmn and we will pass coulmn where we want to find element
	public int getIndexForColumn(OrderHistory column) {
		List<WebElement> headers = driver
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] thead tr td"));// find all
																												// headers
																												// in
																												// table

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

	public enum OrderHistory {

		ORDERID("Order ID"), CUSTOMER("Customer"), NOOFPRODUCTS("No. of Products"), STATUS("Status"), TOTAL("Total"),
		DATAADDED("Date Added");

		String name;

		private OrderHistory(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

}
