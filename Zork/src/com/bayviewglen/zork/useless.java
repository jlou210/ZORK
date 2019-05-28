package com.bayviewglen.zork;

public class useless {
	//need method pickUp() that prints out 'you picked up...'
	public void pickUp(Item item, Inventory playerInven){
		System.out.print("You picked up the " + item + ".");
		playerInven.addPlayerInven(item);
	}
}