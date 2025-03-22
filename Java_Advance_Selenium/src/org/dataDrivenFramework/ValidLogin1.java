package org.dataDrivenFramework;
import java.io.IOException;

import org.openqa.selenium.By;
import org.readPropertData.Flib;
import org.readPropertData.IAutoConstant;

public class ValidLogin1 extends BaseTest implements IAutoConstant {
	public static void main(String[] args) throws IOException, InterruptedException {
		Flib flib = new Flib();
		
		String email=flib.readExcelData(EXCEL_PATH, VALIDLOGINCREDS, 1, 0);
		String password=flib.readExcelData(EXCEL_PATH, VALIDLOGINCREDS, 1, 1);
		
		BaseTest bt = new BaseTest();
		bt.browserSetUp();
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(3000);
		driver.close();
	}
}