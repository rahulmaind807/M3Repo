package testNGListener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Flib {
	
	public String readDataFromPropertyFile(String propPath,String key) throws IOException {
		FileInputStream fis = new FileInputStream(propPath);
		Properties prop = new Properties();
		prop.load(fis);
		String data=prop.getProperty(key);
		
		return data;
	}
	
	public String readExcelData(String excelPath,String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis); 
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNo); 
		Cell cell = row.getCell(cellNo);
		String data = cell.toString(); 
		return data;
	}
	
	public int lastRowCount(String excelPath,String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int lr = sheet.getLastRowNum();
		return lr;
	}
}
