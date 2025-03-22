package org.testNG1;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ToUnderstandPriorityAttribute
{
  @Test(priority=-1)
  public void method2() {
	  Reporter.log("This is testNG method2", true);
  }
  
  @Test(priority=-2)
  public void method1() {
	  Reporter.log("This is testNG method1", true);
  }
  
  @Test(priority=0)
  public void register() {
	  Reporter.log("This is Register Method", true);
  }
  
  @Test(priority=1)
  public void login() {
	  Reporter.log("This is Login Method", true);
  }
  
  @Test(priority=4)
  public void logout() {
	  Reporter.log("This is Lgout Method", true);
  }
  
  @Test(priority=2)
  public void checkAccountBalance() {
	  Reporter.log("This is Check Account Balance Method", true);
  }
  
  @Test(priority=3)
  public void moneyTransfer() {
	  Reporter.log("This is Money Transfer Method", true);
  }
}
