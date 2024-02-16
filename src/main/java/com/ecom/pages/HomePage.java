package com.ecom.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//div[@class='panel header']//span[contains(text(),'Welcome, Julie Chan!')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[@id='ui-id-5']//span[contains(text(),'Men')]")
	WebElement navbarMenuMen;
	
	@FindBy(xpath = "//a[@id='ui-id-17']//span[contains(text(),'Tops')]")
	WebElement navbarMenuTops;
	
	@FindBy(xpath = "//a[@id='ui-id-19']//span[contains(text(),'Jackets')]")
	WebElement navbarMenuTopsJackets;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public JacketsPage clickOnMenJackets() {
		
		Actions action = new Actions(driver);
		action.moveToElement(navbarMenuMen).build().perform();
		action.moveToElement(navbarMenuTops).build().perform();
		action.moveToElement(navbarMenuTopsJackets).click().build().perform();
		
		return new JacketsPage();
		
	}

}
