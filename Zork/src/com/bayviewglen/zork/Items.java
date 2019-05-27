package com.bayviewglen.zork;

import java.util.ArrayList;
import java.util.HashMap;

public class Items {
	public void initializeItems() {
		HashMap<String, Integer> useless = new HashMap<String, Integer>();

		useless.put("flower", 5); // dora
		useless.put("branch", 10); // treehouse
		useless.put("sand", 5); // backyard
		useless.put("pillow", 10); // harry
		useless.put("toy truck", 5); // max

		HashMap<String, Integer> food = new HashMap<String, Integer>();

		food.put("empanada", 5); // dora
		food.put("pie", 10); // max
		food.put("ice cream", 5); // arthur
		food.put("cookies", 5); //backyard
		food.put("apple", 5); //treehouse
		food.put("cake", 20); // mickey

		HashMap<String, Integer> tools = new HashMap<String, Integer>();

		tools.put("shovel", 15); // backyard
		tools.put("flashlight", 5); // max
		tools.put("library card", 3); // arthur
		tools.put("rope", 20); // mickey
		tools.put("map", 1); //dora 
	}



	public void addItem(Items i) {
		useless.add(i);
	}

	public String getUseless(Items i) {
	    	 if(i<useless.size()&&>=0)
	    	        return useless.get(i).toString();
	    	    else
	    	        return "item does not exist";
	}
	
	public int getWeight() {
		
	}
}

	public class useless {
		//need method pickUp() that prints out 'you picked up...'
	}

	public class food {
		
	}

	public class empanada extends food {

	}

	public class tools {

	}
