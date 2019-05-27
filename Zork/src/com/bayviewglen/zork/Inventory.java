package com.bayviewglen.zork;

import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Item> items;
	private int maxWeight;
	
	public Inventory(int maxWeight) {
		items = new ArrayList<Item>();
		this.maxWeight = maxWeight;
	}
	

}
