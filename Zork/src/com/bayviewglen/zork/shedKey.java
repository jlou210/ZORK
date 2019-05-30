package com.bayviewglen.zork;


	public class shedKey extends Tool {
		public shedKey(String name, int weight, String description) {
			super(name, weight, description);
		}
		

		public String message() {
			return "You've picked up what seems to be some sort of key.";
		}

	}
