package naveenAutomation.Tests;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import naveenAutomation.Utils.ExcelUtils;

public class TestClass {
	@Test

	public static void main(String[] args) throws IOException {
		String filePath = "C:\\Users\\Rajbir\\eclipse-workspace\\naveenAutomationAssignment\\Test Data\\LoginDetails.xlsx";

		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet2");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet2", rowCount);
		System.out.println("row and colum count " + rowCount + " " + colCount);
		//String[][] loginData= new String[rowCount][colCount];
	}

}