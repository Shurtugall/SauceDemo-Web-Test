package com.github.Shurtugall.SauceDemoWebTest.task.utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTask {

	protected RemoteWebDriver driver;
	
	public WaitTask(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForElement(WebElement el) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(d -> el.isDisplayed());
	}
}
