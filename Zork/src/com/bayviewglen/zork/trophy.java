package com.bayviewglen.zork;

public class trophy extends Tool {
	public trophy(String name, int weight, String description) {
		super(name, weight, description);
	}


	public String message() {
		return "A trophy!";
	}
}
