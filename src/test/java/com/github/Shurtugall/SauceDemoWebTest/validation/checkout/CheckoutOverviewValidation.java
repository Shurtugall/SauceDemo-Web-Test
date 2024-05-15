package com.github.Shurtugall.SauceDemoWebTest.validation.checkout;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.checkout.CheckoutOverviewPage;
import com.github.Shurtugall.SauceDemoWebTest.task.checkout.CheckoutOverviewTask;
import com.github.Shurtugall.SauceDemoWebTest.validation.base.BaseValidation;
import com.github.Shurtugall.SauceDemoWebTest.validation.utils.PRODUCT_DESCRIPTION;
import com.github.Shurtugall.SauceDemoWebTest.validation.utils.PRODUCT_PRICE;
import com.github.Shurtugall.SauceDemoWebTest.validation.utils.PRODUCT_TITLE;

public class CheckoutOverviewValidation extends BaseValidation{
		
	private CheckoutOverviewPage checkoutOverviewPage;
	
	private CheckoutOverviewTask checkoutOverviewTask;
	
	public CheckoutOverviewValidation(RemoteWebDriver driver) {
		super(driver);
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
		checkoutOverviewTask = new CheckoutOverviewTask(driver);
	}
	
	public void validateStaticElementsOnTheScreen() {
		Assertions.assertAll("Validate of static page elements: ", 
				() -> Assertions.assertEquals("Checkout: Overview", checkoutOverviewPage.titleOverview().getText()),
				
				() -> Assertions.assertEquals("Cancel", checkoutOverviewPage.btnCancel().getText()),
				() -> Assertions.assertEquals("Finish", checkoutOverviewPage.btnFinish().getText()));
	}
	
	/**
	 * @param productTitle -> BACKPACK
	 * @param productTitle -> BIKE_LIGHT
	 * @param productTitle -> BOLT_T_SHIRT
	 * @param productTitle -> FLEECE_JACKET
	 * @param productTitle -> ONESIE
	 * @param productTitle -> T_SHIRT_RED
	 * @param position
	 */
	public void validateProductInTheListAtPosition(String productTitle, int position) {
		int index = position-1;
		switch(PRODUCT_TITLE.valueOf(productTitle)) {
			case BACKPACK:
				Assertions.assertAll("Validation of element "+ PRODUCT_TITLE.BACKPACK.getProductTitle() +" at position "+ position +": ", 
						() -> Assertions.assertEquals(PRODUCT_TITLE.BACKPACK.getProductTitle(), checkoutOverviewPage.titleOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals(PRODUCT_DESCRIPTION.BACKPACK.getProductDescription(), checkoutOverviewPage.txtOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("$"+PRODUCT_PRICE.BACKPACK.getProductPrice(), checkoutOverviewPage.valueOfProductOnIndex(index).getText()));
				break;
			case BIKE_LIGHT:
				Assertions.assertAll("Validation of element "+ PRODUCT_TITLE.BIKE_LIGHT.getProductTitle() +" at position "+ position +": ", 
						() -> Assertions.assertEquals(PRODUCT_TITLE.BIKE_LIGHT.getProductTitle(), checkoutOverviewPage.titleOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals(PRODUCT_DESCRIPTION.BIKE_LIGHT.getProductDescription(), checkoutOverviewPage.txtOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("$"+PRODUCT_PRICE.BIKE_LIGHT.getProductPrice(), checkoutOverviewPage.valueOfProductOnIndex(index).getText()));
				break;
			case BOLT_T_SHIRT:
				Assertions.assertAll("Validation of element "+ PRODUCT_TITLE.BOLT_T_SHIRT.getProductTitle() +" at position "+ position +": ", 
						() -> Assertions.assertEquals(PRODUCT_TITLE.BOLT_T_SHIRT.getProductTitle(), checkoutOverviewPage.titleOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals(PRODUCT_DESCRIPTION.BOLT_T_SHIRT.getProductDescription(), checkoutOverviewPage.txtOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("$"+PRODUCT_PRICE.BOLT_T_SHIRT.getProductPrice(), checkoutOverviewPage.valueOfProductOnIndex(index).getText()));
				break;
			case FLEECE_JACKET:
				Assertions.assertAll("Validation of element "+ PRODUCT_TITLE.FLEECE_JACKET.getProductTitle() +" at position "+ position +": ", 
						() -> Assertions.assertEquals(PRODUCT_TITLE.FLEECE_JACKET.getProductTitle(), checkoutOverviewPage.titleOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals(PRODUCT_DESCRIPTION.FLEECE_JACKET.getProductDescription(), checkoutOverviewPage.txtOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("$"+PRODUCT_PRICE.FLEECE_JACKET.getProductPrice(), checkoutOverviewPage.valueOfProductOnIndex(index).getText()));
				break;
			case ONESIE:
				Assertions.assertAll("Validation of element "+ PRODUCT_TITLE.ONESIE.getProductTitle() +" at position "+ position +": ", 
						() -> Assertions.assertEquals(PRODUCT_TITLE.ONESIE.getProductTitle(), checkoutOverviewPage.titleOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals(PRODUCT_DESCRIPTION.ONESIE.getProductDescription(), checkoutOverviewPage.txtOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("$"+PRODUCT_PRICE.ONESIE.getProductPrice(), checkoutOverviewPage.valueOfProductOnIndex(index).getText()));
				break;
			case T_SHIRT_RED:
				Assertions.assertAll("Validation of element "+ PRODUCT_TITLE.T_SHIRT_RED.getProductTitle() +" at position "+ position +": ", 
						() -> Assertions.assertEquals(PRODUCT_TITLE.T_SHIRT_RED.getProductTitle(), checkoutOverviewPage.titleOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals(PRODUCT_DESCRIPTION.T_SHIRT_RED.getProductDescription(), checkoutOverviewPage.txtOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("$"+PRODUCT_PRICE.T_SHIRT_RED.getProductPrice(), checkoutOverviewPage.valueOfProductOnIndex(index).getText()));
				break;
		}
	}
	
	public void validatePaymentShippingAndPriceInformation(String sumOfTax) {
		Assertions.assertAll("", 
				() -> Assertions.assertEquals("Payment Information:", checkoutOverviewPage.titlePaymentInformation().getText()),
				() -> Assertions.assertEquals("SauceCard #31337", checkoutOverviewPage.txtPaymentInformation().getText()),
				
				() -> Assertions.assertEquals("Shipping Information:", checkoutOverviewPage.titleShippingInformation().getText()),
				() -> Assertions.assertEquals("Free Pony Express Delivery!", checkoutOverviewPage.txtShippingInformation().getText()),
				
				() -> Assertions.assertEquals("Price Total", checkoutOverviewPage.titlePriceTotal().getText()),
				() -> Assertions.assertEquals("Item total: $" + checkoutOverviewTask.getSumOfProductsValue() , checkoutOverviewPage.txtSumItemTotal().getText()),
				() -> Assertions.assertEquals("Tax: $" + sumOfTax , checkoutOverviewPage.txtSumTax().getText()),
				() -> Assertions.assertEquals("Total: $" + (Double.valueOf(checkoutOverviewTask.getSumOfProductsValue()) + Double.valueOf(sumOfTax)) , checkoutOverviewPage.txtSumTotalValue().getText()));
	}

}
