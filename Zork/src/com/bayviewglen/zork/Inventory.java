package com.bayviewglen.zork;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	
	private static ArrayList<Item> items;
	private int maxWeight;
	private int currentPlayerWeight = 0;
	
	//two constructors
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
	
	//ERICA: You need to add the items class and the roomInventory class.

		

	public void addPlayerInventory(Item item) {
		if (getPlayerWeight() + item.getWeight() <= maxWeight) {	//getWeight has to be implemented in the items class
			items.add(item);
			//NEED TO ALSO REMOVE ITEM FROM THE ROOM INVENTORY. LUCK.
		}
		else {
			System.out.print("There is no more space left in your inventory.");
			System.out.print("If you picked this up now, your bag would be too heavy for you to walk.");
			System.out.println("Either drop something in your inventory or find another bag to expand your inventory.");
		}
		
	}
	
	public boolean checkPlayerInventory(Item item) {
		for(Item i : items) {
			if(i == item) {
				return true;
			}			
		}
		return false;
	}
	
	public void removePlayerInventory(Item item) {
		
	}
	
	//room inventory stuff
	private int numRooms = 0;
	private int numItems = 0;
	private String[][] rooms = new String[numRooms][numItems];
	
	public Inventory(double numRooms, int numItems) {
		this.numRooms = (int) numRooms;
		this.numItems = numItems;
		rooms = new String[(int) numRooms][numItems];

	}	
	
	
	public void initializeRooms() {
		rooms[0] = new String [] {"HouseEntrance","Map"};
		rooms[1] = new String [] {"Kitchen", "Table", "Raw Food", "Food", "Knife", "Cup", "Bottle","Counter", "Food"};
		rooms[2] = new String [] {"LivingRoom", "Backpack", "Clothes", "Broom", "LeafletHint"};
		rooms[3] = new String [] {"Arthur'sRoom", "Glasses"};
		rooms[4] = new String [] {"Mr.Ratburn'sClass", "Blackboard"};
		rooms[5] = new String [] {"StudyRoom"};
		rooms[6] = new String [] {"Library", "BookshelfKey", "Bookshelf"};
		rooms[7] = new String [] {"SecretRoom", "Flashlight"};
		rooms[8] = new String [] {"MiniGarden", "Dirt", "LibraryCard", "Sticks"};
		rooms[9] = new String [] {"BackStorageRoom", "ShedKey"};
		rooms[10] = new String [] {"MaxRoom", "AntFarm"};
	}
	
	

}
