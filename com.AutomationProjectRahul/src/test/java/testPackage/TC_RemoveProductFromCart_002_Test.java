package testPackage;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseTest;
import pomPackage.ElectronicsPage;
import pomPackage.ShoppingCartPage;
import pomPackage.WelcomePage;

public class TC_RemoveProductFromCart_002_Test extends BaseTest {

    @Test
    public void addToCartMethod() {
        // Initialize WelcomePage object
        WelcomePage wp = new WelcomePage(driver);

        // Navigate to Electronics section
        wp.getElectronicsLink().click();
        
        // Initialize ElectronicsPage object and navigate to Cell Phones
        ElectronicsPage ep = new ElectronicsPage(driver);
        ep.getCellPhoneLink().click();
        
        // Add Smartphone to cart
        ep.getSmartPhoneAddToCartLink().click();
        
        // Navigate to Shopping Cart
        wp.getShoppingCartLink().click();
        
        // Initialize ShoppingCartPage object
        ShoppingCartPage sp = new ShoppingCartPage(driver);
        
        // Assertion to verify product is added
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(sp.getSmartPhoneCartproduct().isDisplayed(), "Product is not added to cart");
        
        // Remove product from cart
        sp.getSmartPhoneCheckBox().click();
        sp.getUpdateShoppingCartButton().click();
        
        // Assertion to verify product is removed
        sa.assertFalse(sp.getSmartPhoneCartproduct().isDisplayed(), "Product is not removed from cart");
        
        // Assert all to report failures if any
        sa.assertAll();
        {
        	Reporter.log("Test Case Executed Successfully", true);
        }
    }
}
