package com.bayviewglen.zork;

public class GlassOfWater extends Drink {
	public GlassOfWater(String name, int weight, String description) {
		super(name, weight, description);
	}

	public String sound() {
		return "Slurp! Slurp!";
	}
	
}


