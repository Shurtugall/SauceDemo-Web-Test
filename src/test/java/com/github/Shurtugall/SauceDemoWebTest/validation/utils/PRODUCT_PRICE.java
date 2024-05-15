package com.github.Shurtugall.SauceDemoWebTest.validation.utils;

public enum PRODUCT_PRICE {
	BACKPACK(29.99),
	BIKE_LIGHT(9.99),
	BOLT_T_SHIRT(15.99),
	FLEECE_JACKET(49.99),
	ONESIE(7.99),
	T_SHIRT_RED(15.99);
	
	public double price;
	
	PRODUCT_PRICE(double price){
		this.price = price;
	}
	
	public double getProductPrice() {
		return price;
	}
}
