package testNGListener;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.readPropertData.Flib;
import org.readPropertData.IAutoConstant;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant {
	static WebDriver driver;
	@BeforeMethod
	public void browserSetUp() throws IOException {

		Flib flib=new Flib();
		String browserValue=flib.readDataFromPropertyFile(PROP_PATH, "chrome");
		String url=flib.readDataFromPropertyFile(PROP_PATH, URL);
		
		if(browserValue.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}
		
		else if(browserValue.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}
		
		else{
			System.out.println("Enter valid Browser name!!!");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}
	@AfterMethod
	public void browserTareDown() {
		driver.quit();
	}
}
