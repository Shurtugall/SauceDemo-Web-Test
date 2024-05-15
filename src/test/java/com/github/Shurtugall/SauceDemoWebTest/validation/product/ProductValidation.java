package com.github.Shurtugall.SauceDemoWebTest.validation.product;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.product.ProductPage;
import com.github.Shurtugall.SauceDemoWebTest.validation.base.BaseValidation;

public class ProductValidation extends BaseValidation{

	private ProductPage productPage;
	
	public ProductValidation(RemoteWebDriver driver) {
		super(driver);
		productPage = new ProductPage(driver);
	}
	
	public void validateTextDisplayedBtnAddToCartOfProduct() {
		Assertions.assertEquals("Add to cart", productPage.btnAddToCart().getText());
	}
	
	public void validateTextDisplayedBtnRemoveProductFromCart() {
		Assertions.assertEquals("Remove", productPage.btnAddToCart().getText());
	}
	
	public void validateBackPackData() {
		Assertions.assertAll("Validation of static elements on the screen", 
				() -> Assertions.assertEquals("Back to products", productPage.btnBackToProducts().getText()),
				() -> Assertions.assertTrue(productPage.imgOfProduct().isDisplayed()),
				() -> Assertions.assertEquals("Sauce Labs Backpack", productPage.titleOfProduct().getText()),
				() -> Assertions.assertEquals("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style "
						+ "with unequaled laptop and tablet protection.", productPage.txtOfProduct().getText()),
				() -> Assertions.assertEquals("$29.99", productPage.priceOfProduct().getText()),
				() -> validateTextDisplayedBtnAddToCartOfProduct());
	}

}
