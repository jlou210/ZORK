package com.bayviewglen.zork;

public class IceCream extends Food {
	public IceCream(String name, int weight, String description) {
		super(name, weight, description);
	}

	public String sound() {
		return "Lickity lick! This icecream is slick!";
	}
	
}

