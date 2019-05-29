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
		//dora
		rooms[0] = new String [] {"HouseEntrance","Map"};
		rooms[1] = new String [] {"DiningRoom", "Pie", "Ice Cream"};
		rooms[2] = new String [] {"Kitchen", "Raw Food", "Food", "Cup","Food"};
		rooms[3] = new String [] {"LivingRoom", "Backpack", "Clothes", "Broom", "Leaflet Hint"};
		//arthur
		rooms[4] = new String [] {"Arthur'sRoom", "Glasses"};
		rooms[5] = new String [] {"Mr.Ratburn'sClass"};
		rooms[6] = new String [] {"StudyRoom", "Library Card"};
		rooms[7] = new String [] {"Library", "Bookshelf Key"};
		rooms[8] = new String [] {"SecretRoom", "Flashlight", "Trophy"};
		//backyardigans
		rooms[9] = new String [] {"Minigarden", "Dirt", "Library Card", "Sticks", "Flower"};
		rooms[10] = new String [] {"Backyard", "Tree Branch", "Sand"};
		rooms[11] = new String [] {"BackStorageRoom", "Shed Key"};
		//max and ruby
		rooms[12] = new String [] {"MaxRoom", "Antfarm", "Empanada", "Toy Truck"};
		rooms[13] = new String [] {"Ruby'sRoom", "Pillow"};
		//treehouse
		rooms[14] = new String [] {"Good'sRoom", "Cookies", "Apple"};
		//mickeymouse
		rooms[15] = new String [] {"WinRoom", "Cake"};		
	}
	
}
