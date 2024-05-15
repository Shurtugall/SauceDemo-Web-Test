package com.github.Shurtugall.SauceDemoWebTest.validation.checkout;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.checkout.CheckoutCompletePage;
import com.github.Shurtugall.SauceDemoWebTest.validation.base.BaseValidation;

public class CheckoutCompleteValidation extends BaseValidation{
	
	private CheckoutCompletePage checkoutCompletePage;
	
	public CheckoutCompleteValidation(RemoteWebDriver driver) {
		super(driver);
		checkoutCompletePage = new CheckoutCompletePage(driver);
	}
	
	public void validateStaticElementsOnTheScreen() {
		Assertions.assertAll("Validate static page elements: ", 
				() -> Assertions.assertEquals("Checkout: Complete!", checkoutCompletePage.titleOverview().getText()),
				() -> Assertions.assertTrue(checkoutCompletePage.imgSucess().isDisplayed()),
				() -> Assertions.assertEquals("Thank you for your order!", checkoutCompletePage.titleThankYou().getText()),
				() -> Assertions.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", checkoutCompletePage.txtOrderDispatched().getText()),
				() -> Assertions.assertEquals("Back Home", checkoutCompletePage.btnBackHome().getText()));
	}

}
