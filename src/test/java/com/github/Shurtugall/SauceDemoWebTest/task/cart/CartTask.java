package com.github.Shurtugall.SauceDemoWebTest.task.cart;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.cart.CartPage;
import com.github.Shurtugall.SauceDemoWebTest.page.checkout.CheckoutInformationPage;
import com.github.Shurtugall.SauceDemoWebTest.page.home.InventoryHomePage;
import com.github.Shurtugall.SauceDemoWebTest.task.base.BaseTask;

public class CartTask extends BaseTask{
	
	private CartPage cartPage;
	private InventoryHomePage inventoryHomePage;
	private CheckoutInformationPage checkoutInformationPage;

	public CartTask(RemoteWebDriver driver) {
		super(driver);
		cartPage = new CartPage(driver);
		inventoryHomePage = new InventoryHomePage(driver);
		checkoutInformationPage = new CheckoutInformationPage(driver);
	}

	public void removeProductFromCartAtPosition(int position) {
		cartPage.btnRemoveOfProductOnIndex(position-1).click();;
	}
	
	public void clickOnContinueShoppingButton() {
		cartPage.btnContinueShopping().click();
		waitForElement(inventoryHomePage.pageTitle());
	}
	
	public void clickOnCheckoutButton() {
		cartPage.btnCheckout().click();
		waitForElement(checkoutInformationPage.btnContinue());
	}
	
}
