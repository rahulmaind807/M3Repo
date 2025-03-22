package testNGAnnotation;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ToUnderstandAnnotation {
	
	  @BeforeSuite
	  public void beforeSuite() {
		  Reporter.log("This is BeforeSuite",true);
	  }
	  
	  @BeforeTest
	  public void beforeTest() {
		  Reporter.log("This is BeforeTest",true);
	  }
	  @BeforeClass
	  public void beforeClass() {
	  Reporter.log("This is BeforeClass",true);
	  }
  
	  @BeforeMethod
	  public void beforeMethod() {
	  Reporter.log("This is BeforeMethod",true);
	  }
	  
	  @Test
	  public void test() {
		  Reporter.log("This is Test",true); 
	  }

	  @AfterMethod
	  public void afterMethod() {
	  Reporter.log("This is AfterMethod",true);
	  }
  
	  @AfterClass
	  public void afterClass() {
	  Reporter.log("This is AfterClass",true);
	  }
	  
	  @AfterTest
	  public void afterTest() {
	  Reporter.log("This is AfterTest",true);
	  }
	  
	  @AfterSuite
	  public void afterSuit() {
		  Reporter.log("This is AfterSuit",true); 
	  }
  
}
