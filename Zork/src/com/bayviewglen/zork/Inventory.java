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



	public static void initializeRooms(Game game, Item item) {
		
		//dora 
		Inventory inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.map, "HOUSE_ENTRANCE", game);
		game.getMasterMap().get("HOUSE_ENTRANCE").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.pie, "DINING_ROOM", game);
		inv.addRoomInventory(Item.iceCream, "DINING_ROOM", game);
		game.getMasterMap().get("DINING_ROOM").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.glassOfWater, "KITCHEN", game);
		game.getMasterMap().get("KITCHEN").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.backpack, "LIVING_ROOM", game);
		inv.addRoomInventory(Item.clothes, "LIVING_ROOM", game);
		inv.addRoomInventory(Item.leafletHint, "LIVING_ROOM", game);
		game.getMasterMap().get("LIVING_ROOM").setInventory(inv);
		
		//arthur
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.glasses, "ARTHUR'S_ROOM", game);
		game.getMasterMap().get("ARTHUR'S_ROOM").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.iceCream, "MR.RATBURN'S_CLASS", game);
		game.getMasterMap().get("MR.RATBURN'S_CLASS").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("STUDY_ROOM").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.bookshelfKey, "LIBRARY", game);
		game.getMasterMap().get("LIBRARY").setInventory(inv);
	
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.flashlight, "SECRET_ROOM", game);
		inv.addRoomInventory(Item.trophy1, "SECRET_ROOM", game);
		game.getMasterMap().get("SECRET_ROOM").setInventory(inv);
		
		//backyardigans
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.dirt, "MINI_GARDEN", game);
		inv.addRoomInventory(Item.libraryCard, "MINI_GARDEN", game);
		inv.addRoomInventory(Item.treeBranch, "MINI_GARDEN", game);
		inv.addRoomInventory(Item.flower, "MINI_GARDEN", game);
		game.getMasterMap().get("MINI_GARDEN").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.shedKey, "BACK_STORAGE_ROOM", game);
		game.getMasterMap().get("BACK_STORAGE_ROOM").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.sand, "BACKYARD", game);
		inv.addRoomInventory(Item.glassOfMilk, "BACKYARD", game);
		game.getMasterMap().get("BACKYARD").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.trophy3, "SMALL_SHED", game);
		game.getMasterMap().get("SMALL_SHED").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("STORAGE_ROOM").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("BACKYARDIGAN'S_HALLWAY").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("SMALL_OPENING").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("HOUSE").setInventory(inv);
		
		//max and ruby
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.antFarm, "MAX'S_ROOM", game);
		inv.addRoomInventory(Item.empanada, "MAX'S_ROOM", game);
		inv.addRoomInventory(Item.toyTruck, "MAX'S_ROOM", game);
		inv.addRoomInventory(Item.trophy2, "MAX'S_ROOM", game);
		game.getMasterMap().get("MAX'S_ROOM").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.pillow, "RUBY'S_ROOM", game);
		game.getMasterMap().get("RUBY'S_ROOM").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("RUBY'S_KITCHEN").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("GRANDMA'S_HOUSE").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("ROOM").setInventory(inv);
		
		//treehouse
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.cookies, "PANTRY", game);
		inv.addRoomInventory(Item.apple, "PANTRY", game);
		game.getMasterMap().get("PANTRY").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("TROPHY_ROOM").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("MAIN_ROOM").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("ROOM2").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("ROOM3").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.trophy4, "ROOM4", game);
		game.getMasterMap().get("ROOM4").setInventory(inv);
		
		//mickey mouse
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.cake, "WIN_ROOM", game);
		game.getMasterMap().get("WIN_ROOM").setInventory(inv);
		

		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("MICKEY'S_ROOM").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("MINNIE'S_ROOM").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("DONALD'S_ROOM").setInventory(inv);

		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("GOOFY'S_GARDEN").setInventory(inv);

		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("PLUTO'S_DOG_HOUSE").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("OUTSIDE").setInventory(inv);
		

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
		Room r = hashmap.get(room);	//room is null
		Inventory inv = r.getInventory();	//null pointer
		inv.getItems().add(item);	//null pointer
	}
	

	public ArrayList<Item> getItems (){
		return items;
	}

}
