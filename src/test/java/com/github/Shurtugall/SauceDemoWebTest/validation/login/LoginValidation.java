package com.github.Shurtugall.SauceDemoWebTest.validation.login;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.page.login.LoginPage;
import com.github.Shurtugall.SauceDemoWebTest.validation.base.BaseValidation;

public class LoginValidation extends BaseValidation{

	private LoginPage loginPage;
	
	public LoginValidation(RemoteWebDriver driver) {
		super(driver);
		loginPage = new LoginPage(driver);
	}
	
	public void validateStaticElementsOnTheScreen() {
		Assertions.assertAll("Validate of static page elements: ", 
				() -> Assertions.assertEquals("Swag Labs", loginPage.pageTitle().getText()),
				
				() -> Assertions.assertEquals("Username",loginPage.inputUsername().getAttribute("placeholder")),
				() -> Assertions.assertEquals("Password",loginPage.inputPassword().getAttribute("placeholder")),
				() -> Assertions.assertEquals("Login",loginPage.btnLogin().getAttribute("value")),
				
				() -> Assertions.assertEquals("Accepted usernames are:",loginPage.acceptedUsernamesTitle().getText()),
				() -> Assertions.assertEquals("standard_user\n"
								+ "locked_out_user\n"
								+ "problem_user\n"
								+ "performance_glitch_user\n"
								+ "error_user\n"
								+ "visual_user", loginPage.txtUsernames().getText().replace("Accepted usernames are:\n", "")),
				() -> Assertions.assertEquals("Password for all users:",loginPage.acceptedPasswordTitle().getText()),
				() -> Assertions.assertEquals("secret_sauce",loginPage.txtPassword().getText().replace("Password for all users:\n", "")));
	}
	
	public void validateElementsShownErrorCredentials() {
		Assertions.assertAll("Validate the elements that appears when the user tries to login with wrong credentials: ", 
				() -> Assertions.assertTrue(loginPage.svgErrorInputUsername().isDisplayed()),
				() -> Assertions.assertTrue(loginPage.svgErrorInputPassword().isDisplayed()),
				() -> Assertions.assertTrue(loginPage.btnCloseCardError().isDisplayed()));
	}
	
	public void validateErrorUsernameRequired() {
		Assertions.assertEquals("Epic sadface: Username is required", loginPage.txtCardError().getText());
		validateElementsShownErrorCredentials();
	}
	
	public void validateErrorPasswordRequired() {
		Assertions.assertEquals("Epic sadface: Password is required", loginPage.txtCardError().getText());
		validateElementsShownErrorCredentials();
	}
	
	public void validateErrorWrongUsernameOrPassword() {
		Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.txtCardError().getText());
		validateElementsShownErrorCredentials();
	}
	
	

}
