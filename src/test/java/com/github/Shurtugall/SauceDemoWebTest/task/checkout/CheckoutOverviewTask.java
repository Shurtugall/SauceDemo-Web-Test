package com.github.Shurtugall.SauceDemoWebTest.task.checkout;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.checkout.CheckoutCompletePage;
import com.github.Shurtugall.SauceDemoWebTest.page.checkout.CheckoutOverviewPage;
import com.github.Shurtugall.SauceDemoWebTest.page.home.InventoryHomePage;
import com.github.Shurtugall.SauceDemoWebTest.task.base.BaseTask;

public class CheckoutOverviewTask extends BaseTask{

	private CheckoutOverviewPage checkoutOverviewPage;
	private InventoryHomePage inventoryHomePage;
	private CheckoutCompletePage checkoutCompletePage;
	
	public CheckoutOverviewTask(RemoteWebDriver driver) {
		super(driver);
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
		inventoryHomePage = new InventoryHomePage(driver);
		checkoutCompletePage = new CheckoutCompletePage(driver);
	}
	
	public void clickOnButtonCancel() {
		checkoutOverviewPage.btnCancel().click();
		waitForElement(inventoryHomePage.pageTitle());
	}
	
	public void clickOnButtonFinish() {
		checkoutOverviewPage.btnFinish().click();
		waitForElement(checkoutCompletePage.btnBackHome());
	}
	
	public double getSumOfProductsValue() {
		double sum = 0;
		for(int i = 0; i < checkoutOverviewPage.listOfProducts().size(); i++) {
			sum += Double.valueOf(checkoutOverviewPage.valueOfProductOnIndex(i).getText().replace("$", ""));
		}
		return sum;
	}

}
