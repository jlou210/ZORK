package com.bayviewglen.zork;

public class Cookies extends Food {
	public Cookies(String name, int weight, String description) {
		super(name, weight, description);
	}

	public String sound() {
		return "Munch! Munch!";
	}
	
}

