package com.bayviewglen.zork;

import java.util.HashMap;

public class Item {
	
	public String name;
	public int weight;
	public static String description;
	
	public Item(String name, int weight, String description) {
		this.name = name;
		this.weight = weight;
		this.description = description;
		
	}

	static HashMap<String, Item> useless = new HashMap<String, Item>();
	static HashMap<String, Item> food = new HashMap<String, Item>();
	static HashMap<String, Item> tools = new HashMap<String, Item>();
	
	static Item flower = new Item("flower", 5, "You picked up a sunflower. The pollen is making your nose itchy. I'm not sure it's useful...");
	static Item treeBranch = new Item("tree branch", 10, "You picked up a tree branch. It's long and pointy, but I don't think it's very useful.");
	static Item sand = new Item("sand", 5, "You picked up some sand. Ahh...I wish I was at the beach right now.");
	static Item pillow = new Item("pillow", 10, "You picked up a pillow. It's so soft and fluffy like a marshmallow.");
	static Item toyTruck = new Item("toy truck", 5, "You picked up a truck. Vroom! Vroom!");
	static Item clothes = new Item("clothes", 10, "You picked up some clothes, but the outfit you are wearing is fine."); 
	
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
	static Backpack backpack = new Backpack("backpack", 1, "You picked up a backpack. You can use it hold all your items!"); 
	
	
	public static void initializeItems() {

		useless.put("flower", flower); // dora
		useless.put("tree branch", treeBranch); // treehouse
		useless.put("sand", sand); // backyard
		useless.put("pillow", pillow); // harry
		useless.put("toy truck", toyTruck); // max
		useless.put("clothes", clothes); 


		food.put("empanada", empanada); // dora
		food.put("pie", pie); // max
		food.put("ice cream", iceCream); // arthur
		food.put("cookies", cookies); //backyard
		food.put("apple", apple); //treehouse
		food.put("cake", cake); // mickey


		tools.put("flashlight", flashlight); // max
		tools.put("library card", libraryCard); // arthur
		tools.put("glasses", glasses); // arthur
		tools.put("book", book); // arthur
		tools.put("map", map); //dora 
		tools.put("leaflet hint", leafletHint);
		tools.put("backpack", backpack); 
		
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
