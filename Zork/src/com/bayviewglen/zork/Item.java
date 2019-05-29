package com.bayviewglen.zork;

import java.util.HashMap;

public class Item {
	
	public String name;
	public int weight;
	public String description;
	
	public Item(String name, int weight, String description) {
		this.name = name;
		this.weight = weight;
		this.description = description;
		
	}

	static HashMap<Item, Integer> useless = new HashMap<Item, Integer>();
	static HashMap<Item, Integer> food = new HashMap<Item, Integer>();
	static HashMap<Item, Integer> tools = new HashMap<Item, Integer>();
	
	static Item flower = new Item("flower", 5, "You picked up a sunflower. The pollen is making your nose itchy. I'm not sure it's useful...");
	static Item treeBranch = new Item("tree branch", 10, "You picked up a tree branch. It's long and pointy, but I don't think it's very useful.");
	static Item sand = new Item("sand", 5, "You picked up some sand. Ahh...I wish I was at the beach right now.");
	static Item pillow = new Item("pillow", 10, "You picked up a pillow. It's so soft and fluffy like a marshmallow.");
	static Item toyTruck = new Item("toy truck", 5, "You picked up a truck. Vroom! Vroom!");
	
	static Empanada empanada = new Empanada("empanada", 5, "You picked up an empanada. Muy deliciosa!");
	static Pie pie = new Pie("pie", 10, "You picked up a pie. Is it apple just like how grandma makes it?");
	static IceCream iceCream = new IceCream("ice cream", 5, "You picked up ice cream. Quick! Eat it before it melts!");
	static Cookies cookies = new Cookies("cookies", 5, "You picked up some cookies. Smells super good! I think they're homemade.");
	static Apple apple = new Apple("apple", 5, "You picked up an apple. Hopefully it's not poisonous.");
	static Cake cake = new Cake("cake", 20, "You picked up a 10 tier funfetti cake! It looks AMAZING!!! Eat this to win the game! Time to celebrate!");
	
	static Map map = new Map("map", 1, "You picked up a map. This will help you navigate and teleporate back to the treehouse.");
	static Flashlight flashlight = new Flashlight("flashlight", 5, "You picked up a flashlight. This will help you see in the dark."); 
	static Glasses glasses = new Glasses("glasses", 5, "You picked up a pair of glasses. This will help with your blurry vision."); 
	static Book book = new Book("book", 5, "You picked up a book. You can read it."); 
	static LeafletHint leafletHint = new LeafletHint("leaflet hint", 1, "You picked up a leaflet hint. Hmm..."); 
	static LibraryCard libraryCard = new LibraryCard("library card", 1, "You picked up a library card. Having fun isn't hard."); 
	
	public static void initializeItems() {

		useless.put(flower, 5); // dora
		useless.put(treeBranch, 10); // treehouse
		useless.put(sand, 5); // backyard
		useless.put(pillow, 10); // harry
		useless.put(toyTruck, 5); // max


		food.put(empanada, 5); // dora
		food.put(pie, 10); // max
		food.put(iceCream, 5); // arthur
		food.put(cookies, 5); //backyard
		food.put(apple, 5); //treehouse
		food.put(cake, 20); // mickey


		tools.put(flashlight, 5); // max
		tools.put(libraryCard, 3); // arthur
		tools.put(glasses, 5); // arthur
		tools.put(book, 5); // arthur
		tools.put(map, 1); //dora 
		tools.put(leafletHint, 1);
		
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
