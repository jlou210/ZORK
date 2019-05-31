package com.bayviewglen.zork;

public class GlassOfMilk extends Drink {
	public GlassOfMilk(String name, int weight, String description) {
		super(name, weight, description);
	}

	public String sound() {
		return "Sip! Sip!";
	}
	
}
