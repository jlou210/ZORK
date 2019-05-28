package com.bayviewglen.zork;

import java.util.HashMap;

public class Item {
	
	private String name;
	private int weight;
	private String description;
	
	public Item(String name, int weight, String description) {
		this.name = name;
		this.weight = weight;
		this.description = description;
	}
	HashMap<Item, Integer> useless = new HashMap<Item, Integer>();
	HashMap<Item, Integer> food = new HashMap<Item, Integer>();
	HashMap<Item, Integer> tools = new HashMap<Item, Integer>();
	
	Item flower = new Item("flower", 5, "You picked up a blue flower. It smells pretty good, but I'm not sure if it's useful...");
	
	public void initializeItems() {

		useless.put(flower, 5); // dora
		useless.put("branch", 10); // treehouse
		useless.put("sand", 5); // backyard
		useless.put("pillow", 10); // harry
		useless.put("toy truck", 5); // max


		food.put("empanada", 5); // dora
		food.put("pie", 10); // max
		food.put("ice cream", 5); // arthur
		food.put("cookies", 5); //backyard
		food.put("apple", 5); //treehouse
		food.put("cake", 20); // mickey


		tools.put("shovel", 15); // backyard
		tools.put("flashlight", 5); // max
		tools.put("library card", 3); // arthur
		tools.put("rope", 20); // mickey
		tools.put("map", 1); //dora 
	}
	
	public void putItemInRoom() {
		
	}



	/*public void addItem(Item i) {
		useless.put(i, i.getWeight());
	}*/
	
	public String getItemName(Item i) {
		return name;
	}
	
	/*public boolean isValidItem() {
		
	}*/

	/*public String getUselessWeight(Item i) {
	    	 if(i.length < useless.size() && useless.size() >=0)
	    	        return useless.get(i).toString();
	    	    else
	    	        return "item does not exist";
	}*/
	
	public int getWeight() {
		return weight;
	}
	
	public String getItemDescription() {
		return description;
	}
	
	
	
}
