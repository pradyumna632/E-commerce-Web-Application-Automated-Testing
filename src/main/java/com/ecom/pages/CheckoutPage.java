package com.ecom.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.base.TestBase;

public class CheckoutPage extends TestBase{
	
	@FindBy(xpath = "//div[@class='new-address-popup']//button/span")
	WebElement addNewAddress;
	
	@FindBy(xpath = "//div[@class='primary']//span[contains(text(),'Place Order')]")
	WebElement nextBtn;
	
	@FindBy(xpath = "//div[@class='step-title' and  contains(text(),'Shipping Address')]")
	WebElement shippingAddressLabel;
	
	@FindBy(xpath = "//div[@class='step-title' and  contains(text(),'Payment Method')]")
	WebElement paymentMethodLabel;
	
	@FindBy(xpath = "//span[normalize-space()='Place Order']")
	WebElement placeOrderBtn;
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNextBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		nextBtn.click();
	}
	
	public String verifyCheckoutPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyShippingLabel() {
		return shippingAddressLabel.isDisplayed();
	}
	
	public boolean verifyPaymentMethodLabel() {
		clickOnNextBtn();
		return paymentMethodLabel.isDisplayed();
	}
	
	public SuccessPage placeOrder() {
		placeOrderBtn.click();
		return new SuccessPage();	
	}
	
}
