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

	public Item() {
	}

	static HashMap<String, Item> useless = new HashMap<String, Item>();
	static HashMap<String, Item> food = new HashMap<String, Item>();
	static HashMap<String, Item> drink = new HashMap<String, Item>();
	static HashMap<String, Item> tools = new HashMap<String, Item>();
	
	public static final Item flower = new Item("flower", 5, "You picked up a sunflower. The pollen is making your nose itchy. I'm not sure it's useful...");
	public static final Item treeBranch = new Item("tree branch", 10, "You picked up a tree branch. It's long and pointy, but I don't think it's very useful.");
	public static final Item sand = new Item("sand", 5, "You picked up some sand. Ahh...I wish I was at the beach right now.");
	public static final Item pillow = new Item("pillow", 10, "You picked up a pillow. It's so soft and fluffy like a marshmallow.");
	public static final Item toyTruck = new Item("toy truck", 5, "You picked up a truck. Vroom! Vroom!");
	public static final Item clothes = new Item("clothes", 10, "You picked up some clothes, but the outfit you are wearing is fine."); 
	public static final Item dirt = new Item("dirt", 5, "You picked up some dirt. I don't know what you can do with this."); 
	
	public static final Food empanada = new Empanada("empanada", 5, "You picked up an empanada. Muy deliciosa!");
	public static final Food pie = new Pie("pie", 10, "You picked up a pie. Is it apple just like how grandma makes it?");
	public static final Food iceCream = new IceCream("ice cream", 5, "You picked up ice cream. Quick! Eat it before it melts!");
	public static final Food cookies = new Cookies("cookies", 5, "You picked up some cookies. Smells super good! I think they're homemade.");
	public static final Food apple = new Apple("apple", 5, "You picked up an apple. Hopefully it's not poisonous.");
	public static final Food donuts = new Donuts("donuts", 5, "You picked up some donuts. Or if you're Canadian, weirdly shaped timbits.");
	public static final Food cake = new Cake("cake", 20, "You picked up a 10 tier funfetti cake! It looks AMAZING!!! Eat this to win the game! Time to celebrate!");
	
	public static final Drink glassOfWater = new GlassOfWater("glass of water", 5, "You picked up a glass of water. Gotta stay hydrated!"); 
	public static final Drink glassOfMilk = new GlassOfMilk("glass of milk", 5, "You picked up a glass of milk. Gotta make your bones strong!"); 
	
	public static final Map map = new Map("map", 1, "You picked up a map. This will help you navigate and teleporate back to the treehouse.");
	public static final Flashlight flashlight = new Flashlight("flashlight", 5, "You picked up a flashlight. This will help you see in the dark."); 
	public static final Glasses glasses = new Glasses("glasses", 5, "You picked up a pair of glasses. This will help with your blurry vision."); 
	public static final Book book = new Book("book", 5, "You picked up a book. You can read it."); 
	public static final LeafletHint leafletHint = new LeafletHint("leaflet hint", 1, "You picked up a leaflet hint. Hmm..."); 
	public static final LibraryCard libraryCard = new LibraryCard("library card", 1, "You picked up a library card. Having fun isn't hard."); 
	public static final Backpack backpack = new Backpack("backpack", 1, "You picked up a backpack. You can use it hold all your items!"); 
	public static final ShedKey shedKey = new ShedKey("shed key", 1, "You picked up a key. I wonder where it can be used."); 
	public static final AntFarm antFarm = new AntFarm("ant farm", 5, "You picked up an ant-farm. Looks like something Max would play with."); 
	public static final Trophy trophy1 = new Trophy("trophy 1", 5, "You picked up a trophy. Yay! You got another trophy!"); 
	public static final Trophy trophy2 = new Trophy("trophy 2", 5, "You picked up a trophy. Yay! You got another trophy!"); 
	public static final Trophy trophy3 = new Trophy("trophy 3", 5, "You picked up a trophy. Yay! You got another trophy!"); 
	public static final Trophy trophy4 = new Trophy("trophy 4", 5, "You picked up a trophy. Yay! You got another trophy!"); 
	public static final BookshelfKey bookshelfKey = new BookshelfKey("bookshelf key", 1, "You picked up a key. I wonder where it can be used."); 
	

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
		food.put("donuts", donuts); // mickey
		
		drink.put("glass of water", glassOfWater); 
		drink.put("glass of milk", glassOfWater); 

		tools.put("flashlight", flashlight); // max
		tools.put("library card", libraryCard); // arthur
		tools.put("glasses", glasses); // arthur
		tools.put("book", book); // arthur
		tools.put("map", map); //dora 
		tools.put("leaflet hint", leafletHint);
		tools.put("backpack", backpack); 
		tools.put("shed key", shedKey); 
		tools.put("trophy 1", trophy1); 
		tools.put("trophy 2", trophy2); 
		tools.put("trophy 3", trophy3); 
		tools.put("trophy 4", trophy4); 
		tools.put("bookshelf key", bookshelfKey); 
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
