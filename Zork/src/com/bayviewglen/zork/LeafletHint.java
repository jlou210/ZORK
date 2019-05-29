package com.bayviewglen.zork;

public class LeafletHint extends Tool {
	public LeafletHint(String name, int weight, String description) {
		super(name, weight, description);
	}
	
	public String message() {
		return "Search for a hidden gem where you life is created.";
	}

}