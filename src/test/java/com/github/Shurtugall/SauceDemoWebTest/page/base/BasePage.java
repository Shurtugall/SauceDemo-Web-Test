package com.github.Shurtugall.SauceDemoWebTest.page.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage {

	protected RemoteWebDriver driver;

	public BasePage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement body() {
		return driver.findElement(By.cssSelector("body"));
	}
	
	// ---- Header elements ----
	
	public WebElement pageTitle() {
		return driver.findElement(By.className("app_logo"));
	}
	
	public WebElement burguerMenu() {
		return driver.findElement(By.id("react-burger-menu-btn"));
	}
	
	public WebElement iconShoppingCart() {
		return driver.findElement(By.id("shopping_cart_container"));
	}
	
	public List<WebElement> badgeShoppingCart() {
		return driver.findElements(By.className("shopping_cart_badge"));
	}
	
	// ---- Footer elements ----
	
	/**
	 * @param name -> twitter
	 * @param name -> facebook
	 * @param name -> linkedin
	 */
	public WebElement linkSocialMedia(String name) {
		return driver.findElement(By.xpath("//li[@class='social_"+name+"']/a"));
	}
	
	public WebElement txtFooterCopyright() {
		return driver.findElement(By.className("footer_copy"));
	}
	
}
