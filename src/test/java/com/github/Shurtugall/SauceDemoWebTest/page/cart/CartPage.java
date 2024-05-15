package com.github.Shurtugall.SauceDemoWebTest.page.cart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.base.BasePage;

public class CartPage extends BasePage{

	public CartPage(RemoteWebDriver driver) {
		super(driver);
	}
	
	public WebElement titleYourCart() {
		return driver.findElement(By.className("title"));
	}
	
	public WebElement labelTitleQTY() {
		return driver.findElement(By.className("cart_quantity_label"));
	}
	
	public WebElement labelTitleDescription() {
		return driver.findElement(By.className("cart_desc_label"));
	}
	
	// ---- Products ----
	
	public List<WebElement> listOfProducts() {
		return driver.findElements(By.className("cart_item"));
	}
	
	public WebElement qtyOfProductOnIndex(int index) {
		return listOfProducts().get(index).findElement(By.className("cart_quantity"));
	}
	
	public WebElement titleOfProductOnIndex(int index) {
		return listOfProducts().get(index).findElement(By.className("inventory_item_name"));
	}
	
	public WebElement txtOfProductOnIndex(int index) {
		return listOfProducts().get(index).findElement(By.className("inventory_item_desc"));
	}
	
	public WebElement valueOfProductOnIndex(int index) {
		return listOfProducts().get(index).findElement(By.className("inventory_item_price"));
	}
	
	public WebElement btnRemoveOfProductOnIndex(int index) {
		return listOfProducts().get(index).findElement(By.className("btn_secondary"));
	}
	
	// ---- Buttons Continue and Checkout
	
	public WebElement btnContinueShopping() {
		return driver.findElement(By.id("continue-shopping"));
	}
	
	public WebElement btnCheckout() {
		return driver.findElement(By.id("checkout"));
	}
}
