package com.github.Shurtugall.SauceDemoWebTest.validation.base;

import java.time.Year;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.base.BasePage;

public class BaseValidation {

	protected RemoteWebDriver driver;
	
	private BasePage basePage;
	
	public BaseValidation(RemoteWebDriver driver) {
		this.driver = driver;
		basePage = new BasePage(driver);
	}
	
	public void validateStaticHeaderElements() {
		Assertions.assertAll("Validate presence of static header elements: ", 
				() -> Assertions.assertTrue(basePage.burguerMenu().isDisplayed()),
				() -> Assertions.assertEquals("Swag Labs", basePage.pageTitle().getText()),
				() -> Assertions.assertTrue(basePage.iconShoppingCart().isDisplayed()),
				() -> validateBadgeShoppingCartIsNotDisplayed(true));
	}
	
	public void validateBadgeShoppingCartIsNotDisplayed(boolean isDisplayed) {
		Assertions.assertEquals(isDisplayed, basePage.badgeShoppingCart().isEmpty());
	}
	
	public void validateExpectedNumberOfProductsInCart(int number) {
		Assertions.assertEquals(number, Integer.parseInt(basePage.badgeShoppingCart().getFirst().getText()));
	}
	
	public void validateStaticFooterElements() {
		Assertions.assertAll("Validate presence of static footer elements: ", 
				() -> Assertions.assertTrue(basePage.linkSocialMedia("twitter").isDisplayed()),
				() -> Assertions.assertEquals("https://twitter.com/saucelabs",basePage.linkSocialMedia("twitter").getAttribute("href")),
				() -> Assertions.assertTrue(basePage.linkSocialMedia("facebook").isDisplayed()),
				() -> Assertions.assertEquals("https://www.facebook.com/saucelabs",basePage.linkSocialMedia("facebook").getAttribute("href")),
				() -> Assertions.assertTrue(basePage.linkSocialMedia("linkedin").isDisplayed()),
				() -> Assertions.assertEquals("https://www.linkedin.com/company/sauce-labs/",basePage.linkSocialMedia("linkedin").getAttribute("href")),
				() -> Assertions.assertEquals("© "+Year.now().getValue()+" Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy", basePage.txtFooterCopyright().getText()));
	}
	
}
