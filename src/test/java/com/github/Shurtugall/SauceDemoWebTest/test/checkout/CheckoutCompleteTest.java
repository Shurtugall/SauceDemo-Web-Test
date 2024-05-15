package com.github.Shurtugall.SauceDemoWebTest.test.checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.task.cart.CartTask;
import com.github.Shurtugall.SauceDemoWebTest.task.checkout.CheckoutCompleteTask;
import com.github.Shurtugall.SauceDemoWebTest.task.checkout.CheckoutInformationTask;
import com.github.Shurtugall.SauceDemoWebTest.task.checkout.CheckoutOverviewTask;
import com.github.Shurtugall.SauceDemoWebTest.task.home.InventoryHomeTask;
import com.github.Shurtugall.SauceDemoWebTest.task.login.LoginTask;
import com.github.Shurtugall.SauceDemoWebTest.test.login.LoginTest;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.PASSWORDS;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.USERNAMES;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.home.PRODUCT_TXT_ID;
import com.github.Shurtugall.SauceDemoWebTest.validation.checkout.CheckoutCompleteValidation;
import com.github.Shurtugall.SauceDemoWebTest.validation.checkout.CheckoutOverviewValidation;
import com.github.Shurtugall.SauceDemoWebTest.validation.home.InventoryHomeValidation;

public class CheckoutCompleteTest extends LoginTest{

	private LoginTask loginTask;
	private InventoryHomeTask inventoryHomeTask;
	private InventoryHomeValidation inventoryHomeValidation;
	private CartTask cartTask;
	private CheckoutInformationTask checkoutInformationTask;
	private CheckoutOverviewTask checkoutOverviewTask;
	private CheckoutOverviewValidation checkoutOverviewValidation;
	private CheckoutCompleteTask checkoutCompleteTask;
	private CheckoutCompleteValidation checkoutCompleteValidation;
	
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
		checkoutCompleteTask = new CheckoutCompleteTask(driver);
		checkoutCompleteValidation = new CheckoutCompleteValidation(driver);
	}
	
	@Tag("Regression")
	@Test
	@DisplayName("Checking if the user can finish the purchase with sucess")
	public void testFinishPurchase(){
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
		checkoutOverviewValidation.validateExpectedNumberOfProductsInCart(6);
		checkoutOverviewTask.clickOnButtonFinish();
		checkoutCompleteValidation.validateStaticElementsOnTheScreen();
		checkoutCompleteValidation.validateBadgeShoppingCartIsNotDisplayed(true);
		checkoutCompleteTask.clickOnBackHomeButton();
	}
	
	
	
	
}
