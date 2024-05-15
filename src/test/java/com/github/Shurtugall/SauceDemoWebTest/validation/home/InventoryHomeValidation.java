package com.github.Shurtugall.SauceDemoWebTest.validation.home;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.home.InventoryHomePage;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.home.PRODUCT_NUM_ID;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.home.PRODUCT_TXT_ID;
import com.github.Shurtugall.SauceDemoWebTest.validation.base.BaseValidation;
import com.github.Shurtugall.SauceDemoWebTest.validation.utils.PRODUCT_TITLE;

public class InventoryHomeValidation extends BaseValidation{

	private InventoryHomePage inventoryHomePage;
	
	public InventoryHomeValidation(RemoteWebDriver driver) {
		super(driver);
		inventoryHomePage = new InventoryHomePage(driver);
	}
	
	public void validateCurrentFilterOption(String option) {
		Assertions.assertEquals(option, inventoryHomePage.txtActiveFilterOption().getText());
	}
	
	public void validateStaticElementsOnTheScreen() {
		String currentFilterOption = "Name (A to Z)";
		Assertions.assertAll("Validate static page elements: ", 
				() -> Assertions.assertEquals("Products", inventoryHomePage.titleSectionProducts().getText()),
				() -> validateCurrentFilterOption(currentFilterOption),
				() -> Assertions.assertEquals("Name (A to Z)", inventoryHomePage.selectFilterOptionWithValue("az").getText()),
				() -> Assertions.assertEquals("Name (Z to A)", inventoryHomePage.selectFilterOptionWithValue("za").getText()),
				() -> Assertions.assertEquals("Price (low to high)", inventoryHomePage.selectFilterOptionWithValue("lohi").getText()),
				() -> Assertions.assertEquals("Price (high to low)", inventoryHomePage.selectFilterOptionWithValue("hilo").getText()));
	}
	
	public void validateOrderOfDisplayedProductsFromNameAtoZ() {
		Assertions.assertAll("Validate order of displayed products using filter A to Z: ", 
				() -> Assertions.assertEquals(PRODUCT_TITLE.BACKPACK.getProductTitle(), inventoryHomePage.titleFirstProductDisplayedOnTheList().getText()),
				() -> Assertions.assertEquals(PRODUCT_TITLE.BIKE_LIGHT.getProductTitle(), inventoryHomePage.titleSecondProductDisplayedOnTheList().getText()),
				() -> Assertions.assertEquals(PRODUCT_TITLE.BOLT_T_SHIRT.getProductTitle(), inventoryHomePage.titleThirdProductDisplayedOnTheList().getText()),
				() -> Assertions.assertEquals(PRODUCT_TITLE.FLEECE_JACKET.getProductTitle(), inventoryHomePage.titleFourthProductDisplayedOnTheList().getText()),
				() -> Assertions.assertEquals(PRODUCT_TITLE.ONESIE.getProductTitle(), inventoryHomePage.titleFifthProductDisplayedOnTheList().getText()),
				() -> Assertions.assertEquals(PRODUCT_TITLE.T_SHIRT_RED.getProductTitle(), inventoryHomePage.titleSixthProductDisplayedOnTheList().getText()));
	}
	
	public void validateOrderOfDisplayedProductsFromNameZtoA() {
		Assertions.assertAll("Validate order of displayed products using filter Z to A: ", 
				() -> Assertions.assertEquals(PRODUCT_TITLE.T_SHIRT_RED.getProductTitle(), inventoryHomePage.titleFirstProductDisplayedOnTheList().getText()),
				() -> Assertions.assertEquals(PRODUCT_TITLE.ONESIE.getProductTitle(), inventoryHomePage.titleSecondProductDisplayedOnTheList().getText()),
				() -> Assertions.assertEquals(PRODUCT_TITLE.FLEECE_JACKET.getProductTitle(), inventoryHomePage.titleThirdProductDisplayedOnTheList().getText()),
				() -> Assertions.assertEquals(PRODUCT_TITLE.BOLT_T_SHIRT.getProductTitle(), inventoryHomePage.titleFourthProductDisplayedOnTheList().getText()),
				() -> Assertions.assertEquals(PRODUCT_TITLE.BIKE_LIGHT.getProductTitle(), inventoryHomePage.titleFifthProductDisplayedOnTheList().getText()),
				() -> Assertions.assertEquals(PRODUCT_TITLE.BACKPACK.getProductTitle(), inventoryHomePage.titleSixthProductDisplayedOnTheList().getText()));
	}
	
