package com.ecom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.base.TestBase;
import com.ecom.pages.HomePage;
import com.ecom.pages.JacketsPage;
import com.ecom.pages.ProductDescriptionPage;
import com.ecom.pages.SignInPage;

public class JacketsPageTest extends TestBase{
	
	SignInPage signInPage;
	HomePage homePage;
	JacketsPage jacketsPage;
	ProductDescriptionPage productDescriptionPage;
	
	
	public JacketsPageTest() {
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
		
	}
	
	@Test(priority=1)
	public void verifyJacketsPageTitleTest(){
		String jacketsPageTitle = jacketsPage.verifyJacketsPageTitle();
		Assert.assertEquals(jacketsPageTitle, "Jackets - Tops - Men","Jackets Page Title Not Matched");
	}
	
	@Test(priority=2)
	public void verifyJacketsProductNameTest(){
		String jacketsProductName = jacketsPage.verifyProductName();
		Assert.assertEquals(jacketsProductName, "Jupiter All-Weather Trainer");
	}
	
	@Test(priority=3)
	public void clickOnProductTest(){
		productDescriptionPage = jacketsPage.clickOnProduct();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
