package org.readExcelData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDatas {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testData/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	    Sheet sheet = wb.getSheet("IPL");
	    
	    int rowCount=sheet.getPhysicalNumberOfRows();
	    int cellCount=sheet.getRow(1).getPhysicalNumberOfCells();
	  
	    String [][]iplArr=new String[(rowCount)][cellCount];
	    for(int i=0;i<rowCount;i++) {
	    	for(int j=0;j<cellCount;j++) {
	    		iplArr[i][j]=sheet.getRow(i).getCell(j).toString();
	    	}
	    }
	    for(String []arr2:iplArr) {
	    	for(String data:arr2) {
	    		System.out.print(data+" ");
	    	}
	    	System.out.println();
	    }
	}
}