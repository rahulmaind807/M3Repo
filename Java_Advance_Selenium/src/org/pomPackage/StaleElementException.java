package org.pomPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementException 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.linkText("Log in")).click();
		WebElement email = driver.findElement(By.id("Email"));
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		//email.sendKeys("as11dfghjkl@gmail.com"); //Shows StaleElementException
		
		driver.findElement(By.id("Email")).sendKeys("as11dfghjkl@gmail.com");
		Thread.sleep(2000);
		
		WebElement pass=driver.findElement(By.id("Password"));
		pass.sendKeys("abcd@1234");
		
		WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log in']"));
		logInButton.click();
	}
}