	public void validateOrderOfDisplayedProductsFromPriceLowToHi() {
		for(int i = 0; i < inventoryHomePage.listOfProductsDisplayed().size() - 1; i++) {
			Assertions.assertTrue(inventoryHomePage.valueProductDisplayedOnTheListAtPosition(i) <= inventoryHomePage.valueProductDisplayedOnTheListAtPosition(i+1));
		}
	}
	
	public void validateOrderOfDisplayedProductsFromPriceHiToLow() {
		for(int i = 0; i < inventoryHomePage.listOfProductsDisplayed().size() - 1; i++) {
			Assertions.assertTrue(inventoryHomePage.valueProductDisplayedOnTheListAtPosition(i) >= inventoryHomePage.valueProductDisplayedOnTheListAtPosition(i+1));
		}
	}
	
	public void validateListOfProducts() {
		validadeBackpackProductData();
		validadeBikeLightProductData();
		validadeBoltTShirtProductData();
		validadeFleeceJacketProductData();
		validadeOnesieProductData();
		validadeTShirtRedProductData();
	}		
	
	public void validadeBackpackProductData() {
		Assertions.assertAll("Validate data of the element 'backpack': ", 
				() -> Assertions.assertTrue(inventoryHomePage.imgOfProductWithId(PRODUCT_NUM_ID.BACKPACK.getProductId()).isDisplayed()),
				() -> Assertions.assertEquals("Sauce Labs Backpack", inventoryHomePage.titleOfProductWithId(PRODUCT_NUM_ID.BACKPACK.getProductId()).getText()),
				() -> Assertions.assertEquals("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style "
						+ "with unequaled laptop and tablet protection.", inventoryHomePage.txtOfProductWithId(PRODUCT_NUM_ID.BACKPACK.getProductId()).getText()),
				() -> Assertions.assertEquals("$29.99", inventoryHomePage.valueOfProductWithId(PRODUCT_TXT_ID.BACKPACK.getProductId()).getText()),
				() -> Assertions.assertEquals("Add to cart", inventoryHomePage.btnAddToCartOfProductWithId(PRODUCT_TXT_ID.BACKPACK.getProductId()).getText()));
	}
	
	public void validadeBikeLightProductData() {
		Assertions.assertAll("Validate data of the element 'Bike Light': ", 
				() -> Assertions.assertTrue(inventoryHomePage.imgOfProductWithId(PRODUCT_NUM_ID.BIKE_LIGHT.getProductId()).isDisplayed()),
				() -> Assertions.assertEquals("Sauce Labs Bike Light", inventoryHomePage.titleOfProductWithId(PRODUCT_NUM_ID.BIKE_LIGHT.getProductId()).getText()),
				() -> Assertions.assertEquals("A red light isn't the desired state in testing but it sure helps when riding your bike at night. "
						+ "Water-resistant with 3 lighting modes, 1 AAA battery included.", inventoryHomePage.txtOfProductWithId(PRODUCT_NUM_ID.BIKE_LIGHT.getProductId()).getText()),
				() -> Assertions.assertEquals("$9.99", inventoryHomePage.valueOfProductWithId(PRODUCT_TXT_ID.BIKE_LIGHT.getProductId()).getText()),
				() -> Assertions.assertEquals("Add to cart", inventoryHomePage.btnAddToCartOfProductWithId(PRODUCT_TXT_ID.BIKE_LIGHT.getProductId()).getText()));
	}
	
	public void validadeBoltTShirtProductData() {
		Assertions.assertAll("Validate data of the element 'Bolt T-Shirt': ", 
				() -> Assertions.assertTrue(inventoryHomePage.imgOfProductWithId(PRODUCT_NUM_ID.BOLT_T_SHIRT.getProductId()).isDisplayed()),
				() -> Assertions.assertEquals("Sauce Labs Bolt T-Shirt", inventoryHomePage.titleOfProductWithId(PRODUCT_NUM_ID.BOLT_T_SHIRT.getProductId()).getText()),
				() -> Assertions.assertEquals("Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, "
						+ "100% ringspun combed cotton, heather gray with red bolt.", inventoryHomePage.txtOfProductWithId(PRODUCT_NUM_ID.BOLT_T_SHIRT.getProductId()).getText()),
				() -> Assertions.assertEquals("$15.99", inventoryHomePage.valueOfProductWithId(PRODUCT_TXT_ID.BOLT_T_SHIRT.getProductId()).getText()),
				() -> Assertions.assertEquals("Add to cart", inventoryHomePage.btnAddToCartOfProductWithId(PRODUCT_TXT_ID.BOLT_T_SHIRT.getProductId()).getText()));
	}
	
