package com.ecom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.base.TestBase;

public class ProductDescriptionPage extends TestBase{

	@FindBy(id = "option-label-size-143-item-169")
	WebElement selectLargeSizeJacket;
	
	@FindBy(id = "option-label-color-93-item-57")
	WebElement selectPurpleColorJacket;
	
	@FindBy(xpath = "//span[@class='swatch-attribute-selected-option' and contains(text(),'Purple')]")
	WebElement purpleColorJacketLabel;

	@FindBy(xpath = "//span[@class='swatch-attribute-selected-option' and contains(text(),'L')]")
	WebElement selectLargeSizeJacketLabel;
	
	@FindBy(id = "qty")
	WebElement enterQuantity;
	
	@FindBy(id = "product-addtocart-button")
	WebElement clickOnAddToCartBtn;
	
	@FindBy(xpath = "//div[@role='alert']")
	WebElement addToCartSuccessAlert;
	
	@FindBy(xpath = "//a[@class='action showcart']")
	WebElement clickOnCart;
	
	@FindBy(id = "top-cart-btn-checkout")
	WebElement proceedToCheckout;
	
	public ProductDescriptionPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyProductDescriptionPageTitle() {
		return driver.getTitle();
	}
	
	public void selectLargeJacket() {
		selectLargeSizeJacket.click();
	}
	
	public void selectPurpleColorJacket() {
		selectPurpleColorJacket.click();
	}
	
	public boolean verifyPurpleColorSelected() {
		return  purpleColorJacketLabel.isDisplayed();
	}
	
	
	public boolean verifyLargeJacketSelected() {
		return  selectLargeSizeJacketLabel.isDisplayed();
	}
	
	public void enterJacketQualtity(String Qtynum) {
		enterQuantity.clear();
		enterQuantity.sendKeys(Qtynum);
	}

	public void clickOnAddToCart() {
		clickOnAddToCartBtn.click();
	}
	
	public String verifyProductAddedSuccessfully() {
		return addToCartSuccessAlert.getText();
	}
	
	public void clickOnCart() {
		clickOnCart.click();
	}
	
	public CheckoutPage clickOnCheckout() {
		proceedToCheckout.click();
		return new CheckoutPage();
	}
	
	
	
	
	
	
	



}
