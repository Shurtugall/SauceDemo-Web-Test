package com.github.Shurtugall.SauceDemoWebTest.page.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.base.BasePage;

public class InventoryHomePage extends BasePage{

	public InventoryHomePage(RemoteWebDriver driver) {
		super(driver);
	}
	
	public WebElement titleSectionProducts() {
		return driver.findElement(By.className("title"));
	}
	
	public WebElement txtActiveFilterOption() {
		return driver.findElement(By.className("active_option"));
	}
	
	/**
	 * @param value az -> Name (A to Z)
	 * @param value za -> Name (Z to Z)
	 * @param value lohi -> Price (low to high)
	 * @param value hilo -> Price (high to low)
	 */
	public WebElement selectFilterOptionWithValue(String value) {
		return driver.findElement(By.xpath("//select[@class='product_sort_container']/option[@value='"+value+"']"));
	}
	
	// ---- List of products ----
	
	/**
	 * @param id = 4 -> Backpack
	 * @param id = 0 -> Bike Light
	 * @param id = 1 -> Bolt Tshirt
	 * @param id = 5 -> Fleece Jacket
	 * @param id = 2 -> Onesie
	 * @param id = 3 -> Test.allTheThings() T-Shirt (Red)
	 */
	public WebElement imgOfProductWithId(String id) {
		return driver.findElement(By.xpath("//a[@id='item_"+id+"_img_link']/*[1]"));
	}
	
	/**
	 * @param id = 4 -> Backpack
	 * @param id = 0 -> Bike Light
	 * @param id = 1 -> Bolt Tshirt
	 * @param id = 5 -> Fleece Jacket
	 * @param id = 2 -> Onesie
	 * @param id = 3 -> Test.allTheThings() T-Shirt (Red)
	 */
	public WebElement titleOfProductWithId(String id) {
		return driver.findElement(By.id("item_"+id+"_title_link"));
	}
	
	/**
	 * @param id = 4 -> Backpack
	 * @param id = 0 -> Bike Light
	 * @param id = 1 -> Bolt Tshirt
	 * @param id = 5 -> Fleece Jacket
	 * @param id = 2 -> Onesie
	 * @param id = 3 -> Test.allTheThings() T-Shirt (Red)
	 */
	public WebElement txtOfProductWithId(String id) {
		return driver.findElement(By.xpath("//a[@id='item_"+id+"_title_link']/following-sibling::div"));
	}
	
	/**
	 * @param id = sauce-labs-backpack -> Backpack
	 * @param id = sauce-labs-bike-light -> Bike Light
	 * @param id = sauce-labs-bolt-t-shirt -> Bolt Tshirt
	 * @param id = sauce-labs-fleece-jacket -> Fleece Jacket
	 * @param id = sauce-labs-onesie -> Onesie
	 * @param id = test.allthethings()-t-shirt-(red) -> Test.allTheThings() T-Shirt (Red)
	 */
	public WebElement valueOfProductWithId(String id) {
		return driver.findElement(By.xpath("//button[@id='add-to-cart-"+id+"']/preceding-sibling::div"));
	}
	
	/**
	 * @param id = sauce-labs-backpack -> Backpack
	 * @param id = sauce-labs-bike-light -> Bike Light
	 * @param id = sauce-labs-bolt-t-shirt -> Bolt Tshirt
	 * @param id = sauce-labs-fleece-jacket -> Fleece Jacket
	 * @param id = sauce-labs-onesie -> Onesie
	 * @param id = test.allthethings()-t-shirt-(red) -> Test.allTheThings() T-Shirt (Red)
	 */
	public WebElement btnAddToCartOfProductWithId(String id) {
		return driver.findElement(By.id("add-to-cart-"+id));
	}
	
	/**
	 * @param id = sauce-labs-backpack -> Backpack
	 * @param id = sauce-labs-bike-light -> Bike Light
	 * @param id = sauce-labs-bolt-t-shirt -> Bolt Tshirt
	 * @param id = sauce-labs-fleece-jacket -> Fleece Jacket
	 * @param id = sauce-labs-onesie -> Onesie
	 * @param id = test.allthethings()-t-shirt-(red) -> Test.allTheThings() T-Shirt (Red)
	 */
	public WebElement btnRemoveFromCartProductWithId(String id) {
		return driver.findElement(By.id("remove-"+id));
	}
	
	// ---- Getting title of elements by their location ----
	
	public WebElement titleFirstProductDisplayedOnTheList() {
		return driver.findElement(By.xpath("//div[@class='inventory_list']/div/div[2]/div/a/div"));
	}
	
	public WebElement titleSecondProductDisplayedOnTheList() {
		return driver.findElement(By.xpath("//div[@class='inventory_list']/div[2]/div[2]/div/a/div"));
	}
	
	public WebElement titleThirdProductDisplayedOnTheList() {
		return driver.findElement(By.xpath("//div[@class='inventory_list']/div[3]/div[2]/div/a/div"));
	}
	
	public WebElement titleFourthProductDisplayedOnTheList() {
		return driver.findElement(By.xpath("//div[@class='inventory_list']/div[4]/div[2]/div/a/div"));
	}
	
	public WebElement titleFifthProductDisplayedOnTheList() {
		return driver.findElement(By.xpath("//div[@class='inventory_list']/div[5]/div[2]/div/a/div"));
	}
	
	public WebElement titleSixthProductDisplayedOnTheList() {
		return driver.findElement(By.xpath("//div[@class='inventory_list']/div[6]/div[2]/div/a/div"));
	}
	
	// ---- Getting price of elements by their location ----
	
	public List<WebElement> listOfProductsDisplayed() {
		return driver.findElements(By.xpath("//div[@class='inventory_item']"));
	}
	
	public Double valueProductDisplayedOnTheListAtPosition(int positionAtList) {
		return Double.parseDouble(listOfProductsDisplayed().get(positionAtList).findElement(By.xpath("//div[@class='inventory_item_price']")).getText().replace("$", ""));
	}
	
}
