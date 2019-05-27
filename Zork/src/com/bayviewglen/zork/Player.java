package com.bayviewglen.zork;

public class Player {
	PlayerInventory inventory = new PlayerInventory(0);
	int inventoryWeight = 0;
	public Player(int invenWeight) {
		inventory = new PlayerInventory(invenWeight);
	}
	
	//eat method
	
	public String eat(food food) {
		System.out.println("you just ate " + food + " : " + food.getSound());
		//need if statement to check if it's in their inventory
			//remove the food from the player inventory
		//else: check if it's in the room, remove from room inventory
		
	}
	
	//take
	
	//use
	
	//drink
	
	
	
	
}
