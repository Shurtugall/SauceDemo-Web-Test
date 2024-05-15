package com.github.Shurtugall.SauceDemoWebTest.task.login;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.home.InventoryHomePage;
import com.github.Shurtugall.SauceDemoWebTest.page.login.LoginPage;
import com.github.Shurtugall.SauceDemoWebTest.task.base.BaseTask;

public class LoginTask extends BaseTask{

	private LoginPage loginPage;
	private InventoryHomePage inventoryHomePage;
	
	public LoginTask(RemoteWebDriver driver) {
		super(driver);
		loginPage = new LoginPage(driver);
		inventoryHomePage = new InventoryHomePage(driver);
	}
	
	public void fillUsernameInputWith(String username) {
		loginPage.inputUsername().sendKeys(username);
	}
	
	public void fillPasswordInputWith(String password) {
		loginPage.inputPassword().sendKeys(password);
	}
	
	public void clearUsernameAndPassordFields() {
		loginPage.inputUsername().clear();
		loginPage.inputPassword().clear();
	}
	
	public void clickOnLoginButtonWithFieldFilledCorrectly() {
		loginPage.btnLogin().click();
		waitForElement(inventoryHomePage.iconShoppingCart());
	}
	
	public void clickOnLoginButtonExpectingSomeError() {
		loginPage.btnLogin().click();
		waitForElement(loginPage.btnCloseCardError());
	}
	
	public void clickOnButtonToCloseErrorMessages() {
		loginPage.btnCloseCardError().click();
	}
	
	public void loginWithUser(String user, String password) {
		fillUsernameInputWith(user);
		fillPasswordInputWith(password);
		clickOnLoginButtonWithFieldFilledCorrectly();
	}
	

}
