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

	public void initializeRooms() {
		//dora
		rooms[0] = new String [] {"House Entrance","map", "Dora"};
		rooms[1] = new String [] {"Dining Room", "pie", "ice cream"};
		rooms[2] = new String [] {"Kitchen"};
		rooms[3] = new String [] {"LivingRoom", "backpack", "clothes", "leaflet hint"};
		//arthur
		rooms[4] = new String [] {"Arthur's Room", "glasses"};
		rooms[5] = new String [] {"Mr.Ratburn's Class", "ice cream"};
		rooms[6] = new String [] {"Study Room", "apple"};
		rooms[7] = new String [] {"Library", "bookshelf key"};
		rooms[8] = new String [] {"Secret Room", "flashlight", "trophy"};
		//backyardigans
		rooms[9] = new String [] {"Mini Garden", "dirt", "library card", "tree branch", "flower"};
		rooms[10] = new String [] {"Backyard", "sand"};
		rooms[11] = new String [] {"Back Storage Room", "shed key"};
		//max and ruby
		rooms[12] = new String [] {"Max's Room", "ant farm", "empanada", "toy truck"};
		rooms[13] = new String [] {"Ruby's Room", "pillow"};
		//treehouse
		rooms[14] = new String [] {"Pantry", "cookies", "donuts"};
		//mickeymouse
		rooms[15] = new String [] {"Win Room", "cake"};		

	}

	public void initializeRooms() {
		// dora
		rooms[0] = new String[] { "House Entrance", "map" };
		rooms[1] = new String[] { "Dining Room", "pie", "ice cream" };
		rooms[2] = new String[] { "Kitchen" };
		rooms[3] = new String[] { "LivingRoom", "backpack", "clothes", "leaflet hint" };
		// arthur
		rooms[4] = new String[] { "Arthur's Room", "glasses" };
		rooms[5] = new String[] { "Mr.Ratburn's Class", "ice cream" };
		rooms[6] = new String[] { "Study Room" };
		rooms[7] = new String[] { "Library", "bookshelf key" };
		rooms[8] = new String[] { "Secret Room", "flashlight", "trophy" };
		// backyardigans
		rooms[9] = new String[] { "Mini Garden", "dirt", "library card", "branch", "flower" };
		rooms[10] = new String[] { "Backyard", "sand" };
		rooms[11] = new String[] { "Back Storage Room", "shed key" };
		// max and ruby
		rooms[12] = new String[] { "Max's Room", "ant farm", "empanada", "toy truck" };
		rooms[13] = new String[] { "Ruby's Room", "pillow" };
		// treehouse
		rooms[14] = new String[] { "Pantry", "cookies", "apple" };
		// mickeymouse
		rooms[15] = new String[] { "Win Room", "cake" };

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
