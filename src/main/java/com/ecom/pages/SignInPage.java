package com.ecom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.base.TestBase;

public class SignInPage extends TestBase{

	//PageFactory - Object Repository
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id ="pass")
	WebElement password;
	
	@FindBy(xpath = "//a[contains(@class,'logo')]//img[1]")
	WebElement storeLogo;
	
	@FindBy(id = "send2")
	WebElement signInBtn;
	
	//The WebElements from Page Factory/object is Initialize to driver, and this is pointing to current class object
	public SignInPage() {
		PageFactory.initElements(driver, this);
		// PageFactory.initElements(driver, LoginPage.class); // Or we can write like this.
		
	}
	
	// Actions on Login Pages
	public String validateSignInPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return storeLogo.isDisplayed();
	}
	
	public HomePage login(String mail, String pass) {
		email.sendKeys(mail);
		password.sendKeys(pass);
		signInBtn.click();
		
		// after clicking on login the page is redirecting to Home page
		// so it should return HOME Page class object that why we write new HomePage()
		
		return new HomePage();
	}
	
	
	
}
