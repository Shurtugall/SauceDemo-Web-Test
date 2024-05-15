package com.github.Shurtugall.SauceDemoWebTest.test.checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.task.cart.CartTask;
import com.github.Shurtugall.SauceDemoWebTest.task.checkout.CheckoutInformationTask;
import com.github.Shurtugall.SauceDemoWebTest.task.home.InventoryHomeTask;
import com.github.Shurtugall.SauceDemoWebTest.task.login.LoginTask;
import com.github.Shurtugall.SauceDemoWebTest.test.login.LoginTest;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.PASSWORDS;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.USERNAMES;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.home.PRODUCT_TXT_ID;
import com.github.Shurtugall.SauceDemoWebTest.validation.checkout.CheckoutInformationValidation;

public class CheckoutInformationTest extends LoginTest{

	private LoginTask loginTask;
	private InventoryHomeTask inventoryHomeTask;
	private CartTask cartTask;
	private CheckoutInformationTask checkoutInformationTask;
	private CheckoutInformationValidation checkoutInformationValidation;
	
	@BeforeEach
	public void instanceTasks() {
		driver = (RemoteWebDriver) createAcess();
		loginTask = new LoginTask(driver);
		inventoryHomeTask = new InventoryHomeTask(driver);
		cartTask = new CartTask(driver);
		checkoutInformationTask = new CheckoutInformationTask(driver);
		checkoutInformationValidation = new CheckoutInformationValidation(driver);
	}
	
	@Tag("Regression")
	@Test
	@DisplayName("Checking the behavior when fields are filled with default values")
	public void testFillingFieldsWithDeafultValues() {
		loginTask.loginWithUser(USERNAMES.STANDARD.getUsername(), PASSWORDS.MAIN.getPassword());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.BACKPACK.getProductId());
		inventoryHomeTask.clickOnCartButton();
		cartTask.clickOnCheckoutButton();
		checkoutInformationValidation.validateStaticElementsOnTheScreen();
		checkoutInformationTask.fillInputsWithDefaultData();
		checkoutInformationTask.clickOnContinueButton();
	}
	
	@Tag("Regression")
	@Test
	@DisplayName("Checking the behavior of cancel button")
	public void testBehaviorOfButtonCancel() {
		loginTask.loginWithUser(USERNAMES.STANDARD.getUsername(), PASSWORDS.MAIN.getPassword());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.BACKPACK.getProductId());
		inventoryHomeTask.clickOnCartButton();
		cartTask.clickOnCheckoutButton();
		checkoutInformationTask.clickOnCancelButton();
	}
	
	@Tag("Regression")
	@Test
	@DisplayName("Checking the behavior when fields are empty and the user tries to advance")
	public void testErrorMessagesForEmptyFields() {
		loginTask.loginWithUser(USERNAMES.STANDARD.getUsername(), PASSWORDS.MAIN.getPassword());
		inventoryHomeTask.addToCardTheProduct(PRODUCT_TXT_ID.BACKPACK.getProductId());
		inventoryHomeTask.clickOnCartButton();
		cartTask.clickOnCheckoutButton();
		
		String defaultFirstName = "FirstName";
		String defaultLastName = "LastName";
		checkoutInformationTask.clickOnContinueButtonExpectingSomeError();
		checkoutInformationValidation.validateErrorFirstNameRequired();
		checkoutInformationTask.fillFirstNameInputWith(defaultFirstName);
		checkoutInformationTask.clickOnContinueButtonExpectingSomeError();
		checkoutInformationValidation.validateErrorLastNameRequired();
		checkoutInformationTask.fillLastNameInputWith(defaultLastName);
		checkoutInformationTask.clickOnContinueButtonExpectingSomeError();
		checkoutInformationValidation.validateErrorPostalCodeRequired();
	}
}
