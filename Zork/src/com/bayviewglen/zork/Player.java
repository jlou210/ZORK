package com.bayviewglen.zork;

public class Player {
	Inventory playerInventory = new Inventory(0);
	int inventoryWeight = 0;

	public Player(int invenWeight) {
		playerInventory = new Inventory(invenWeight);
	}

	// eat method

	public static void eat(Item item, String room, Inventory playerInven, Game game) {
		if (playerInven.checkPlayerInventory(item) == true) {
			playerInven.removePlayerInventory(item);
			System.out.println("You just ate " + item + " : " + Food.sound(item));
		} else if (Inventory.checkRoomInventory(item, game) == true) {
			Inventory.removeRoomInventory(item, room, game);
			System.out.println("You just ate " + item + " : " + Food.sound(item));
		} else {
			System.out.println("You cannot eat " + item + " because it cannot be found.");
		}

	}

	public void take(Item tool, Inventory playerInven, Game game) {
		if(Inventory.checkRoomInventory(tool, game) == true) {
			playerInventory.addPlayerInventory(tool);
			System.out.println(tool + " added to your Inventory.");
		} else {System.out.println(tool + "is not in this room. It cannot be added to your inventory.");}
		
	}

//use method

	public void use(Item tool, Inventory playerInven, Game game, String room) {
		if (playerInven.checkPlayerInventory(tool) == true) {
			playerInven.removePlayerInventory(tool);
			System.out.println("You just used " + tool + ".");
		} else {
			System.out.println("You cannot use" + tool + "because it cannot be found.");
		}

	}

//get method
	public void get(Item tool2, Inventory playerInven, String room, Game game) {
		if (Inventory.checkRoomInventory(tool2, game) == true) {
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
	public String lookAt(Item tool, Game game) {
		if (Inventory.checkRoomInventory(tool, game) == true) {
			return tool.getItemDescription(tool);
		}
		else {
			return "This item could not be found";
		}
		
	}

	public String lookAt(useless tool, Game game) {
		if (Inventory.checkRoomInventory(tool, game) == true) {
			return tool.getItemDescription(tool);
		}
		else {
			return "This item could not be found";
		}
	}

//burn methods
	public String burn(Item tool, Game game) {
		if (Inventory.checkRoomInventory(tool, game) == true) {
			Inventory.removeRoomInventory(tool, game);
			System.out.println(tool + "is burning!");
		}
	}

//drop methods
	public void drop(Item tool) {
		if (playerInventory.checkPlayerInventory(tool) == true) {
			playerInventory.removePlayerInventory(tool);
			System.out.println("You dropped" + tool + ".");
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
	/*public String drink(Drink water) {
		if(playerInventory.checkPlayerInventory(water) == true) {
			playerInventory.removePlayerInventory(water);
			System.out.println("You drank" + water + ".");
		}else {
			System.out.println("You cannot drinks something that is not in your inventory.");
		}
	}*/

//give method
	public void give(Item tool) {
		if (playerInventory.checkPlayerInventory(tool) == true) {
			System.out.println("You gave away" + tool + ".");
		} else {
			System.out.println("You cannot give something that's not in your inventory.");
		}
	}

//move methods
	public String move(Command command) {
		return go(command);

	}

//climb method
	public String climb() {
		return null;
	}

//throw method
	public void throwObject(Item tool) {
		if (playerInventory.checkPlayerInventory(tool) == true) {
			System.out.println("You have thrown" + tool);
		} else {
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

//help method
	public void help() {
		Game.printHelp();
	}

//quit method
	public String quit() {
		return null;
	}
// put method
	public void put(Item tool) {
		if (playerInventory.checkPlayerInventory(tool) == true) {
			playerInventory.removePlayerInventory(tool);
			System.out.println("You put down" + tool + ".");
		} else {
			System.out.println("You cannot put down something that's not in your inventory.");
		}
	}
//place method
	public void place(Item tool) {
		if (playerInventory.checkPlayerInventory(tool) == true) {
			playerInventory.removePlayerInventory(tool);
			System.out.println("You placed" + tool + ".");
		} else {
			System.out.println("You cannot place something that's not in your inventory.");
		}
	}
}
