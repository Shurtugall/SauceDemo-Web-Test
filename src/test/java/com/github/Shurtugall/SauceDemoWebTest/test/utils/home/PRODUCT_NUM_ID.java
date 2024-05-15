package com.github.Shurtugall.SauceDemoWebTest.test.utils.home;

public enum PRODUCT_NUM_ID {
	BACKPACK("4"),
	BIKE_LIGHT("0"),
	BOLT_T_SHIRT("1"),
	FLEECE_JACKET("5"),
	ONESIE("2"),
	T_SHIRT_RED("3");
	
	public String idNum;
	
	PRODUCT_NUM_ID(String idNum){
		this.idNum = idNum;
	}
	
	public String getProductId() {
		return idNum;
	}
}
