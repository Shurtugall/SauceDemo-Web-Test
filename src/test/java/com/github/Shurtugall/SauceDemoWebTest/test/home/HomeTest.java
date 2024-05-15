package com.github.Shurtugall.SauceDemoWebTest.test.home;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.task.home.InventoryHomeTask;
import com.github.Shurtugall.SauceDemoWebTest.task.login.LoginTask;
import com.github.Shurtugall.SauceDemoWebTest.test.login.LoginTest;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.PASSWORDS;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.USERNAMES;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.home.PRODUCT_TXT_ID;
import com.github.Shurtugall.SauceDemoWebTest.validation.home.InventoryHomeValidation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeTest extends LoginTest{

	private LoginTask loginTask;
	private InventoryHomeTask inventoryHomeTask;
	private InventoryHomeValidation inventoryHomeValidation;
	
	@BeforeEach
	public void instanceTasks() {
		driver = (RemoteWebDriver) createAcess();
		loginTask = new LoginTask(driver);
		inventoryHomeTask = new InventoryHomeTask(driver);
		inventoryHomeValidation = new InventoryHomeValidation(driver);
	}
	
	@Tag("Regression")
	@Test
	@DisplayName("Check elements displayed to a standard user")
	public void testHomeElementsDisplayedWithStandardUser() {
		loginTask.loginWithUser(USERNAMES.STANDARD.getUsername(), PASSWORDS.MAIN.getPassword());
		inventoryHomeValidation.validateStaticHeaderElements();
		inventoryHomeValidation.validateStaticFooterElements();
		inventoryHomeValidation.validateStaticElementsOnTheScreen();
		inventoryHomeValidation.validateListOfProducts();
	}
	
	@Tag("Regression")
	@Test
	@DisplayName("Check if the filter feature is working")
	public void testHomeOrderOfElementsUsingFilterFeatureWithStandardUser() {
		loginTask.loginWithUser(USERNAMES.STANDARD.getUsername(), PASSWORDS.MAIN.getPassword());
		inventoryHomeValidation.validateCurrentFilterOption("Name (A to Z)");
		inventoryHomeValidation.validateOrderOfDisplayedProductsFromNameAtoZ();
		inventoryHomeTask.selectFilterOptionWithValue("za");
		inventoryHomeValidation.validateOrderOfDisplayedProductsFromNameZtoA();
		inventoryHomeTask.selectFilterOptionWithValue("lohi");
		inventoryHomeValidation.validateOrderOfDisplayedProductsFromPriceLowToHi();
		inventoryHomeTask.selectFilterOptionWithValue("hilo");
		inventoryHomeValidation.validateOrderOfDisplayedProductsFromPriceHiToLow();
	}
	
	@Tag("Regression")
	@Test
	@DisplayName("Check if the add to cart feature is working")
	public void testHomeAddToCartFeatureAndRemoveWithStandardUser() {
		loginTask.loginWithUser(USERNAMES.STANDARD.getUsername(), PASSWORDS.MAIN.getPassword());
		inventoryHomeValidation.validateBadgeShoppingCartIsNotDisplayed(true);
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.BACKPACK.getProductId());
		inventoryHomeValidation.validateTextDisplayedBtnRemoveProductFromCart(PRODUCT_TXT_ID.BACKPACK.getProductId());
		inventoryHomeValidation.validateExpectedNumberOfProductsInCart(1);
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.BIKE_LIGHT.getProductId());
		inventoryHomeValidation.validateTextDisplayedBtnRemoveProductFromCart(PRODUCT_TXT_ID.BIKE_LIGHT.getProductId());
		inventoryHomeValidation.validateExpectedNumberOfProductsInCart(2);
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.BOLT_T_SHIRT.getProductId());
		inventoryHomeValidation.validateTextDisplayedBtnRemoveProductFromCart(PRODUCT_TXT_ID.BIKE_LIGHT.getProductId());
		inventoryHomeValidation.validateExpectedNumberOfProductsInCart(3);
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.FLEECE_JACKET.getProductId());
		inventoryHomeValidation.validateTextDisplayedBtnRemoveProductFromCart(PRODUCT_TXT_ID.BIKE_LIGHT.getProductId());
		inventoryHomeValidation.validateExpectedNumberOfProductsInCart(4);
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.ONESIE.getProductId());
		inventoryHomeValidation.validateTextDisplayedBtnRemoveProductFromCart(PRODUCT_TXT_ID.BIKE_LIGHT.getProductId());
		inventoryHomeValidation.validateExpectedNumberOfProductsInCart(5);
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.T_SHIRT_RED.getProductId());
		inventoryHomeValidation.validateTextDisplayedBtnRemoveProductFromCart(PRODUCT_TXT_ID.BIKE_LIGHT.getProductId());
		inventoryHomeValidation.validateExpectedNumberOfProductsInCart(6);
		
		inventoryHomeTask.removeProductFromCart(PRODUCT_TXT_ID.BACKPACK.getProductId());
		inventoryHomeValidation.validateTextDisplayedBtnAddToCartOfProduct(PRODUCT_TXT_ID.BACKPACK.getProductId());
		inventoryHomeValidation.validateExpectedNumberOfProductsInCart(5);
		inventoryHomeTask.removeProductFromCart(PRODUCT_TXT_ID.BIKE_LIGHT.getProductId());
		inventoryHomeValidation.validateTextDisplayedBtnAddToCartOfProduct(PRODUCT_TXT_ID.BIKE_LIGHT.getProductId());
		inventoryHomeValidation.validateExpectedNumberOfProductsInCart(4);
		inventoryHomeTask.removeProductFromCart(PRODUCT_TXT_ID.BOLT_T_SHIRT.getProductId());
		inventoryHomeValidation.validateTextDisplayedBtnAddToCartOfProduct(PRODUCT_TXT_ID.BIKE_LIGHT.getProductId());
		inventoryHomeValidation.validateExpectedNumberOfProductsInCart(3);
		inventoryHomeTask.removeProductFromCart(PRODUCT_TXT_ID.FLEECE_JACKET.getProductId());
		inventoryHomeValidation.validateTextDisplayedBtnAddToCartOfProduct(PRODUCT_TXT_ID.BIKE_LIGHT.getProductId());
		inventoryHomeValidation.validateExpectedNumberOfProductsInCart(2);
		inventoryHomeTask.removeProductFromCart(PRODUCT_TXT_ID.ONESIE.getProductId());
		inventoryHomeValidation.validateTextDisplayedBtnAddToCartOfProduct(PRODUCT_TXT_ID.BIKE_LIGHT.getProductId());
		inventoryHomeValidation.validateExpectedNumberOfProductsInCart(1);
		inventoryHomeTask.removeProductFromCart(PRODUCT_TXT_ID.T_SHIRT_RED.getProductId());
		inventoryHomeValidation.validateTextDisplayedBtnAddToCartOfProduct(PRODUCT_TXT_ID.BIKE_LIGHT.getProductId());
		inventoryHomeValidation.validateBadgeShoppingCartIsNotDisplayed(true);
	}
}
