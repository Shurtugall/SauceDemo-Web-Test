package com.github.Shurtugall.SauceDemoWebTest.task.checkout;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.checkout.CheckoutCompletePage;
import com.github.Shurtugall.SauceDemoWebTest.page.home.InventoryHomePage;
import com.github.Shurtugall.SauceDemoWebTest.task.base.BaseTask;

public class CheckoutCompleteTask extends BaseTask{

	private CheckoutCompletePage checkoutCompletePage;
	private InventoryHomePage inventoryHomePage;
	
	public CheckoutCompleteTask(RemoteWebDriver driver) {
		super(driver);
		checkoutCompletePage = new CheckoutCompletePage(driver);
		inventoryHomePage = new InventoryHomePage(driver);
	}
	
	public void clickOnBackHomeButton() {
		checkoutCompletePage.btnBackHome().click();
		waitForElement(inventoryHomePage.titleFirstProductDisplayedOnTheList());
	}

}
