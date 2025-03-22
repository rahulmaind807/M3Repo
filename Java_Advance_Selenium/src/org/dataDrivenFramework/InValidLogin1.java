package org.dataDrivenFramework;

import java.io.IOException;

import org.openqa.selenium.By;
import org.readPropertData.Flib;
import org.readPropertData.IAutoConstant;

public class InValidLogin1 extends BaseTest implements IAutoConstant {
	public static void main(String[] args) throws IOException, InterruptedException {
		Flib flib = new Flib();
		BaseTest bt = new BaseTest();
		bt.browserSetUp();
		
		driver.findElement(By.linkText("Log in")).click();
		
		int lastCount=flib.lastRowCount(EXCEL_PATH, INVALIDLOGINCREDS);
		
		for(int i=1;i<=lastCount;i++) {
			String email=flib.readExcelData(EXCEL_PATH, INVALIDLOGINCREDS, i, 0);
			String pass=flib.readExcelData(EXCEL_PATH, INVALIDLOGINCREDS, i, 1);
			
			driver.findElement(By.id("Email")).sendKeys(email);
			driver.findElement(By.id("Password")).sendKeys(pass);
			driver.findElement(By.xpath("//input[@value='Log in']")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Email")).clear();
			driver.findElement(By.id("Password")).clear();
		}
	}
}
