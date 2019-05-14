package com.bayviewglen.zork;

import java.util.ArrayList;
import java.util.HashMap;

public class Items {

	public static void main(String args[]) {

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
		food.put("cake", 20); // mickey
		
		HashMap<String, Integer> tools = new HashMap<String, Integer>();

		tools.put("shovel", 15); // backyard
		tools.put("flashlight", 5); // max
		tools.put("library card", 5); // arthur
		tools.put("rope", 20); // mickey 

	}

}