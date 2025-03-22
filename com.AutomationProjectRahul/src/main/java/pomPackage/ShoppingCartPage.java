package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	@FindBy(xpath = "//h1[text()='Shopping cart']/../..//img[@title='Show details for Smartphone']") 
	private WebElement smartPhoneCartproduct;
	
	@FindBy(xpath = "//h1[text()='Shopping cart']/../..//img[@title='Show details for Smartphone']/../..//input[@name='removefromcart']") 
	private WebElement smartPhoneCheckBox;
	
	@FindBy(name = "updatecart") private WebElement updateShoppingCartButton; 
	@FindBy(name = "continueshopping") private WebElement continueShoppingButton; 
	@FindBy(id = "termsofservice") private WebElement termsOfServiceCheckBox;
	@FindBy(id = "checkout") private WebElement checkOutButton;
	
	
	public ShoppingCartPage(WebDriver driver) {
		
		PageFactory.initElements( driver, this);
	}

	public WebElement getSmartPhoneCheckBox() {
		return smartPhoneCheckBox;
	}

	public WebElement getUpdateShoppingCartButton() {
		return updateShoppingCartButton;
	}

	public WebElement getContinueShoppingButton() {
		return continueShoppingButton;
	}

	public WebElement getTermsOfServiceCheckBox() {
		return termsOfServiceCheckBox;
	}

	public WebElement getCheckOutButton() {
		return checkOutButton;
	}

	public WebElement getSmartPhoneCartproduct() {
		return smartPhoneCartproduct;
	}
}
