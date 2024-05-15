package com.github.Shurtugall.SauceDemoWebTest.test.utils;

public enum PASSWORDS {
	MAIN("secret_sauce");
	
	public String passwordValue;
	
	PASSWORDS(String password) {
		passwordValue = password;
	}
	
	public String getPassword() {
		return passwordValue;
	}
}
