package org.readExcelData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToWriteDataIntoExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testData/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("IPL");//to make ready to read file
		Row row = sheet.getRow(1);//to get into thr row
		Cell cell = row.createCell(2);//To create a new column
		cell.setCellValue("PUNE"); //Value inserted in Cell
		
		FileOutputStream fos=new FileOutputStream("./testData/testData.xlsx");
		wb.write(fos);
		System.out.println("Done"); // To Write Data in Excel File
	}
}