	public void validadeFleeceJacketProductData() {
		Assertions.assertAll("Validate data of the element 'Fleece Jacket': ", 
				() -> Assertions.assertTrue(inventoryHomePage.imgOfProductWithId(PRODUCT_NUM_ID.FLEECE_JACKET.getProductId()).isDisplayed()),
				() -> Assertions.assertEquals("Sauce Labs Fleece Jacket", inventoryHomePage.titleOfProductWithId(PRODUCT_NUM_ID.FLEECE_JACKET.getProductId()).getText()),
				() -> Assertions.assertEquals("It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling "
						+ "everything from a relaxing day outdoors to a busy day at the office.", inventoryHomePage.txtOfProductWithId(PRODUCT_NUM_ID.FLEECE_JACKET.getProductId()).getText()),
				() -> Assertions.assertEquals("$49.99", inventoryHomePage.valueOfProductWithId(PRODUCT_TXT_ID.FLEECE_JACKET.getProductId()).getText()),
				() -> Assertions.assertEquals("Add to cart", inventoryHomePage.btnAddToCartOfProductWithId(PRODUCT_TXT_ID.FLEECE_JACKET.getProductId()).getText()));
	}
	
	public void validadeOnesieProductData() {
		Assertions.assertAll("Validate data of the element 'Onesie': ", 
				() -> Assertions.assertTrue(inventoryHomePage.imgOfProductWithId(PRODUCT_NUM_ID.ONESIE.getProductId()).isDisplayed()),
				() -> Assertions.assertEquals("Sauce Labs Onesie", inventoryHomePage.titleOfProductWithId(PRODUCT_NUM_ID.ONESIE.getProductId()).getText()),
				() -> Assertions.assertEquals("Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom "
						+ "closure, two-needle hemmed sleeved and bottom won't unravel.", inventoryHomePage.txtOfProductWithId(PRODUCT_NUM_ID.ONESIE.getProductId()).getText()),
				() -> Assertions.assertEquals("$7.99", inventoryHomePage.valueOfProductWithId(PRODUCT_TXT_ID.ONESIE.getProductId()).getText()),
				() -> Assertions.assertEquals("Add to cart", inventoryHomePage.btnAddToCartOfProductWithId(PRODUCT_TXT_ID.ONESIE.getProductId()).getText()));
	}

	public void validadeTShirtRedProductData() {
		Assertions.assertAll("Validate data of the element 'Test.allTheThings() T-Shirt (Red)': ", 
				() -> Assertions.assertTrue(inventoryHomePage.imgOfProductWithId(PRODUCT_NUM_ID.T_SHIRT_RED.getProductId()).isDisplayed()),
				() -> Assertions.assertEquals("Test.allTheThings() T-Shirt (Red)", inventoryHomePage.titleOfProductWithId(PRODUCT_NUM_ID.T_SHIRT_RED.getProductId()).getText()),
				() -> Assertions.assertEquals("This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. "
						+ "Super-soft and comfy ringspun combed cotton.", inventoryHomePage.txtOfProductWithId(PRODUCT_NUM_ID.T_SHIRT_RED.getProductId()).getText()),
				() -> Assertions.assertEquals("$15.99", inventoryHomePage.valueOfProductWithId(PRODUCT_TXT_ID.T_SHIRT_RED.getProductId()).getText()),
				() -> Assertions.assertEquals("Add to cart", inventoryHomePage.btnAddToCartOfProductWithId(PRODUCT_TXT_ID.T_SHIRT_RED.getProductId()).getText()));
	}
	
	/**
	 * @param id = sauce-labs-backpack -> Backpack
	 * @param id = sauce-labs-bike-light -> Bike Light
	 * @param id = sauce-labs-bolt-t-shirt -> Bolt Tshirt
	 * @param id = sauce-labs-fleece-jacket -> Fleece Jacket
	 * @param id = sauce-labs-onesie -> Onesie
	 * @param id = test.allthethings()-t-shirt-(red) -> Test.allTheThings() T-Shirt (Red)
	 */
	public void validateTextDisplayedBtnAddToCartOfProduct(String id) {
		Assertions.assertEquals("Add to cart", inventoryHomePage.btnAddToCartOfProductWithId(id).getText());
	}
	
	/**
	 * @param id = sauce-labs-backpack -> Backpack
	 * @param id = sauce-labs-bike-light -> Bike Light
	 * @param id = sauce-labs-bolt-t-shirt -> Bolt Tshirt
	 * @param id = sauce-labs-fleece-jacket -> Fleece Jacket
	 * @param id = sauce-labs-onesie -> Onesie
	 * @param id = test.allthethings()-t-shirt-(red) -> Test.allTheThings() T-Shirt (Red)
	 */
	public void validateTextDisplayedBtnRemoveProductFromCart(String id) {
		Assertions.assertEquals("Remove", inventoryHomePage.btnRemoveFromCartProductWithId(id).getText());
	}
}
