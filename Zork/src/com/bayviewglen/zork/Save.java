package com.bayviewglen.zork;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Save implements Serializable {

		private Inventory playerInventory;
		private int playerInventoryWeight;
		private Room currentRoom;

	    // getters for the fields

	    public static void GameData(Inventory playerInventory, int playerInventoryWeight, Room currentRoom) {
	        this.playerInventory = playerInventory;
	        this.playerInventoryWeight = playerInventoryWeight;
	        this.currentRoom = currentRoom;
	    }


Save data = new Save(someplayerInventory, someplayerInventoryWeight, somecurrentRoom);
stream.writeObject(data);
}
