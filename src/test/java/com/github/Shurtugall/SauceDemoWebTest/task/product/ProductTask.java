package com.github.Shurtugall.SauceDemoWebTest.task.product;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.home.InventoryHomePage;
import com.github.Shurtugall.SauceDemoWebTest.page.product.ProductPage;
import com.github.Shurtugall.SauceDemoWebTest.task.base.BaseTask;

public class ProductTask extends BaseTask{

	private ProductPage productPage;
	private InventoryHomePage inventoryHomePage;
	
	public ProductTask(RemoteWebDriver driver) {
		super(driver);
		productPage = new ProductPage(driver);
		inventoryHomePage = new InventoryHomePage(driver);
	}
	
	public void returnToInventoryHomePage() {
		productPage.btnBackToProducts().click();
		waitForElement(inventoryHomePage.titleSectionProducts());
	}
	
	public void addToCardTheProduct() {
		productPage.btnAddToCart().click();
	}
	
	public void removeProductFromCart() {
		productPage.btnRemoveFromCart().click();
	}
	

}
