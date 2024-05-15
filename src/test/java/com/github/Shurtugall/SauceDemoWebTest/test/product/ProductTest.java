package com.github.Shurtugall.SauceDemoWebTest.test.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.task.home.InventoryHomeTask;
import com.github.Shurtugall.SauceDemoWebTest.task.login.LoginTask;
import com.github.Shurtugall.SauceDemoWebTest.task.product.ProductTask;
import com.github.Shurtugall.SauceDemoWebTest.test.login.LoginTest;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.PASSWORDS;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.USERNAMES;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.home.PRODUCT_NUM_ID;
import com.github.Shurtugall.SauceDemoWebTest.validation.product.ProductValidation;

public class ProductTest extends LoginTest{

	private LoginTask loginTask;
	private InventoryHomeTask inventoryHomeTask;
	private ProductTask productTask;
	private ProductValidation productValidation;
	
	@BeforeEach
	public void instanceTasks() {
		driver = (RemoteWebDriver) createAcess();
		loginTask = new LoginTask(driver);
		inventoryHomeTask = new InventoryHomeTask(driver);
		productTask = new ProductTask(driver);
		productValidation = new ProductValidation(driver);
	}
	
	@Tag("Regression")
	@Test
	@DisplayName("Check elements displayed to a standard user")
	public void testProductElementsDisplayedWithStandardUser() {
		loginTask.loginWithUser(USERNAMES.STANDARD.getUsername(), PASSWORDS.MAIN.getPassword());
		inventoryHomeTask.clickOnProduct(PRODUCT_NUM_ID.BACKPACK.getProductId());
		productValidation.validateStaticHeaderElements();
		productValidation.validateBackPackData();
	}
	
	@Tag("Regression")
	@Test
	@DisplayName("Check if the add to cart feature is working")
	public void testProductAddToCartFeatureAndRemoveWithStandardUser() {
		loginTask.loginWithUser(USERNAMES.STANDARD.getUsername(), PASSWORDS.MAIN.getPassword());
		inventoryHomeTask.clickOnProduct(PRODUCT_NUM_ID.BACKPACK.getProductId());
		productValidation.validateStaticHeaderElements();
		productTask.addToCardTheProduct();
		productValidation.validateExpectedNumberOfProductsInCart(1);
		productTask.removeProductFromCart();
		productValidation.validateBadgeShoppingCartIsNotDisplayed(true);
		productTask.returnToInventoryHomePage();
	}
	
	
}
