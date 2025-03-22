package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage 
{
	//Declaration
	@FindBy(linkText = "Register") private WebElement registerLink;
	@FindBy(linkText = "Log in") private WebElement loginLink;
	@FindBy(xpath = "//span[text()='Shopping cart']") private WebElement shoppingCartLink;
	@FindBy(xpath = "//span[text()='Wishlist']") private WebElement wishlistLink;
	@FindBy(partialLinkText = "BOOKS") private WebElement booksLink;
	@FindBy(partialLinkText = "COMPUTERS") private WebElement computersLink;
	@FindBy(partialLinkText = "ELECTRONICS") private WebElement electronicsLink;
	@FindBy(partialLinkText = "JEWELRY") private WebElement jewelryLink;
	@FindBy(partialLinkText = "GIFTS CARDS") private WebElement giftsCardsLink;
	@FindBy(partialLinkText = "DIGITAL DOWNLOADS") private WebElement digitalDownloadsLink;
	@FindBy(partialLinkText = "APPAREL & SHOES") private WebElement apparelAndShoesLink;
	@FindBy(linkText = "Log out") private WebElement logOutLink;
	@FindBy(xpath = "//span[text()='Shopping cart']") private WebElement addToCartButton;

	//Initialization
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getAddToCartButton() {
		return addToCartButton;
	}
	public WebElement getRegisterLink() {
		return registerLink;
	}
	public WebElement getLogOutLink() {
		return logOutLink;
	}
	public WebElement getLoginLink() {
		return loginLink;
	}
	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}
	public WebElement getWishlistLink() {
		return wishlistLink;
	}
	public WebElement getBooksLink() {
		return booksLink;
	}
	public WebElement getComputersLink() {
		return computersLink;
	}
	public WebElement getElectronicsLink() {
		return electronicsLink;
	}
	public WebElement getJewelryLink() {
		return jewelryLink;
	}
	public WebElement getGiftsCardsLink() {
		return giftsCardsLink;
	}
	public WebElement getDigitalDownloadsLink() {
		return digitalDownloadsLink;
	}
	public WebElement getApparelAndShoesLink() {
		return apparelAndShoesLink;
	}
	public void logout() {
		getLogOutLink().click();
	}
}
