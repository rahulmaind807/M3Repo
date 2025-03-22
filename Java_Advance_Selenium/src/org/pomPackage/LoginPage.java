package org.pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//Declaration
	@FindBy(id ="Email") private WebElement emailTextBox;
	@FindBy(id ="Pass") private WebElement passwordTextBox;
	@FindBy(xpath = "//input[@value='Log in']") private WebElement loginButton;
	@FindBy(id ="RememberMe") private WebElement rememberMeCheckBox;
	@FindBy(xpath = "//a[text()='Forgot password?']") private WebElement forgotPasswordLink;
	
	//Initialization
	LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	
	//Utilization
	public WebElement getEmailTextBox() {
		return emailTextBox;
	}
	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public WebElement getRememberMeCheckBox() {
		return rememberMeCheckBox;
	}
	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}
}
