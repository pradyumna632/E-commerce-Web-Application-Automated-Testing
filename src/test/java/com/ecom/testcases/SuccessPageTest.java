package com.ecom.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ecom.base.TestBase;
import com.ecom.pages.CheckoutPage;
import com.ecom.pages.HomePage;
import com.ecom.pages.JacketsPage;
import com.ecom.pages.ProductDescriptionPage;
import com.ecom.pages.SignInPage;
import com.ecom.pages.SuccessPage;

public class SuccessPageTest extends TestBase{
	
	SignInPage signInPage;
	HomePage homePage;
	JacketsPage jacketsPage;
	ProductDescriptionPage productDescriptionPage;
	CheckoutPage checkOutPage;
	SuccessPage successPage;
	
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
		successPage = new SuccessPage();
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
