package com.bayviewglen.zork;

public class Donuts extends Food {
	public Donuts(String name, int weight, String description) {
		super(name, weight, description);
	}

	public String sound() {
		return "Nom! Nom!";
	}
	
}