package com.bayviewglen.zork;

public class Player {
	PlayerInventory inventory = new PlayerInventory(0);
	int inventoryWeight = 0;

	public Player(int invenWeight) {
		inventory = new PlayerInventory(invenWeight);
	}

	// eat method

	public String eat(food food) {
		if (checkPlayerInventory(food) == true) {
			removePlayerInventory(food);
			System.out.println("You just ate " + food + " : " + food.getSound());
		} else if (checkRoomInventory(food) == true) {
			removeRoomInventory(food);
			System.out.println("You just ate " + food + " : " + food.getSound());
		} else {
			return "You cannot eat" + food + "because it cannot be found.";
		}

	}

	public String take(tools tool) {
		if(checkRoomInventory(tool) = true) {
			addPlayerInventory(tool);
			return tool + "added to your Inventory.";
		} else {return tool + "is not in this room. It cannot be added to your inventory.";
	}

	public String take(useless item){
		if(checkRoomInventory(item) = true) {
				addPlayerInventory(item);
				removeRoomInventory(item);
				return item + "added to your Inventory.";
			} else {return item + "is not in this room. It cannot be added to your inventory.";
			}
		}
	
	public String use(useless item1) {
		return item1 + "cannot be used here.";
	}
	
	public String use(tools tool1) {
		if(checkPlayerInventory(tool1) == true) {
			System.out.println("You just used" + tool1);
		}else if(checkRoomInventory(tool1) == true) {
			removeRoomInventory(tool1);
			System.out.println("You just used " + tool1);
			addRoomInventory(tool1);
		}else {
			return "You cannot use" + tool1 + "because it cannot be found.";
		}
		
	}
	
	public String get(tools tool2) {
		if(checkRoomInventory = true) {
			addPlayerInventory(tool2);
		}else { 
			System.out.println("You cannot get" + tool2 + "because it is not in this room.");
		}
		}
	
	public String get(useless item2)){
		if(checkRoomInventory = true) {
			addPlayerInventory(item2);
		}else { 
			System.out.println("You cannot get" + item2 + "because it is not in this room.");
		}
		}
	}

}
