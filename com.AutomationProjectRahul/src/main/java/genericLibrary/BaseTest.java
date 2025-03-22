package genericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPackage.LoginPage;
import pomPackage.WelcomePage;

public class BaseTest implements IAutoConstant {
	protected static WebDriver driver;
	@BeforeClass
	public void browserSetup() throws IOException {

		Flib flib = new Flib();
		String browserValue = flib.readPropertyData(PROP_PATH_MAIN, "chrome");
		String url = flib.readPropertyData(PROP_PATH_MAIN, URL);
		if(browserValue.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browserValue.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else {
			System.out.println("Enter valid browser name");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}

	@BeforeMethod
	public void validLogin() throws EncryptedDocumentException, IOException, InterruptedException {
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();

		LoginPage lp = new LoginPage(driver);
		Flib flib = new Flib();
		String email = flib.readExcelStringData(EXCEL_PATH_MAIN, VALIDLOGINCREDS, 1, 0);
		String password = flib.readExcelStringData(EXCEL_PATH_MAIN, VALIDLOGINCREDS, 1, 1);
		lp. validLoginMethod(email, password);

	}

	@AfterMethod
	public void logOut() throws InterruptedException {
		WelcomePage wp = new WelcomePage(driver);
		Thread.sleep(5000);
		wp.logout();
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}


}