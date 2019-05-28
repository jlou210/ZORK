package com.bayviewglen.zork;

public class Empanada extends Food {
	public Empanada(String name, int weight, String description) {
		super(name, weight, description);
	}

	public String sound() {
		return "Chomp! Chomp!";
	}
	
}


