package com.bayviewglen.zork;

public class Max implements Character{
	String description = "You found it! Here's an amazing and shiny trophy I made for you!";
	public void speakOne(){
		System.out.println("Hi. Hi. I can't seem to find my ant farm. Can you find it? I'll give you a prize in return.");	//speech pattern when glasses are not given
	}
	
	public void speak() {
		System.out.println(description);	//after he gives glasses
	}
	
	public boolean isGlasses(Inventory playerInven ) {
		if(playerInven.checkPlayerInventory(Item.tools.get("ant farm"))){
			return true;
		}
		return false;
	}
}
