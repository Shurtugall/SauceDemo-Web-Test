package com.github.Shurtugall.SauceDemoWebTest.test.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.Shurtugall.SauceDemoWebTest.task.login.LoginTask;
import com.github.Shurtugall.SauceDemoWebTest.test.base.BaseTest;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.PASSWORDS;
import com.github.Shurtugall.SauceDemoWebTest.test.utils.USERNAMES;
import com.github.Shurtugall.SauceDemoWebTest.validation.login.LoginValidation;

public class LoginTest extends BaseTest{

	private LoginTask loginTask;
	private LoginValidation loginValidation;
	
	public RemoteWebDriver driver;
	
	@BeforeEach
	public void instanceTasks() {
		driver = (RemoteWebDriver) createAcess();
		loginTask = new LoginTask(driver);
		loginValidation = new LoginValidation(driver);
	}
	
	@Test
	@DisplayName("Login with the StandardUser")
	public void testLoginWithStandardUser() {
		loginTask.loginWithUser(USERNAMES.STANDARD.getUsername(), PASSWORDS.MAIN.getPassword());
	}
	
	@Tag("Regression")
	@Test
	@DisplayName("Attempt to login without filling in the fields")
	public void testLoginWithWrongCredentials() {
		loginValidation.validateStaticElementsOnTheScreen();
		//Without filling in any field
		loginTask.clickOnLoginButtonExpectingSomeError();
		loginValidation.validateErrorUsernameRequired();
		loginTask.clickOnButtonToCloseErrorMessages();
		
		//Filling in only the username field
		String wrongUsername = "username";
		loginTask.fillUsernameInputWith(wrongUsername);
		loginTask.clickOnLoginButtonExpectingSomeError();
		loginValidation.validateErrorPasswordRequired();
		loginTask.clickOnButtonToCloseErrorMessages();
		
		loginTask.clearUsernameAndPassordFields();
		
		//Filling both fields with invalid data
		String wrongPassword = "password";
		loginTask.fillUsernameInputWith(wrongUsername);
		loginTask.fillPasswordInputWith(wrongPassword);
		loginTask.clickOnLoginButtonExpectingSomeError();
		loginValidation.validateErrorWrongUsernameOrPassword();
	}
	
	
	@AfterEach
	public void quitBrowser() {
		driver.quit();
	}
}
