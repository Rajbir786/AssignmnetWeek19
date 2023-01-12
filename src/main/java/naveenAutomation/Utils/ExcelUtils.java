package naveenAutomation.Utils;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;

	public static XSSFWorkbook wb;//nomenclature for worksheet
	public static XSSFSheet ws;//represent sheet number
	public static XSSFRow row;//represent row number
	public static XSSFCell cell;//represent cell number

	public static int getRowCount(String xFile,String sheetName) throws IOException {

		int rowCount = 0;
		// Fetch the file
		fi = new FileInputStream(xFile);//find file
		// Initialize the Work Book
		wb = new XSSFWorkbook(fi);//find workbook from file
		// Get the sheet from Work book
		ws = wb.getSheet(sheetName);//pass sheetname and fetch it from workbook
		// Get the last row.
		rowCount = ws.getLastRowNum();//sheet's last row num will tell us how many trows in sheet
		System.out.println(rowCount );

		wb.close();
		fi.close();

		return rowCount;

	}

	public static int getColumnCount(String xFile, String sheetName, int rowNo) throws IOException {

		int colCount = 0;
		// Fetch the file
		fi = new FileInputStream(xFile);
		// Initialize the Work Book
		wb = new XSSFWorkbook(fi);
		// Get the last row.
		ws = wb.getSheet(sheetName);

		row = ws.getRow(rowNo);//by knowing number of row number like 5 we will find last cell num of rfow like e57 then coulmun um is 7
		colCount = row.getLastCellNum();
		wb.close();//resource needs to be change
		fi.close();
		return colCount;

	}

	public static String getCellValue(String xFile, String sheetName, int rowNo, int colCount) throws IOException {

		String data = "";
		fi = new FileInputStream(xFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNo);
		cell = row.getCell(colCount);//like column num 7  by passing column we will find cell from that partivcular row
		data = new DataFormatter().formatCellValue(cell);

		return data;

	}

}


