package com.bayviewglen.zork;

public abstract class Food extends Item{
	public Food(String name, int weight, String description) {
		super(name, weight, description);
	}

	public abstract String sound();
}
