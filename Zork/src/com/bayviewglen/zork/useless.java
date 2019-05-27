package com.bayviewglen.zork;

public class useless {
	//need method pickUp() that prints out 'you picked up...'
	public void pickUp(Items item, PlayerInventory playerInven){
		System.out.print("You picked up " + item);
		playerInven.addPlayerInven(item);
	}
}