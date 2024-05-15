package com.github.Shurtugall.SauceDemoWebTest.page.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.base.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(RemoteWebDriver driver) {
		super(driver);
	}
	
	// ---- Title ----
	
	public WebElement pageTitle() {
		return driver.findElement(By.className("login_logo"));
	}
	// ---- Login and credentials ----
	
	public WebElement inputUsername() {
		return driver.findElement(By.id("user-name"));
	}
	
	public WebElement svgErrorInputUsername() {
		return driver.findElement(By.xpath("//input[@id='user-name']/following-sibling::*"));
	}
	
	public WebElement inputPassword() {
		return driver.findElement(By.id("password"));
	}

	public WebElement svgErrorInputPassword() {
		return driver.findElement(By.xpath("//input[@id='password']/following-sibling::*"));
	}
	
	public WebElement txtCardError() {
		return driver.findElement(By.xpath("//button[@class='error-button']/.."));
	}
	
	public WebElement btnCloseCardError() {
		return driver.findElement(By.xpath("//button[@class='error-button']"));
	}
	
	public WebElement btnLogin(){
		return driver.findElement(By.id("login-button"));
	}

	// ---- Accepted usernames and passwords ----
	
	public WebElement acceptedUsernamesTitle() {
		return driver.findElement(By.xpath("//*[@id=\"login_credentials\"]/h4"));
	}

	public WebElement txtUsernames() {
		return driver.findElement(By.xpath("//*[@id=\"login_credentials\"]"));
	}
	
	public WebElement acceptedPasswordTitle() {
		return driver.findElement(By.xpath("//div[@class='login_password']/h4"));
	}

	public WebElement txtPassword() {
		return driver.findElement(By.xpath("//div[@class='login_password']"));
	}
}
