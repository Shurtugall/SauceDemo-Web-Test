package com.github.Shurtugall.SauceDemoWebTest.test.checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.task.cart.CartTask;
import com.github.Shurtugall.SauceDemoWebTest.task.checkout.CheckoutInformationTask;
import com.github.Shurtugall.SauceDemoWebTest.task.checkout.CheckoutOverviewTask;
import com.github.Shurtugall.SauceDemoWebTest.task.home.InventoryHomeTask;
import com.github.Shurtugall.SauceDemoWebTest.task.login.LoginTask;
import com.github.Shurtugall.SauceDemoWebTest.test.login.LoginTest;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.PASSWORDS;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.USERNAMES;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.home.PRODUCT_TXT_ID;
import com.github.Shurtugall.SauceDemoWebTest.validation.checkout.CheckoutOverviewValidation;
import com.github.Shurtugall.SauceDemoWebTest.validation.home.InventoryHomeValidation;

public class CheckoutOverviewTest extends LoginTest{
	
	private LoginTask loginTask;
	private InventoryHomeTask inventoryHomeTask;
	private InventoryHomeValidation inventoryHomeValidation;
	private CartTask cartTask;
	private CheckoutInformationTask checkoutInformationTask;
	private CheckoutOverviewTask checkoutOverviewTask;
	private CheckoutOverviewValidation checkoutOverviewValidation;
	
	@BeforeEach
	public void instanceTasks() {
		driver = (RemoteWebDriver) createAcess();
		loginTask = new LoginTask(driver);
		inventoryHomeTask = new InventoryHomeTask(driver);
		inventoryHomeValidation = new InventoryHomeValidation(driver);
		cartTask = new CartTask(driver);
		checkoutInformationTask = new CheckoutInformationTask(driver);
		checkoutOverviewTask = new CheckoutOverviewTask(driver);
		checkoutOverviewValidation = new CheckoutOverviewValidation(driver);
	}
	
	@Tag("Regression")
	@Test
	@DisplayName("Finishing the purchase with all items displayed on home page add to cart")
	public void testFinishingThePurchaseWithAllTheItemsInCart() {
		loginTask.loginWithUser(USERNAMES.STANDARD.getUsername(), PASSWORDS.MAIN.getPassword());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.BACKPACK.getProductId());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.BIKE_LIGHT.getProductId());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.BOLT_T_SHIRT.getProductId());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.FLEECE_JACKET.getProductId());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.ONESIE.getProductId());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.T_SHIRT_RED.getProductId());
		inventoryHomeTask.clickOnCartButton();
		cartTask.clickOnCheckoutButton();
		checkoutInformationTask.fillInputsWithDefaultData();
		checkoutInformationTask.clickOnContinueButton();
		checkoutOverviewValidation.validateStaticElementsOnTheScreen();
		checkoutOverviewValidation.validateProductInTheListAtPosition("BACKPACK", 1);
		checkoutOverviewValidation.validateProductInTheListAtPosition("BIKE_LIGHT", 2);
		checkoutOverviewValidation.validateProductInTheListAtPosition("BOLT_T_SHIRT", 3);
		checkoutOverviewValidation.validateProductInTheListAtPosition("FLEECE_JACKET", 4);
		checkoutOverviewValidation.validateProductInTheListAtPosition("ONESIE", 5);
		checkoutOverviewValidation.validateProductInTheListAtPosition("T_SHIRT_RED", 6);
		checkoutOverviewValidation.validatePaymentShippingAndPriceInformation("10.40");
		checkoutOverviewTask.clickOnButtonFinish();
	}
	
	@Tag("Regression")
	@Test
	@DisplayName("Checking the behavior of when clicking in the cancel button")
	public void testIfProductsAreKeptInCartWhenClickingOnCancelButton() {
		loginTask.loginWithUser(USERNAMES.STANDARD.getUsername(), PASSWORDS.MAIN.getPassword());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.BACKPACK.getProductId());
		inventoryHomeTask.clickOnCartButton();
		cartTask.clickOnCheckoutButton();
		checkoutInformationTask.fillInputsWithDefaultData();
		checkoutInformationTask.clickOnContinueButton();
		checkoutOverviewTask.clickOnButtonCancel();
		inventoryHomeValidation.validateBadgeShoppingCartIsNotDisplayed(false);
	}
	
}
