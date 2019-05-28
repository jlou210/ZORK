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
	
	Item flower = new Item("flower", 5, "You picked up a sunflower. The pollen is making your nose itchy. I'm not sure it's useful...");
	Item treeBranch = new Item("tree branch", 10, "You picked up a tree branch. It's long and pointy, but I don't think it's very useful.");
	Item sand = new Item("sand", 5, "You picked up some sand. Ahh...I wish I was at the beach right now.");
	Item pillow = new Item("pillow", 10, "You picked up a pillow. It's so soft and fluffy like a marshmallow.");
	Item toyTruck = new Item("toy truck", 5, "You picked up a truck. Vroom! Vroom!");
	
	Empanada empanada = new Empanada("empanada", 5, "You picked up an empanada. Muy deliciosa!");
	Pie pie = new Pie("pie", 10, "You picked up a pie. Is it apple just like how grandma makes it?");
	IceCream iceCream = new IceCream("ice cream", 5, "You picked up ice cream. Quick! Eat it before it melts!");
	Cookies cookies = new Cookies("cookies", 5, "You picked up some cookies. Smells super good! I think they're homemade.");
	Apple apple = new Apple("apple", 5, "You picked up an apple. Hopefully it's not poisonous.");
	Cake cake = new Cake("cake", 20, "You picked up a 10 tier funfetti cake! It looks AMAZING!!! Eat this to win the game! Time to celebrate!");
	
	Map map = new Map("map", 1, "You picked up a map. This will help you navigate and teleporate back to the treehouse.");
	Flashlight flashlight = new Flashlight("flashlight", 5, "You picked up a flashlight. This will help you see in the dark."); 
	Glasses glasses = new Glasses("glasses", 5, "You picked up a pair of glasses. This will help with your blurry vision."); 
	Book book = new Book("book", 5, "You picked up a book. You can read it."); 
	
	public void initializeItems() {

		useless.put(flower, 5); // dora
		useless.put("tree branch", 10); // treehouse
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
		tools.put("glasses", 5); // arthur
		tools.put("rope", 20); // mickey
		tools.put("book", 5); // mickey
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
	
	public String getItemDescription(Item item) {
		return item.description;
	}
	
	

}
