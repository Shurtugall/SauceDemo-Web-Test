package com.github.Shurtugall.SauceDemoWebTest.task.checkout;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.cart.CartPage;
import com.github.Shurtugall.SauceDemoWebTest.page.checkout.CheckoutInformationPage;
import com.github.Shurtugall.SauceDemoWebTest.page.checkout.CheckoutOverviewPage;
import com.github.Shurtugall.SauceDemoWebTest.task.base.BaseTask;

public class CheckoutInformationTask extends BaseTask{

	private CheckoutInformationPage checkoutInformationPage;
	private CartPage cartPage;
	private CheckoutOverviewPage checkoutOverviewPage;
	
	public CheckoutInformationTask(RemoteWebDriver driver) {
		super(driver);
		checkoutInformationPage = new CheckoutInformationPage(driver);
		cartPage = new CartPage(driver);
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
	}
	
	public void fillInputsWithDefaultData() {
		fillFirstNameInputWith("FirstName");
		fillLastNameInputWith("SecondName");
		fillPostalCodeInputWith("00000001");
	}
	
	public void fillFirstNameInputWith(String firstName) {
		checkoutInformationPage.inputFirstName().sendKeys(firstName);
	}

	public void fillLastNameInputWith(String lastName) {
		checkoutInformationPage.inputLastName().sendKeys(lastName);
	}
	
	public void fillPostalCodeInputWith(String postalCode) {
		checkoutInformationPage.inputPostalCode().sendKeys(postalCode);
	}
	
	public void clickOnButtonToCloseErrorMessages() {
		checkoutInformationPage.btnCloseErrorMessage().click();
	}
	
	public void clickOnCancelButton() {
		checkoutInformationPage.btnCancel().click();
		waitForElement(cartPage.btnCheckout());
	}
	
	public void clickOnContinueButton() {
		checkoutInformationPage.btnContinue().click();
		waitForElement(checkoutOverviewPage.titleOverview());
	}
	
	public void clickOnContinueButtonExpectingSomeError() {
		checkoutInformationPage.btnContinue().click();
		waitForElement(checkoutInformationPage.txtErrorMessage());
	}
	
	
}
