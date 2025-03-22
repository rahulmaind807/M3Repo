package org.readExcelData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadExcelData {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testData/testData.xlsx"); //specify path of excel file
		Workbook wb = WorkbookFactory.create(fis); // To make file ready to read
		Sheet sheet = wb.getSheet("IPL"); // To go to the desired sheet
		Row row = sheet.getRow(4); // To go to the desired row
		Cell cell = row.getCell(1); // To go to the desired cell/column
		String data = cell.getStringCellValue(); // To read the data from desired cell column
		System.out.println(data);
	}
}
