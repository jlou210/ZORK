package com.bayviewglen.zork;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	private static ArrayList<Item> items;
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
	private int numRooms = 0;
	private int numItems = 0;
	private String[][] rooms = new String[numRooms][numItems];

	public Inventory(double numRooms, int numItems) {
		this.numRooms = (int) numRooms;
		this.numItems = numItems;
		rooms = new String[(int) numRooms][numItems];

	}



	public static void initializeRooms(Game game) {
		//dora 
		Inventory inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.map);
		game.getMasterMap().get("House Entrance").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.pie);
		inv.addRoomInventory(Item.iceCream);
		game.getMasterMap().get("Dining Room").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Kitchen").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.backpack);
		inv.addRoomInventory(Item.clothes);
		inv.addRoomInventory(Item.leafletHint);
		game.getMasterMap().get("Living Room").setInventory(inv);
		
		//arthur
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.glasses);
		game.getMasterMap().get("Arthur's Room").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.iceCream);
		game.getMasterMap().get("Mr.Ratburn's Class").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		game.getMasterMap().get("Study Room").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.BookshelfKey);
		game.getMasterMap().get("Library").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.flashlight);
		inv.addRoomInventory(Item.trophy);
		game.getMasterMap().get("Secret Room").setInventory(inv);
		
		//backyardigans
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.dirt);
		inv.addRoomInventory(Item.libraryCard);
		inv.addRoomInventory(Item.treeBranch);
		inv.addRoomInventory(Item.flower);
		game.getMasterMap().get("Mini Garden").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.shedKey);
		game.getMasterMap().get("Back Storage Room").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.sand);
		game.getMasterMap().get("Backyard").setInventory(inv);
		
		//max and ruby
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.antFarm);
		inv.addRoomInventory(Item.empanada);
		inv.addRoomInventory(Item.toyTruck);
		game.getMasterMap().get("Max's Room").setInventory(inv);
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.pillow);
		game.getMasterMap().get("Ruby's Room").setInventory(inv);
		
		//treehouse
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.cookies);
		inv.addRoomInventory(Item.apple);
		game.getMasterMap().get("Pantry").setInventory(inv);
		
		//mickey mouse
		
		inv = new Inventory(Integer.MAX_VALUE);
		inv.addRoomInventory(Item.cake);
		game.getMasterMap().get("Win Room").setInventory(inv);
		
	

	}

	public boolean checkRoomInventory(Item item) {
		for (Item i : rooms) {
			if (i == item) {

				for (String[] i : rooms) {
					if (i == item.getItemName(i)) {

						return true;
					}
				}
				return false;
			}
		}
	}

	public void removeRoomInventory(Item item) {
		boolean isValid = false;

		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].equals(item)) {
				rooms.remove(i);
				isValid = true;
				break;
			}
		}

	}

	public void addRoomInventory(Item item) {
		rooms.add(item);
	}
}
