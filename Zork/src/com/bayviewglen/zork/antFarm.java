package com.bayviewglen.zork;

public class antFarm extends Tool {
	public antFarm(String name, int weight, String description) {
		super(name, weight, description);
	}
	

	public String message() {
		return "An Ant Farm!";
	}

}