package com.github.Shurtugall.SauceDemoWebTest.validation.checkout;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.checkout.CheckoutInformationPage;
import com.github.Shurtugall.SauceDemoWebTest.validation.base.BaseValidation;

public class CheckoutInformationValidation extends BaseValidation{

	private CheckoutInformationPage checkoutInformationPage;
	
	public CheckoutInformationValidation(RemoteWebDriver driver) {
		super(driver);
		checkoutInformationPage = new CheckoutInformationPage(driver);
	}
	
	public void validateStaticElementsOnTheScreen() {
		Assertions.assertAll("Validate of static page elements: ", 
				() -> Assertions.assertEquals("Checkout: Your Information", checkoutInformationPage.titleYourInformation().getText()),
				
				() -> Assertions.assertEquals("First Name", checkoutInformationPage.inputFirstName().getAttribute("placeholder")),
				() -> Assertions.assertEquals("Last Name", checkoutInformationPage.inputLastName().getAttribute("placeholder")),
				() -> Assertions.assertEquals("Zip/Postal Code", checkoutInformationPage.inputPostalCode().getAttribute("placeholder")),
				
				() -> Assertions.assertEquals("Cancel", checkoutInformationPage.btnCancel().getText()),
				() -> Assertions.assertEquals("Continue", checkoutInformationPage.btnContinue().getAttribute("value")));
	}
	
	public void validateElementsShownErrorInputsRequired() {
		Assertions.assertAll("Validate the elements that appears when the user tries to continue withou filling the inputs: ", 
				() -> Assertions.assertTrue(checkoutInformationPage.svgErrorInputFirstName().isDisplayed()),
				() -> Assertions.assertTrue(checkoutInformationPage.svgErrorInputLastName().isDisplayed()),
				() -> Assertions.assertTrue(checkoutInformationPage.svgErrorInputPostalCode().isDisplayed()));
	}
	
	public void validateErrorFirstNameRequired() {
		Assertions.assertEquals("Error: First Name is required", checkoutInformationPage.txtErrorMessage().getText());
		validateElementsShownErrorInputsRequired();
	}
	
	public void validateErrorLastNameRequired() {
		Assertions.assertEquals("Error: Last Name is required", checkoutInformationPage.txtErrorMessage().getText());
		validateElementsShownErrorInputsRequired();
	}
	
	public void validateErrorPostalCodeRequired() {
		Assertions.assertEquals("Error: Postal Code is required", checkoutInformationPage.txtErrorMessage().getText());
		validateElementsShownErrorInputsRequired();
	}

}
