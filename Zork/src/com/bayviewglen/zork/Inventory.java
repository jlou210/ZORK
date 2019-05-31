package com.bayviewglen.zork;

import java.util.*;

public class Inventory {

	private ArrayList<Item> items;
	private int maxWeight;
	private int currentPlayerWeight = 0;

	// two constructors
	public Inventory(int maxWeight) {
		items = new ArrayList<Item>();
		this.maxWeight = maxWeight;
	}

	public Inventory(int maxWeight, int setWeight) {
		this.maxWeight = maxWeight;
		currentPlayerWeight = setWeight;
	}

	public double getPlayerWeight() {
		return currentPlayerWeight;
	}

	// ERICA: You need to add the items class and the roomInventory class.

	public void addPlayerInventory(Item item) {
		if (getPlayerWeight() + item.getWeight() <= maxWeight) { // getWeight has to be implemented in the items class
			items.add(item);
			// NEED TO ALSO REMOVE ITEM FROM THE ROOM INVENTORY. LUCK.
		} else {
			System.out.print("There is no more space left in your inventory.");
			System.out.print("If you picked this up now, your bag would be too heavy for you to walk.");
			System.out.println("Either drop something in your inventory or find another bag to expand your inventory.");
		}

	}

	public boolean checkPlayerInventory(Item item) {
		for (Item i : items) {
			if (i == item) {
				return true;
			}
		}
		return false;
	}

	public void removePlayerInventory(Item item) {
		boolean isValid = false;

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) == item) {
				items.remove(i);
				isValid = true;
				break;
			}
		}

		if (!isValid) {
			System.out.println("You do not have this item in your inventory.");
		}

	}

	// room inventory stuff
	@SuppressWarnings("unused")
	private int numRooms = 0;
	@SuppressWarnings("unused")
	private int numItems = 0;

	public Inventory(double numRooms, int numItems) {
		this.numRooms = (int) numRooms;
		this.numItems = numItems;

	}



	public static void initializeRooms(Game game) {
		
		//dora 
		Inventory inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.map, "House Entrance", game);
		game.getMasterMap().get("House Entrance").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.pie, "Dining Room", game);
		inv.addRoomInventory(Item.iceCream, "Dining Room", game);
		game.getMasterMap().get("Dining Room").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.glassOfWater, "Kitchen", game);
		game.getMasterMap().get("Kitchen").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.backpack, "Living Room", game);
		inv.addRoomInventory(Item.clothes, "Living Room", game);
		inv.addRoomInventory(Item.leafletHint, "Living Room", game);
		game.getMasterMap().get("Living Room").setInventory(inv);
		
		//arthur
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.glasses, "Arthur's Room", game);
		game.getMasterMap().get("Arthur's Room").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.iceCream, "Mr. Ratburn's Class", game);
		game.getMasterMap().get("Mr.Ratburn's Class").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Study Room").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.BookshelfKey, "Library", game);
		game.getMasterMap().get("Library").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.flashlight, "Secret Room", game);
		inv.addRoomInventory(Item.trophy1, "Secret Room", game);
		game.getMasterMap().get("Secret Room").setInventory(inv);
		
		//backyardigans
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.dirt, "Mini Garden", game);
		inv.addRoomInventory(Item.libraryCard, "Mini Garden", game);
		inv.addRoomInventory(Item.treeBranch, "Mini Garden", game);
		inv.addRoomInventory(Item.flower, "Mini Garden", game);
		game.getMasterMap().get("Mini Garden").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.shedKey, "Back Storage Room", game);
		game.getMasterMap().get("Back Storage Room").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.sand, "Backyard", game);
		inv.addRoomInventory(Item.glassOfMilk, "Backyard", game);
		game.getMasterMap().get("Backyard").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.trophy3, "Small Shed", game);
		game.getMasterMap().get("Small Shed").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Storage Room").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Backyardigan's Hallway").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Small Opening").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("House").setInventory(inv);
		
		//max and ruby
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.antFarm, "Max's Room", game);
		inv.addRoomInventory(Item.empanada, "Max's Room", game);
		inv.addRoomInventory(Item.toyTruck, "Max's Room", game);
		inv.addRoomInventory(Item.trophy2, "Max's Room", game);
		game.getMasterMap().get("Max's Room").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.pillow, "Ruby's Room", game);
		game.getMasterMap().get("Ruby's Room").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Ruby's Kitchen").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Grandma's House").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Room").setInventory(inv);
		
		//treehouse
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.cookies, "Pantry", game);
		inv.addRoomInventory(Item.apple, "Pantry", game);
		game.getMasterMap().get("Pantry").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Trophy Room").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Main Room").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Room2").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Room3").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.trophy4, "Room4", game);
		game.getMasterMap().get("Room4").setInventory(inv);
		
		//mickey mouse
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.cake, "Win Room", game);
		game.getMasterMap().get("Win Room").setInventory(inv);
		

		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Mickey's Room").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Minnie's Room").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Donald's Room").setInventory(inv);

		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Goofy's Garden").setInventory(inv);

		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Pluto's Dog House").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Outside").setInventory(inv);
		

	}

	@SuppressWarnings("unlikely-arg-type")
	public static boolean checkRoomInventory(Item item, Game game) {
		if(game.getMasterMap().get(Game.currentRoom.getRoomName(Game.currentRoom)).getInventory().equals(item)) {
			return true;
		}
		return false;
	}
	

	@SuppressWarnings("unlikely-arg-type")
	public static void removeRoomInventory(Item item, String room, Game game) {

		HashMap<String, Room> hashmap = game.getMasterMap();
		hashmap.remove(item);	//fix later 
		
	}
	


	public void addRoomInventory(Item item, String room, Game game) {
		HashMap<String, Room> hashmap = game.getMasterMap();
		Inventory inv = hashmap.get(room).getInventory();
		((List<Item>) inv).add(item);
	}
}
