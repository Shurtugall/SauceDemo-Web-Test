package com.github.Shurtugall.SauceDemoWebTest.test.utils.home;

public enum PRODUCT_TXT_ID {
	BACKPACK("sauce-labs-backpack"),
	BIKE_LIGHT("sauce-labs-bike-light"),
	BOLT_T_SHIRT("sauce-labs-bolt-t-shirt"),
	FLEECE_JACKET("sauce-labs-fleece-jacket"),
	ONESIE("sauce-labs-onesie"),
	T_SHIRT_RED("test.allthethings()-t-shirt-(red)");
	
	String idTxt;
	
	PRODUCT_TXT_ID(String idTxt){
		this.idTxt = idTxt;
	}
	
	public String getProductId() {
		return idTxt;
	}
	
}
