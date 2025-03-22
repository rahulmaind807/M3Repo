package org.dataDrivenFramework;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.readPropertData.Flib;
import org.readPropertData.IAutoConstant;

public class ValidLogin implements IAutoConstant {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Flib flib=new Flib();
		String email=flib.readExcelData(EXCEL_PATH,VALIDLOGINCREDS,1,0);
		String pass=flib.readExcelData(EXCEL_PATH,VALIDLOGINCREDS,1,1);
		
		String url=flib.readDataFromPropertyFile(PROP_PATH, URL);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(url);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
}
