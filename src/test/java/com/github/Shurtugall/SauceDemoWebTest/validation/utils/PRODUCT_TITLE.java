package com.github.Shurtugall.SauceDemoWebTest.validation.utils;

public enum PRODUCT_TITLE {
	BACKPACK("Sauce Labs Backpack"),
	BIKE_LIGHT("Sauce Labs Bike Light"),
	BOLT_T_SHIRT("Sauce Labs Bolt T-Shirt"),
	FLEECE_JACKET("Sauce Labs Fleece Jacket"),
	ONESIE("Sauce Labs Onesie"),
	T_SHIRT_RED("Test.allTheThings() T-Shirt (Red)");
	
	public String title;
	
	PRODUCT_TITLE(String title){
		this.title = title;
	}
	
	public String getProductTitle() {
		return title;
	}
}
