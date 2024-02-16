package com.ecom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.base.TestBase;
import com.ecom.pages.CheckoutPage;
import com.ecom.pages.HomePage;
import com.ecom.pages.JacketsPage;
import com.ecom.pages.ProductDescriptionPage;
import com.ecom.pages.SignInPage;
import com.ecom.pages.SuccessPage;

public class CheckoutPageTest extends TestBase{
	
	SignInPage signInPage;
	HomePage homePage;
	JacketsPage jacketsPage;
	ProductDescriptionPage productDescriptionPage;
	CheckoutPage checkOutPage;
	
	public CheckoutPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		// Launch the browser
		initialization();
		// Create object of LoginPage Class to access it's methods
		signInPage = new SignInPage();
		homePage = signInPage.login(props.getProperty("email"), props.getProperty("password"));
		homePage = new HomePage();
		driver.manage().deleteAllCookies();
		jacketsPage = homePage.clickOnMenJackets();
		productDescriptionPage = new ProductDescriptionPage();
		productDescriptionPage = jacketsPage.clickOnProduct();
		checkOutPage = new CheckoutPage();	
		productDescriptionPage.selectLargeJacket();
		productDescriptionPage.selectPurpleColorJacket();
		productDescriptionPage.enterJacketQualtity("2");
		productDescriptionPage.clickOnAddToCart();
		productDescriptionPage.clickOnCart();
		checkOutPage = productDescriptionPage.clickOnCheckout();
	}
	
	@Test(priority=1)
	public void verifyCheckoutPageTitleTest(){
		String checkoutPageTitle = productDescriptionPage.verifyProductDescriptionPageTitle();
		Assert.assertEquals(checkoutPageTitle, "Checkout","Checkout Page Title Not Matched");
	}
	
	@Test(priority = 2)
	public void verifyShippingLabelTest() {
		checkOutPage.verifyShippingLabel();
		boolean flag = checkOutPage.verifyShippingLabel();
		Assert.assertTrue(flag, "Shipping Label isn't Displayed");
	}
	
	@Test(priority = 3)
	public void verifyPaymentMethodLabelTest() {
		checkOutPage.verifyPaymentMethodLabel();
		boolean flag = checkOutPage.verifyPaymentMethodLabel();
		Assert.assertTrue(flag, "Payment Method Label isn't Displayed");
	}

	
	@Test(priority = 4)
	public SuccessPage placeOrderTest() {
		checkOutPage.clickOnNextBtn();
		checkOutPage.placeOrder();
		return new SuccessPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
