package com.github.Shurtugall.SauceDemoWebTest.page.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.base.BasePage;

public class CheckoutCompletePage extends BasePage{

	public CheckoutCompletePage(RemoteWebDriver driver) {
		super(driver);
	}
	
	public WebElement titleOverview() {
		return driver.findElement(By.className("title"));
	}

	public WebElement imgSucess() {
		return driver.findElement(By.xpath("//div[@id='checkout_complete_container']/img"));
	}
	
	public WebElement titleThankYou() {
		return driver.findElement(By.xpath("//div[@id='checkout_complete_container']/h2"));
	}
	
	public WebElement txtOrderDispatched() {
		return driver.findElement(By.xpath("//div[@id='checkout_complete_container']/div"));
	}
	
	public WebElement btnBackHome() {
		return driver.findElement(By.id("back-to-products"));
	}
	
}
