package com.github.Shurtugall.SauceDemoWebTest.task.home;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.home.InventoryHomePage;
import com.github.Shurtugall.SauceDemoWebTest.page.product.ProductPage;
import com.github.Shurtugall.SauceDemoWebTest.task.base.BaseTask;

public class InventoryHomeTask extends BaseTask{

	private InventoryHomePage inventoryHomePage;
	private ProductPage productPage;
	
	public InventoryHomeTask(RemoteWebDriver driver) {
		super(driver);
		inventoryHomePage = new InventoryHomePage(driver);
		productPage = new ProductPage(driver);
	}
	
	public void clickOnProduct(String id) {
		inventoryHomePage.titleOfProductWithId(id).click();
		waitForElement(productPage.titleOfProduct());
	}
	
	/**
	 * @param value az -> Name (A to Z)
	 * @param value za -> Name (Z to Z)
	 * @param value lohi -> Price (low to high)
	 * @param value hilo -> Price (high to low)
	 */
	public void selectFilterOptionWithValue(String value) {
		inventoryHomePage.selectFilterOptionWithValue(value).click();
	}
	
	/**
	 * @param id = sauce-labs-backpack -> Backpack
	 * @param id = sauce-labs-bike-light -> Bike Light
	 * @param id = sauce-labs-bolt-t-shirt -> Bolt Tshirt
	 * @param id = sauce-labs-fleece-jacket -> Fleece Jacket
	 * @param id = sauce-labs-onesie -> Onesie
	 * @param id = test.allthethings()-t-shirt-(red) -> Test.allTheThings() T-Shirt (Red)
	 */
	public void addToCardTheProduct(String id) {
		inventoryHomePage.btnAddToCartOfProductWithId(id).click();
	}
	
	/**
	 * @param id = sauce-labs-backpack -> Backpack
	 * @param id = sauce-labs-bike-light -> Bike Light
	 * @param id = sauce-labs-bolt-t-shirt -> Bolt Tshirt
	 * @param id = sauce-labs-fleece-jacket -> Fleece Jacket
	 * @param id = sauce-labs-onesie -> Onesie
	 * @param id = test.allthethings()-t-shirt-(red) -> Test.allTheThings() T-Shirt (Red)
	 */
	public void removeProductFromCart(String id) {
		inventoryHomePage.btnRemoveFromCartProductWithId(id).click();
	}

}
