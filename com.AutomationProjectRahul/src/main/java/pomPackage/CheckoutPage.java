package pomPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import genericLibrary.Flib;
import genericLibrary.IAutoConstant;
import genericLibrary.SelectUtility;

public class CheckoutPage implements IAutoConstant {
	@FindBy(id="BillingNewAddress_CountryId")private WebElement countryDD;
	@FindBy(id = "BillingNewAddress_City") private WebElement cityTB;
	@FindBy(name = "BillingNewAddress.Address1") private WebElement address1TB;
	@FindBy(name = "BillingNewAddress.PhoneNumber") private WebElement phoneNumberTB;
	@FindBy(id = "BillingNewAddress.ZipPostalCode") private WebElement postalCodeTB;
	@FindBy(xpath = "//input[@onclick='Billing.save()']") private WebElement billingAddressContinueButton;
	@FindBy(xpath = "//input[@onclick='Shipping.save()']") private WebElement shippingAddressContinueButton;
	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']") private WebElement shippingMethodContinueButton;
	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']") private WebElement paymentMethodContinueButton;
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']") private WebElement paymentInfoContinueButton;
	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']") private WebElement confirmOrderContinueButton;
	@FindBy(xpath = "//strong[text()='Your order has been successfully processed!']") private WebElement orderProcessedText;
	@FindBy(id = "billing-address-select") private WebElement billingOldAddressDD;
	
	//Initialization
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getBillingOldAddressDD() {
		return billingOldAddressDD;
	}
	
	public WebElement getCityTB() {
		return cityTB;
	}
	public WebElement getAddress1TB() {
		return address1TB;
	}
	public WebElement getPhoneNumberTB() {
		return phoneNumberTB;
	}
	public WebElement getPostalCodeTB() {
		return postalCodeTB;
	}
	public WebElement getBillingAddressContinueButton() {
		return billingAddressContinueButton;
	}
	public WebElement getShippingAddressContinueButton() {
		return shippingAddressContinueButton;
	}
	public WebElement getShippingMethodContinueButton() {
		return shippingMethodContinueButton;
	}
	public WebElement getPaymentMethodContinueButton() {
		return paymentMethodContinueButton;
	}
	public WebElement getPaymentInfoContinueButton() {
		return paymentInfoContinueButton;
	}
	public WebElement getConfirmOrderContinueButton() {
		return confirmOrderContinueButton;
	}
	public WebElement getOrderProcessedText() {
		return orderProcessedText;
	}
	
	public WebElement getCountryDD() {
		return countryDD;
	}

	public void buyProduct() throws EncryptedDocumentException, IOException {
		SelectUtility su=new SelectUtility();
		
		try {
			if(billingOldAddressDD.isDisplayed()==true) {
				su.selectByVisibleTextMethod(billingOldAddressDD,"New Address");
			}
		}
		catch (Exception e){
			su.selectByVisibleTextMethod(countryDD,"India");
		}
		su.selectByVisibleTextMethod(countryDD,"India");
		
		Flib flib=new Flib();
		int randomNumber = flib.randomNumber();
		String city=flib.readExcelStringData(EXCEL_PATH_MAIN,"buyProductDetails",1, 0);
		String add1=flib.readExcelStringData(EXCEL_PATH_MAIN,"buyProductDetails",1, 1);
		long pin=flib.readExcelNumberData(EXCEL_PATH_MAIN,"buyProductDetails", 1, 2);
		long phone=flib.readExcelNumberData(EXCEL_PATH_MAIN,"buyProductDetails", 1, 3);
		
		//String pin=flib.readExcelData(EXCEL_PATH_MAIN,"buyProductDetails", 2, 2);
		//String phoneNumber1=flib.readExcelData(EXCEL_PATH_MAIN,"buyProductDetails", 2, 3);
		String phoneNumber = phone+""+randomNumber;
		
		cityTB.sendKeys(city);
		address1TB.sendKeys(add1);
		postalCodeTB.sendKeys(String.valueOf(pin));
		phoneNumberTB.sendKeys(String.valueOf(phoneNumber));
		billingAddressContinueButton.click();
		
		shippingAddressContinueButton.click();
		shippingMethodContinueButton.click();
		paymentMethodContinueButton.click();
		paymentInfoContinueButton.click();
		confirmOrderContinueButton.click();
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(orderProcessedText.isDisplayed(),true,"Order is not placed");
		sa.assertAll();
	}
	
}