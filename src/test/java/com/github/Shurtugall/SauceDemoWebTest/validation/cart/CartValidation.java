package com.github.Shurtugall.SauceDemoWebTest.validation.cart;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.cart.CartPage;
import com.github.Shurtugall.SauceDemoWebTest.validation.base.BaseValidation;
import com.github.Shurtugall.SauceDemoWebTest.validation.utils.PRODUCT_DESCRIPTION;
import com.github.Shurtugall.SauceDemoWebTest.validation.utils.PRODUCT_PRICE;
import com.github.Shurtugall.SauceDemoWebTest.validation.utils.PRODUCT_TITLE;

public class CartValidation extends BaseValidation{

	private CartPage cartPage;
	
	public CartValidation(RemoteWebDriver driver) {
		super(driver);
		cartPage = new CartPage(driver);
	}
	
	public void validateStaticElementsOnTheScreen() {
		Assertions.assertAll("Validation of static elements on the screen: ", 
				() -> Assertions.assertEquals("Your Cart", cartPage.titleYourCart().getText()),
				() -> Assertions.assertEquals("QTY", cartPage.labelTitleQTY().getText()),
				() -> Assertions.assertEquals("Description", cartPage.labelTitleDescription().getText()),
				() -> Assertions.assertEquals("Continue Shopping", cartPage.btnContinueShopping().getText()),
				() -> Assertions.assertEquals("Checkout", cartPage.btnCheckout().getText()));
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
	public void validateProductInTheCartListAtPosition(String productTitle, int position) {
		int index = position-1;
		switch(PRODUCT_TITLE.valueOf(productTitle)) {
			case BACKPACK:
				Assertions.assertAll("Validation of element "+ PRODUCT_TITLE.BACKPACK.getProductTitle() +" at position "+ position +": ", 
						() -> Assertions.assertEquals(PRODUCT_TITLE.BACKPACK.getProductTitle(), cartPage.titleOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals(PRODUCT_DESCRIPTION.BACKPACK.getProductDescription(), cartPage.txtOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("$"+PRODUCT_PRICE.BACKPACK.getProductPrice(), cartPage.valueOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("Remove", cartPage.btnRemoveOfProductOnIndex(index).getText()));
				break;
			case BIKE_LIGHT:
				Assertions.assertAll("Validation of element "+ PRODUCT_TITLE.BIKE_LIGHT.getProductTitle() +" at position "+ position +": ", 
						() -> Assertions.assertEquals(PRODUCT_TITLE.BIKE_LIGHT.getProductTitle(), cartPage.titleOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals(PRODUCT_DESCRIPTION.BIKE_LIGHT.getProductDescription(), cartPage.txtOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("$"+PRODUCT_PRICE.BIKE_LIGHT.getProductPrice(), cartPage.valueOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("Remove", cartPage.btnRemoveOfProductOnIndex(index).getText()));
				break;
			case BOLT_T_SHIRT:
				Assertions.assertAll("Validation of element "+ PRODUCT_TITLE.BOLT_T_SHIRT.getProductTitle() +" at position "+ position +": ", 
						() -> Assertions.assertEquals(PRODUCT_TITLE.BOLT_T_SHIRT.getProductTitle(), cartPage.titleOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals(PRODUCT_DESCRIPTION.BOLT_T_SHIRT.getProductDescription(), cartPage.txtOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("$"+PRODUCT_PRICE.BOLT_T_SHIRT.getProductPrice(), cartPage.valueOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("Remove", cartPage.btnRemoveOfProductOnIndex(index).getText()));
				break;
			case FLEECE_JACKET:
				Assertions.assertAll("Validation of element "+ PRODUCT_TITLE.FLEECE_JACKET.getProductTitle() +" at position "+ position +": ", 
						() -> Assertions.assertEquals(PRODUCT_TITLE.FLEECE_JACKET.getProductTitle(), cartPage.titleOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals(PRODUCT_DESCRIPTION.FLEECE_JACKET.getProductDescription(), cartPage.txtOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("$"+PRODUCT_PRICE.FLEECE_JACKET.getProductPrice(), cartPage.valueOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("Remove", cartPage.btnRemoveOfProductOnIndex(index).getText()));
				break;
			case ONESIE:
				Assertions.assertAll("Validation of element "+ PRODUCT_TITLE.ONESIE.getProductTitle() +" at position "+ position +": ", 
						() -> Assertions.assertEquals(PRODUCT_TITLE.ONESIE.getProductTitle(), cartPage.titleOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals(PRODUCT_DESCRIPTION.ONESIE.getProductDescription(), cartPage.txtOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("$"+PRODUCT_PRICE.ONESIE.getProductPrice(), cartPage.valueOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("Remove", cartPage.btnRemoveOfProductOnIndex(index).getText()));
				break;
			case T_SHIRT_RED:
				Assertions.assertAll("Validation of element "+ PRODUCT_TITLE.T_SHIRT_RED.getProductTitle() +" at position "+ position +": ", 
						() -> Assertions.assertEquals(PRODUCT_TITLE.T_SHIRT_RED.getProductTitle(), cartPage.titleOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals(PRODUCT_DESCRIPTION.T_SHIRT_RED.getProductDescription(), cartPage.txtOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("$"+PRODUCT_PRICE.T_SHIRT_RED.getProductPrice(), cartPage.valueOfProductOnIndex(index).getText()),
						() -> Assertions.assertEquals("Remove", cartPage.btnRemoveOfProductOnIndex(index).getText()));
				break;
		}
	}
	
}
