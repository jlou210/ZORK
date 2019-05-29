package com.bayviewglen.zork;

public class LeafletHint extends Tool {
	public LeafletHint(String name, int weight, String description) {
		super(name, weight, description);
	}
	
	public String message() {
		return "Search for a hidden treasure where green life is created.";
	}

}