package com.bayviewglen.zork;

public class Player {
	PlayerInventory inventory = new PlayerInventory(0);
	int inventoryWeight = 0;

	public Player(int invenWeight) {
		inventory = new PlayerInventory(invenWeight);
	}

	// eat method

	public String eat(Food food) {
		if(inventory.checkPlayerInventory(food) == true) {
			removePlayerInventory(food);
			System.out.println("You just ate " + food + " : " + food.getSound());
		}else if(checkRoomInventory(food) == true) {
			removeRoomInventory(food);
			System.out.println("You just ate " + food + " : " + food.getSound());
		}else {
			return "You cannot eat" + food + "because it cannot be found.";
		}
		
	}

	public String take(Tool tool) {
		if(checkRoomInventory(tool) = true) {
			inventory.addPlayerInven(tool);
			return tool + "added to your Inventory.";
		} else {return tool + "is not in this room. It cannot be added to your inventory.";
	}

	public String take(useless tool) {
		if(checkRoomInventory(tool) = true) {
				addPlayerInventory(tool);
				return tool + "added to your Inventory.";
			} else {return tool + "is not in this room. It cannot be added to your inventory.";
			}
		}
	
	public String use(useless tool) {
		return tool + "cannot be used here.";
	}
	
	public String use(Tool tool) {
		if(checkPlayerInventory(tool) == true) {
			removePlayerInventory(tool);
			System.out.println("You just ate " + tool + " : " + food.getSound());
		}else if(checkRoomInventory(tool) == true) {
			removeRoomInventory(tool);
			System.out.println("You just ate " + tool + " : " + food.getSound());
		}else {
			return "You cannot eat" + tool + "because it cannot be found.";
		}
		
	}
	
	
	
	
	
	
}
