package com.bayviewglen.zork;

public class Arthur implements Character{
	String description = "Thank you for my glasses, do you know how to get into the library? Looks like we need some sort of library card.";
	public void speakOne(){
		System.out.println("I can't seem to find my glasses. Can you find it? Hint: give him the glasses.");	//speech pattern when glasses are not given
	}
	
	public void speak() {
		System.out.println(description);	//after he gives glasses
	}
	
	public boolean isGlasses(Inventory playerInven ) {
		if(playerInven.checkPlayerInventory(Item.tools.get("glasses"))){
			return true;
		}
		return false;
	}
}
