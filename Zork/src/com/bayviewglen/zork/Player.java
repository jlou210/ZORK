package com.bayviewglen.zork;

public class Player {
	Inventory playerInventory = new Inventory(0);
	int inventoryWeight = 0;

	public Player(int invenWeight) {
		playerInventory = new Inventory(invenWeight);
	}

	// eat method

	public String eat(food food) {
		if (checkPlayerInventory(food) == true) {

	public String eat(Food food) {
		if (inventory.checkPlayerInventory(food) == true) {

			removePlayerInventory(food);
			System.out.println("You just ate " + food + " : " + food.getSound());
		} else if (checkRoomInventory(food) == true) {
			removeRoomInventory(food);
			System.out.println("You just ate " + food + " : " + food.getSound());
		} else {
			return "You cannot eat" + food + "because it cannot be found.";
		}

	}

	public String take(Tool tool) {
		if(checkRoomInventory(tool) == true) {
			inventory.addPlayerInventory(tool);
			return tool + "added to your Inventory.";
		} else {return tool + "is not in this room. It cannot be added to your inventory.";
	}

	public String take(useless item) {
		if (checkRoomInventory(item) == true) {
			addPlayerInventory(item);
			removeRoomInventory(item);
			return item + "added to your Inventory.";
		} else {
			return item + "is not in this room. It cannot be added to your inventory.";
		}
	}
//use method
	public String use(useless item1) {
		return item1 + "cannot be used here.";
	}


	public String use(Tool tool) {
		if (checkPlayerInventory(tool) == true) {
			removePlayerInventory(tool);
			System.out.println("You just ate " + tool + " : " + food.getSound());
		} else if (checkRoomInventory(tool) == true) {
			removeRoomInventory(tool);
			System.out.println("You just ate " + tool + " : " + food.getSound());
		} else {
			return "You cannot use" + tool1 + "because it cannot be found.";
		}

	}
//get method
	public String get(Tool tool2) {
		if (checkRoomInventory == true) {
			addPlayerInventory(tool2);
		} else {
			System.out.println("You cannot get" + tool2 + "because it is not in this room.");
		}
	}

	public String get(useless item2) {
		if (checkRoomInventory == true) {
			addPlayerInventory(item2);
		} else {
			System.out.println("You cannot get" + item2 + "because it is not in this room.");
		}
	}
//look method
	public String look() {
		System.out.println(roomDescription);
	}
//lookAt method
	public String lookAt(Tool tool) {
		if(checkRoomInventory(tool) == true) {
			return getItemDescription(tool);
		}
	}
	
	public String lookAt(useless tool) {
		if(checkRoomInventory(tool) == true) {
			return getItemDescription(tool);
		}
	}
	
//burn methods
	public String burn(Tool tool) {
		if(checkRoomInventory(tool) == true) {
			removeRoomInventory(tool);
			System.out.println(tool + "is burning!");
			}
		}
	
	public String burn(useless tool) {
		if(checkRoomInventory(tool) == true) {
			removeRoomInventory(tool);
			System.out.println(tool + "is burning!");
			}
		}
	
	public String burn(Food tool) {
		if(checkRoomInventory(tool) == true) {
			removeRoomInventory(tool);
			System.out.println(tool + "is burning!");
			}
		}
	}

