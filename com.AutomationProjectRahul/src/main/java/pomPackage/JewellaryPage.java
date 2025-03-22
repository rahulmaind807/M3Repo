package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class JewellaryPage {

	@FindBy(xpath = "//a[contains(text(),'Create')]") private WebElement selectedJewellaery;
	@FindBy(xpath = "//a[contains(text(),'Create')]/../..//input[@value='Add to cart']") 
	private WebElement addToCartButtonOnJewellaeryPage;
	
	public WebElement getSelectedJewellaery() {
		return selectedJewellaery;
	}
	public WebElement getAddToCartButtonOnJewellaeryPage() {
		return addToCartButtonOnJewellaeryPage;
	}

	
}
