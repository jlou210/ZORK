package com.bayviewglen.zork;

public class Player {
	Inventory playerInventory = new Inventory(0);
	int inventoryWeight = 0;

	public Player(int invenWeight) {
		playerInventory = new Inventory(invenWeight);
	}

	// eat method

	public String eat(Food food) {
		if (playerInventory.checkPlayerInventory(food) == true) {
			playerInventory.removePlayerInventory(food);
			System.out.println("You just ate " + food + " : " + food.sound());
		} else if (checkRoomInventory(food) == true) {
			removeRoomInventory(food);
			System.out.println("You just ate " + food + " : " + food.sound());
		} else {
			return "You cannot eat" + food + "because it cannot be found.";
		}

	}

	public String take(Item tool) {
		if(Inventory.checkRoomInventory(tool) == true) {
			playerInventory.addPlayerInventory(tool);
			return tool + "added to your Inventory.";
		} else {return tool + "is not in this room. It cannot be added to your inventory.";
	}


//use method
	
	public String use(Item tool) {
		if (playerInventory.checkPlayerInventory(tool) == true) {
			playerInventory.removePlayerInventory(tool);
			System.out.println("You just used " + tool + ".");
		} else if (checkRoomInventory(tool) == true) {
			removeRoomInventory(tool);
			System.out.println("You just ate " + tool + " : " + food.sound()); //Why are you eating the tool?!
		} else {
			return "You cannot use" + tool + "because it cannot be found.";
		}

	}

//get method
	public String get(Item tool2) {
		if (checkRoomInventory == true) {
			playerInventory.addPlayerInventory(tool2);
		} else {
			System.out.println("You cannot get" + tool2 + "because it is not in this room.");
		}
	}



//look method
	public String look() {
		System.out.println("You are in: " + Room.getRoomName() + ". " + Room.getDescription());
	}

//lookAt method
	public String lookAt(Item tool) {
		if (checkRoomInventory(tool) == true) {
			return tool.getItemDescription(tool);
		}
	}

	public String lookAt(useless tool) {
		if (checkRoomInventory(tool) == true) {
			return tool.getItemDescription(tool);
		}
	}

//burn methods
	public String burn(Item tool) {
		if (checkRoomInventory(tool) == true) {
			removeRoomInventory(tool);
			System.out.println(tool + "is burning!");
		}
	}


//drop methods
	public String drop(Item tool) {
		if (playerInventory.checkPlayerInventory(tool) == true) {
			playerInventory.removePlayerInventory(tool);
		} else {
			System.out.println("You cannot drop something that's not in your inventory.");
		}
	}

	
	
//read methods
	public String read(Item tool) {
		return Item.description;
	}

//go methods
	public String go(Command command) {
		return Game.goRoom(command);

	}

//drink method
	public String drink() {
		return null;
	}

//give method
	public String give(Item tool) {
		if(checkPlayerInventory(tool) == true) {
			System.out.println("You gave away" + tool+ ".");
		}else {
			System.out.println("You cannot give something that's not in your inventory.");
		}
	}

//move method
	public String move(Command command) {
		return go(command);
		
	}

//climb method
	public String climb() {
		return null;
	}

//throw method
	public String throwObject(Item tool) {
		if(checkPlayerInventory(tool) == true) {
			System.out.println("You have thrown" + tool);
		}else {
			System.out.println("You cannot throw" + tool + "because it is not in your inventory.");
		}
	}

//save method
	public String save() {
		return null;
	}
	
//check inventory method
	public Inventory check() {
		return playerInventory;
	}
	
//check player inventory (boolean)
	public boolean checkPlayerInventory(Item tool) {
		if()
	}

//help method
	public void help() {
		Game.printHelp();
	}
	
//quit method
	public String quit() {
		return null;
	}
}
