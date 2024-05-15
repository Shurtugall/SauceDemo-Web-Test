package com.github.Shurtugall.SauceDemoWebTest.validation.utils;

public enum PRODUCT_DESCRIPTION {
	BACKPACK("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."),
	BIKE_LIGHT("A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."),
	BOLT_T_SHIRT("Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."),
	FLEECE_JACKET("It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."),
	ONESIE("Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."),
	T_SHIRT_RED("This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.");
	
	public String description;
	
	PRODUCT_DESCRIPTION(String description){
		this.description = description;
	}
	
	public String getProductDescription() {
		return description;
	}
}
