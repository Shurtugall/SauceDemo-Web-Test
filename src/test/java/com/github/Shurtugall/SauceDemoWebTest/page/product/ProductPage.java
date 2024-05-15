package com.github.Shurtugall.SauceDemoWebTest.page.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.base.BasePage;

public class ProductPage extends BasePage{

	public ProductPage(RemoteWebDriver driver) {
		super(driver);
	}
	
	public WebElement btnBackToProducts() {
		return driver.findElement(By.id("back-to-products"));
	}
	
	public WebElement imgOfProduct() {
		return driver.findElement(By.xpath("//div[@class='inventory_details_img_container']/img"));
	}
	
	public WebElement titleOfProduct() {
		return driver.findElement(By.className("inventory_details_name"));
	}
	
	public WebElement txtOfProduct() {
		return driver.findElement(By.className("inventory_details_desc"));
	}
	
	public WebElement priceOfProduct() {
		return driver.findElement(By.className("inventory_details_price"));
	}
	
	public WebElement btnAddToCart() {
		return driver.findElement(By.id("add-to-cart"));
	}
	
	public WebElement btnRemoveFromCart() {
		return driver.findElement(By.id("remove"));
	}
}
