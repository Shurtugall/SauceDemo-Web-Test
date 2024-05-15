package com.github.Shurtugall.SauceDemoWebTest.page.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.base.BasePage;

public class CheckoutInformationPage extends BasePage{

	public CheckoutInformationPage(RemoteWebDriver driver) {
		super(driver);
	}
	
	public WebElement titleYourInformation() {
		return driver.findElement(By.className("title"));
	}
	
	//---- First name ----
	
	public WebElement inputFirstName() {
		return driver.findElement(By.id("first-name"));
	}
	
	public WebElement svgErrorInputFirstName() {
		return driver.findElement(By.xpath("//input[@id='first-name']/following-sibling::*"));
	}
	
	//---- Last name ----
	
	public WebElement inputLastName() {
		return driver.findElement(By.id("last-name"));
	}
	
	public WebElement svgErrorInputLastName() {
		return driver.findElement(By.xpath("//input[@id='last-name']/following-sibling::*"));
	}
	
	//---- Postal code ----
	
	public WebElement inputPostalCode() {
		return driver.findElement(By.id("postal-code"));
	}
	
	public WebElement svgErrorInputPostalCode() {
		return driver.findElement(By.xpath("//input[@id='postal-code']/following-sibling::*"));
	}
	
	// ---- Error message box ----
	
	public WebElement txtErrorMessage() {
		return driver.findElement(By.xpath("//button[@class='error-button']/.."));
	}
	
	public WebElement btnCloseErrorMessage() {
		return driver.findElement(By.xpath("//button[@class='error-button']"));
	}
	
	// ---- Buttons ----
	
	public WebElement btnCancel() {
		return driver.findElement(By.id("cancel"));
	}

	public WebElement btnContinue() {
		return driver.findElement(By.id("continue"));
	}
	
}
