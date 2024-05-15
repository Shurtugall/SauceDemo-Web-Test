package com.github.Shurtugall.SauceDemoWebTest.page.checkout;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.base.BasePage;

public class CheckoutOverviewPage extends BasePage{

	public CheckoutOverviewPage(RemoteWebDriver driver) {
		super(driver);
	}
	
	public WebElement titleOverview() {
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
	
	// ---- Payment information ----
	
	public WebElement titlePaymentInformation() {
		return driver.findElement(By.xpath("//div[@class='summary_info']/div[text()='Payment Information:']"));
	}
	
	public WebElement txtPaymentInformation() {
		return driver.findElement(By.xpath("//div[@class='summary_info']/div[2]"));
	}
	
	// ---- Shipping information ----
	
	public WebElement titleShippingInformation() {
		return driver.findElement(By.xpath("//div[@class='summary_info']/div[text()='Shipping Information:']"));
	}
	
	public WebElement txtShippingInformation() {
		return driver.findElement(By.xpath("//div[@class='summary_info']/div[4]"));
	}
	
	// ---- Price total ----
	
	public WebElement titlePriceTotal() {
		return driver.findElement(By.xpath("//div[@class='summary_info']/div[text()='Price Total']"));
	}
	
	public WebElement txtSumItemTotal() {
		return driver.findElement(By.className("summary_subtotal_label"));
	}
	
	public WebElement txtSumTax() {
		return driver.findElement(By.className("summary_tax_label"));
	}
	
	public WebElement txtSumTotalValue() {
		return driver.findElement(By.className("summary_total_label"));
	}
	
	// ---- Button ----
	
	public WebElement btnCancel() {
		return driver.findElement(By.id("cancel"));
	}
	
	public WebElement btnFinish() {
		return driver.findElement(By.id("finish"));
	}
	
}
