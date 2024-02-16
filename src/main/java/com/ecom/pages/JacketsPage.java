package com.ecom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.base.TestBase;

public class JacketsPage extends TestBase{

	
	@FindBy(xpath = "//a[@class='product-item-link' and contains(text(),'Jupiter All-Weather Trainer')]")
	WebElement productName;
		
	public JacketsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyJacketsPageTitle() {
		return driver.getTitle();
	}
	
	public String verifyProductName() {
		return productName.getText();
	}
	
	public ProductDescriptionPage clickOnProduct() {
		productName.click();
		return new ProductDescriptionPage();
	}
	
}
