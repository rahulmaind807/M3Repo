package org.dataDrivenFramework;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.readPropertData.Flib;
import org.readPropertData.IAutoConstant;

public class InValidLogin implements IAutoConstant {
	public static void main(String[] args) throws IOException, InterruptedException {
		Flib flib=new Flib();
		String url=flib.readDataFromPropertyFile(PROP_PATH,URL);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		
		driver.findElement(By.linkText("Log in")).click();
		
		for(int i=1;i<=4;i++) {
			String email=flib.readExcelData(EXCEL_PATH, INVALIDLOGINCREDS, i, 0);
			String pass=flib.readExcelData(EXCEL_PATH, INVALIDLOGINCREDS, i, 1);
			
			driver.findElement(By.id("Email")).sendKeys(email);
			driver.findElement(By.id("Password")).sendKeys(pass);
			driver.findElement(By.xpath("//input[@value='Log in']")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("Email")).clear();
			driver.findElement(By.id("Password")).clear();
		}
	}
}