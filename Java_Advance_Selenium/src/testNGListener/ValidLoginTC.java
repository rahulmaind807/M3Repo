package testNGListener;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(MyListeners.class)
@Listeners(testNGListener.MyListeners.class)
public class ValidLoginTC extends BaseTest 
{
	@Test
	public void validLogin() throws EncryptedDocumentException, IOException {
	WelcomePage wp=new WelcomePage(driver);
	wp.getLoginLink().click();
	
	Flib flib=new Flib();
	String email=flib.readExcelData(EXCEL_PATH, VALIDLOGINCREDS, 1, 3);
	String pass=flib.readExcelData(EXCEL_PATH, VALIDLOGINCREDS, 1, 4);
	
	LoginPage lp=new LoginPage(driver);
	lp.validLoginMethod(email, pass);
	}
}
