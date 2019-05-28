package com.bayviewglen.zork;

public class Cake extends Food {
	public Cake(String name, int weight, String description) {
		super(name, weight, description);
	}

	public String sound() {
		return "Yummy in my tummy!";
	}
	
}