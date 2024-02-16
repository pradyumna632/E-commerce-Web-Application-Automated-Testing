package com.ecom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.base.TestBase;
import com.ecom.pages.HomePage;
import com.ecom.pages.SignInPage;

public class SignInPageTest extends TestBase{

	SignInPage signInPage;
	HomePage homePage;
	
	public SignInPageTest() {
		//call super class constructor 
		// because we want to load properties file to get URL
		// if we don't do it it will give nullPointerException
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		// Launch the browser
		initialization();
		// Create object of LoginPage Class to access it's methods
		signInPage = new SignInPage();
		
	}
	
	@Test(priority = 1)
	public void signInTitleTest() {
		String title = signInPage.validateSignInPageTitle();
		Assert.assertEquals(title, "Customer Login", "Title Not Matched");
	}
	
	@Test(priority = 2)
	public void lumaTestLogoTest() {
		boolean flag = signInPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() {
		// we have to return it's returning homePage class so you have to store in home class reference
		homePage = signInPage.login(props.getProperty("email"), props.getProperty("password"));
	
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
