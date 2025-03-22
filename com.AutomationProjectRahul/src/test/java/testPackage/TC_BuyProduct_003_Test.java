package testPackage;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;
import pomPackage.CheckoutPage;
import pomPackage.ElectronicsPage;
import pomPackage.ShoppingCartPage;
import pomPackage.WelcomePage;

@Listeners(genericLibrary.MyListeners.class)
public class TC_BuyProduct_003_Test extends BaseTest {

    @Test
    public void buyProductMethod() throws IOException {
    	
        WelcomePage wp = new WelcomePage(driver);
        wp.getElectronicsLink().click();
        
        ElectronicsPage ep = new ElectronicsPage(driver);
        ep.getCellPhoneLink().click();
        ep.getSmartPhoneAddToCartLink().click();
        
        wp.getShoppingCartLink().click();
        
        ShoppingCartPage sp=new ShoppingCartPage(driver);
        sp.getSmartPhoneCheckBox().click();
        sp.getTermsOfServiceCheckBox().click();
        sp.getCheckOutButton().click();
        
        CheckoutPage cp=new CheckoutPage(driver);
        cp.buyProduct();
              
        
    }
}
