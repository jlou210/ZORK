package com.bayviewglen.zork;

import java.util.ArrayList;
import java.util.List;

public class PlayerInventory {

	List<String> inventory = new ArrayList<String>();
	public List<String> inventory = new ArrayList<String>();
	private double weightLimit;
	private double currentWeight = 0;

	//two constructors
	public PlayerInventory(double weight){
		weightLimit = weight;
	}

	public PlayerInventory(double weight, double setWeight) {
		weightLimit = weight;
		currentWeight = setWeight;
	}

	public double getWeight() {
		return currentWeight;
	}

	//ERICA: You need to add the items class and the roomInventory class.

	public class getItem {
		if ()

		else 		

}
	public String addPlayerInven(String item){
		if (getWeight() + item.getWeight() <= weightLimit) {	//getWeight has to be implemented in the items class
			inventory.add(item);
			//NEED TO ALSO REMOVE ITEM FROM THE ROOM INVENTORY. LUCK.
		}
		else {
			System.out.print("There is no more space left in your inventory.");
			System.out.print("If you picked this up now, your bag would be too heavy for you to walk.");
			System.out.println("Either drop something in your inventory or find another bag to expand your inventory.");
		}

		return null;

//random comment 
	}

}
