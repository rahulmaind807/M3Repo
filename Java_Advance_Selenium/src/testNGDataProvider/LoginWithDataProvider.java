package testNGDataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithDataProvider {
	
	@DataProvider(name="logincreds")
	public String[][] dataProviderMethod()
	{
		String [][] data= {
							{"dataprovider123@gmail.com","Asdf@12345"},
							{"datapr123@gmail.com","Asdf@1kbrty5"},
							{"data1234567890@gmail.com","Asdf@09876545"}
						  };
		return data;
		
	}
	
	@Test(dataProvider="logincreds",dataProviderClass=testNGDataProvider.LoginWithDataProvider.class)
	public void inValidLoginTC(String email,String password) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(3000);
		driver.quit();
  }
}
