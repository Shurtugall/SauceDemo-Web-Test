package com.github.Shurtugall.SauceDemoWebTest.task.base;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.base.BasePage;
import com.github.Shurtugall.SauceDemoWebTest.page.cart.CartPage;
import com.github.Shurtugall.SauceDemoWebTest.task.utils.WaitTask;

public class BaseTask extends WaitTask{

	private BasePage basePage;
	private CartPage cartPage;
	
	public BaseTask(RemoteWebDriver driver) {
		super(driver);
		basePage = new BasePage(driver);
		cartPage = new CartPage(driver);
	}
	
	public void clickOnCartButton() {
		basePage.iconShoppingCart().click();
		waitForElement(cartPage.iconShoppingCart());
	}
	
}
