package com.bayviewglen.zork;

public class Pie extends Food {
	public Pie(String name, int weight, String description) {
		super(name, weight, description);
	}

	public String sound() {
		return "Om nom! Om nom!";
	}
	
}

