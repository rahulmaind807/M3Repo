package testPackage;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseTest;
import pomPackage.ElectronicsPage;
import pomPackage.ShoppingCartPage;
import pomPackage.WelcomePage;

public class TC_AddToCart_001_Test extends BaseTest {

    @Test
    public void addToCartMethod() throws IOException {
    	
        WelcomePage wp = new WelcomePage(driver);
        wp.getElectronicsLink().click();
        
        ElectronicsPage ep = new ElectronicsPage(driver);
        ep.getCellPhoneLink().click();
        ep.getSmartPhoneAddToCartLink().click();
        
        wp.getShoppingCartLink().click();
        
        ShoppingCartPage sp = new ShoppingCartPage(driver);
        
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(sp.getSmartPhoneCartproduct().isDisplayed(), "Product is not added to cart");
        sa.assertAll();
    }
}
