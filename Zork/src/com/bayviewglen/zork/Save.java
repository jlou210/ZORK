package com.bayviewglen.zork;


import java.io.Serializable;

class Save implements Serializable {

	private static Inventory playerInventory;
	private static int playerInventoryWeight;
	private static Room currentRoom;

	    // getters for the fields

	    public void GameData(Inventory playerInventory, int playerInventoryWeight, Room currentRoom) {
	        Save.setPlayerInventory(playerInventory);
	        Save.setPlayerInventoryWeight(playerInventoryWeight);
	        Save.setCurrentRoom(currentRoom);
	    }

		public static int getPlayerInventoryWeight() {
			return playerInventoryWeight;
		}

		public static void setPlayerInventoryWeight(int playerInventoryWeight) {
			playerInventoryWeight = playerInventoryWeight;
		}

		public static Inventory getPlayerInventory() {
			return playerInventory;
		}

		public static void setPlayerInventory(Inventory playerInventory) {
			playerInventory = playerInventory;
		}

		public static Room getCurrentRoom() {
			return currentRoom;
		}

		public static void setCurrentRoom(Room currentRoom) {
			currentRoom = currentRoom;
		}



}
