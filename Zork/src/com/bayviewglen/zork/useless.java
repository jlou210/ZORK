package com.bayviewglen.zork;

public class useless extends Item {
	public useless(String name, int weight, String description) {
		super(name, weight, description);
	}

	//need method pickUp() that prints out 'you picked up...'
	public void pickUp(Item item, Inventory playerInven){
		System.out.print("You picked up the " + item + ".");
		playerInven.addPlayerInventory(item);
	}
}