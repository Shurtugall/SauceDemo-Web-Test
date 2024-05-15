package com.github.Shurtugall.SauceDemoWebTest.test.cart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.task.cart.CartTask;
import com.github.Shurtugall.SauceDemoWebTest.task.home.InventoryHomeTask;
import com.github.Shurtugall.SauceDemoWebTest.task.login.LoginTask;
import com.github.Shurtugall.SauceDemoWebTest.test.login.LoginTest;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.PASSWORDS;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.USERNAMES;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.home.PRODUCT_TXT_ID;
import com.github.Shurtugall.SauceDemoWebTest.validation.cart.CartValidation;

public class CartTest extends LoginTest{

	private LoginTask loginTask;
	private InventoryHomeTask inventoryHomeTask;
	private CartTask cartTask;
	private CartValidation cartValidation;
	
	@BeforeEach
	public void instanceTasks() {
		driver = (RemoteWebDriver) createAcess();
		loginTask = new LoginTask(driver);
		inventoryHomeTask = new InventoryHomeTask(driver);
		cartTask = new CartTask(driver);
		cartValidation = new CartValidation(driver);
	}
	
	@Tag("Regression")
	@Test
	@DisplayName("Check all the elements added to cart")
	public void validateElementsInCartWithStandardUser() {
		loginTask.loginWithUser(USERNAMES.STANDARD.getUsername(), PASSWORDS.MAIN.getPassword());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.BACKPACK.getProductId());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.BIKE_LIGHT.getProductId());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.BOLT_T_SHIRT.getProductId());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.FLEECE_JACKET.getProductId());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.ONESIE.getProductId());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.T_SHIRT_RED.getProductId());
		inventoryHomeTask.clickOnCartButton();
		
		cartValidation.validateProductInTheCartListAtPosition("BACKPACK", 1);
		cartValidation.validateProductInTheCartListAtPosition("BIKE_LIGHT", 2);
		cartValidation.validateProductInTheCartListAtPosition("BOLT_T_SHIRT", 3);
		cartValidation.validateProductInTheCartListAtPosition("FLEECE_JACKET", 4);
		cartValidation.validateProductInTheCartListAtPosition("ONESIE", 5);
		cartValidation.validateProductInTheCartListAtPosition("T_SHIRT_RED", 6);
	}
	
	@Tag("Regression")
	@Test
	@DisplayName("Check the feature removing product from cart and return to inventory home page")
	public void validateRemoveFromCartFeatureAndContinueShoppingWithStandardUser() {
		loginTask.loginWithUser(USERNAMES.STANDARD.getUsername(), PASSWORDS.MAIN.getPassword());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.BACKPACK.getProductId());
		inventoryHomeTask.clickOnCartButton();
		cartValidation.validateExpectedNumberOfProductsInCart(1);
		cartTask.removeProductFromCartAtPosition(1);
		cartValidation.validateBadgeShoppingCartIsNotDisplayed(true);
		cartTask.clickOnContinueShoppingButton();
	}
	
}
