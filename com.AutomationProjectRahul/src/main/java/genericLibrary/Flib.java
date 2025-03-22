package genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Flib {
	
	public String readPropertyData(String propPath,String key) throws IOException {
		FileInputStream fis = new FileInputStream(propPath);
		Properties prop = new Properties();
		prop.load(fis);
		String data=prop.getProperty(key);
		
		return data;
	}
	
	public String readExcelStringData(String excelPath,String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
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
	
	public int randomNumber() {
		Random random=new Random();
		int number=random.nextInt(1000,9999);
		return number;
	}
	
	public long readExcelNumberData(String excelPath,String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis); 
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNo); 
		Cell cell = row.getCell(cellNo);
		long data =(long) cell.getNumericCellValue();
		return data;
	}
}
