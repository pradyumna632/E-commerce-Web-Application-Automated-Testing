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

public class ProdutDescriptionTest extends TestBase{
	
	SignInPage signInPage;
	HomePage homePage;
	JacketsPage jacketsPage;
	ProductDescriptionPage productDescriptionPage;
	
	
	public ProdutDescriptionTest() {
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
		jacketsPage = homePage.clickOnMenJackets();
		productDescriptionPage = new ProductDescriptionPage();
		productDescriptionPage =jacketsPage.clickOnProduct();
		
		
	}
	
	@Test(priority=1)
	public void verifyProductDescriptionPageTitleTest(){
		String productDescriptionPageTitle = productDescriptionPage.verifyProductDescriptionPageTitle();
		Assert.assertEquals(productDescriptionPageTitle, "Jupiter All-Weather Trainer","Product Description Page Title Not Matched");
	}
	
	@Test(priority = 2)
	public void verifyLargeJacketSelectedTest() {
		productDescriptionPage.selectLargeJacket();
		boolean flag = productDescriptionPage.verifyLargeJacketSelected();
		Assert.assertTrue(flag, "Large Jacket isn't selected");
	}
	
	@Test(priority = 3)
	public void verifyPurpleColorSelectedTest() {
		productDescriptionPage.selectPurpleColorJacket();
		boolean flag = productDescriptionPage.verifyPurpleColorSelected();
		Assert.assertTrue(flag, "Purple color Jacket isn't selected");
	}
	
	@Test(priority = 4)
	public void enterJacketQualtityTest() {
		productDescriptionPage.enterJacketQualtity("2");
	}

	@Test(priority = 5)
	public void clickOnAddToCartTest() {
		productDescriptionPage.clickOnAddToCart();
	}
	
	@Test(priority = 6)
	public void verifyProductAddedSuccessfullyTest() {
		productDescriptionPage.selectLargeJacket();
		productDescriptionPage.selectPurpleColorJacket();
		productDescriptionPage.enterJacketQualtity("2");
		productDescriptionPage.clickOnAddToCart();
		String successMsg = productDescriptionPage.verifyProductAddedSuccessfully();
		Assert.assertEquals(successMsg, "You added Jupiter All-Weather Trainer to your shopping cart.");
	}
	
	@Test(priority = 6)
	public void clickOnCartTest() {
		productDescriptionPage.selectLargeJacket();
		productDescriptionPage.selectPurpleColorJacket();
		productDescriptionPage.enterJacketQualtity("2");
		productDescriptionPage.clickOnAddToCart();
		productDescriptionPage.clickOnCart();
	}
	
	@Test(priority = 7)
	public void clickOnCheckoutTest() {
		productDescriptionPage.selectLargeJacket();
		productDescriptionPage.selectPurpleColorJacket();
		productDescriptionPage.enterJacketQualtity("2");
		productDescriptionPage.clickOnAddToCart();
		productDescriptionPage.clickOnCart();
		productDescriptionPage.clickOnCheckout();
//		return new CheckoutPage();
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
