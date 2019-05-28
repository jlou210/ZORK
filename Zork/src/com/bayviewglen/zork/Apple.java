package com.bayviewglen.zork;

public class Apple extends Food {
	public Apple(String name, int weight, String description) {
		super(name, weight, description);
	}

	public String sound() {
		return "Crunch! Crunch!";
	}
	
	
}
