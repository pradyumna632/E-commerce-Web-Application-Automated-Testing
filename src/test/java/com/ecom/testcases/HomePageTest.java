package com.ecom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.base.TestBase;
import com.ecom.pages.HomePage;
import com.ecom.pages.JacketsPage;
import com.ecom.pages.SignInPage;

public class HomePageTest extends TestBase{

	SignInPage signInPage;
	HomePage homePage;
	JacketsPage jacketsPage;
	
	public HomePageTest() {
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
		homePage = signInPage.login(props.getProperty("email"), props.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Home Page","Home Page Title Not Matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
//		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void clickOnMensJacketsNavbarTest(){
//		testUtil.switchToFrame();
		jacketsPage = homePage.clickOnMenJackets();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
