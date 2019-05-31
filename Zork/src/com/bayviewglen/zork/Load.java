package com.bayviewglen.zork;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Load implements Serializable {
	private Inventory playerInventory = Save.getPlayerInventory();
		private int playerInventoryWeight = Save.getPlayerInventoryWeight();
		private Room currentRoom = Save.getCurrentRoom();
		
	Save data = new Save(someplayerInventory, someplayerInventoryWeight, somecurrentRoom);
	stream.writeObject(data);
}
