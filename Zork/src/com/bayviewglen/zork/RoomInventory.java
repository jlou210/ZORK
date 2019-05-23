package com.bayviewglen.zork;

public class RoomInventory {
	private int numRooms = 0;
	private int numItems = 0;
	private String[][] rooms = new String[numRooms][numItems];
	
	public RoomInventory(int num, int items){
		numRooms = num;
		numItems = items;
		rooms = new String[numRooms][numItems];
	}
	
	public void initializeRooms() {
		rooms[0] = new String [] {"HouseEntrance","Map"};
		rooms[1] = new String [] {"Kitchen", "Table", "Raw Food", "Food", "Knife", "Cup", "Bottle","Counter", "Food"};
		rooms[2] = new String [] {"LivingRoom", "Backpack", "Clothes", "Broom", "Leaflet Hint", "Staircase Up", "Staircase Down"};
		rooms[3] = new String [] {"ArthursRoom", "Glasses"};
		rooms[4] = new String [] {"Mr.Ratburn'sClass", "Blackboard"};
		rooms[5] = new String [] {"StudyRoom", "Library Card"};
		rooms[6] = new String [] {"Library", "Bookshelf Key", "Bookshelf"};
		rooms[7] = new String [] {"SecretRoom", "Flashlight"};
		rooms[8] = new String [] {"Minigarden", "Dirt", "Library Card", "Sticks"};
		rooms[9] = new String [] {"BackStorageRoom", "Shed Key"};
		rooms[10] = new String [] {"MaxRoom", "Antfarm"};
	}

}
