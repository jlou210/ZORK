package com.bayviewglen.zork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class Game - the main class of the "Zork" game.
 *
 * Author: Michael Kolling Version: 1.1 Date: March 2000
 * 
 * This class is the main class of the "Zork" application. Zork is a very
 * simple, text based adventure game. Users can walk around some scenery. That's
 * all. It should really be extended to make it more interesting!
 * 
 * To play this game, create an instance of this class and call the "play"
 * routine.
 * 
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates the commands that
 * the parser returns. another comment
 */
class Game {
	private static Parser parser;
	public static Room currentRoom;
;
	// This is a MASTER object that contains all of the rooms and is easily
	// accessible.
	// The key will be the name of the room -> no spaces (Use all caps and
	// underscore -> Great Room would have a key of GREAT_ROOM
	// In a hashmap keys are case sensitive.
	// masterRoomMap.get("GREAT_ROOM") will return the Room Object that is the Great
	// Room (assuming you have one).
	private static HashMap<String, Room> masterRoomMap;
	private static Map map = new Map("The Map", 1, "Hello! I am Map!");
	Inventory rooms = new Inventory(11.0, 10);
	static Inventory playerInven = new Inventory(40);
	public static Player player;
	
	private void initRooms(String fileName) throws Exception {
		masterRoomMap = new HashMap<String, Room>();
		Scanner roomScanner;
		
		try {
			HashMap<String, HashMap<String, String>> exits = new HashMap<String, HashMap<String, String>>();
			roomScanner = new Scanner(new File(fileName));
			while (roomScanner.hasNext()) {
				Room room = new Room();
				// Read the Name
				String roomName = roomScanner.nextLine();
				room.setRoomName(roomName.split(":")[1].trim());
				// Read the Description
				String roomDescription = roomScanner.nextLine();
				room.setDescription(roomDescription.split(":")[1].replaceAll("<br>", "\n").trim());
				// Read the Exits
				String roomExits = roomScanner.nextLine();
				// An array of strings in the format E-RoomName
				String[] rooms = roomExits.split(":")[1].split(",");
				HashMap<String, String> temp = new HashMap<String, String>();
				for (String s : rooms) {
					temp.put(s.split("-")[0].trim(), s.split("-")[1]);
				}

				exits.put(roomName.substring(10).trim().toUpperCase().replaceAll(" ", "_"), temp);

				// This puts the room we created (Without the exits in the masterMap)
				masterRoomMap.put(roomName.toUpperCase().substring(10).trim().replaceAll(" ", "_"), room);

				// Now we better set the exits.
			}

			for (String key : masterRoomMap.keySet()) {
				Room roomTemp = masterRoomMap.get(key);
				HashMap<String, String> tempExits = exits.get(key);
				for (String s : tempExits.keySet()) {
					// s = direction
					// value is the room.

					String roomName2 = tempExits.get(s.trim());
					Room exitRoom = masterRoomMap.get(roomName2.toUpperCase().replaceAll(" ", "_"));
					roomTemp.setExit(s.trim().charAt(0), exitRoom);

				}

			}

			roomScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**	 * Create the game and initialize its internal map.
	 */
	public Game() {
		try {
			initRooms("data/Rooms.dat");
			currentRoom = masterRoomMap.get("START_POINT");
			playerInven = new Inventory(30);
			Item itemList = new Item();	//null pointer
			itemList.initializeItems();	//null pointer
			Inventory.initializeRooms(this, itemList);	//null pointer
			play(this, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		parser = new Parser();
	}

	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play(Game game, boolean finished) {
		printWelcome();
// Enter the main command loop.  Here we repeatedly read commands and
		// execute them until the game is over.

	
		while (!finished) {
			Command command = parser.getCommand(game);
			finished = processCommand(command, playerInven, game);
		}
		System.out.println("Thank you for playing.  Good bye.");
	}
	
	public HashMap<String, Room> getMasterMap() {
		return masterRoomMap;
	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome() {
		System.out.println();
		System.out.println("Welcome to Zork!");
		System.out.println("Zork is a new, exciting and thrilling adventure game. (Hopefully) Just like your love life.");
		System.out.println("Type 'help' if you need help");
		System.out.println("The objective of this game is to collect all 4 trophies that will allow you to reach the special world where you will find a special prize!");
		System.out.println("For more info on what this game is really about, please visit our game Wiki. Please. I'm begging you.");
		System.out.println("We wouldn't of wanted to work so very hard on it find that no one wants to read it."); 
		System.out.println();
		System.out.println(currentRoom.longDescription());
	}

	/**
	 * Given a command, process (that is: execute) the command. If this command ends
	 * the game, true is returned, otherwise false is returned.
	 */

	private static boolean processCommand(Command command, Inventory playerInven, Game game) {
		if (command.isUnknown()) {
			System.out.println("I don't know what you mean...");
			return false;
		}
		String commandWord = command.getCommandWord();
		if (commandWord.equals("help")) {
			printHelp();
		} else if (commandWord.equals("teleport")) {
				teleport(playerInven);
		}else if (commandWord.equals("go"))
			goRoom(command);
		 else if (commandWord.equals("quit")) {
			if (command.hasSecondWord())
				System.out.println("Quit what?");
			 else {
					return true; // signal that we want to quit
			 } 
		
		}
		 else if(commandWord.equals("use")) {
			 System.out.println("You used the " + command.getSecondWord());
		 }
		 else if(commandWord.equals("look")) {
			 System.out.println("You looked " + command.getSecondWord());
		 }
		
		else if(commandWord.equals("get")){
			if(command.getSecondWord()=="cookies") {
				player.get(Item.food.get("cookies"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="cake") {
				player.get(Item.food.get("cake"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="donuts") {
				player.get(Item.food.get("donuts"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}else if(command.getSecondWord()=="ice") {
				player.get(Item.food.get("ice cream"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="pie") {
				player.get(Item.food.get("pie"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="empanada") {
				player.get(Item.food.get("empanada"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="apple") {
				player.get(Item.food.get("apple"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}else if(command.getSecondWord()=="water") {
				player.get(Item.drink.get("water"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="milk") {
				player.get(Item.food.get("milk"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="map") {
				player.get(Item.tools.get("map"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="glasses") {
				player.get(Item.food.get("glasses"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="cake") {
				player.get(Item.food.get("cake"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}else if(command.getSecondWord()=="flashlight") {
				player.get(Item.tools.get("flashlight"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="library") {
				player.get(Item.tools.get("library card"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="backpack") {
				player.get(Item.tools.get("backpack"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="shed") {
				player.get(Item.tools.get("shed key"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="trophy 1") {
				player.get(Item.tools.get("trophy"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="trophy 2") {
				player.get(Item.tools.get("trophy 2"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="trophy 3") {
				player.get(Item.tools.get("trophy 3"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="trophy 4") {
				player.get(Item.tools.get("trophy 4"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="ant") {
				player.get(Item.tools.get("ant farm"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="bookshelf") {
				player.get(Item.tools.get("bookshelf"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="flower") {
				player.get(Item.useless.get("flower"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="sand") {
				player.get(Item.useless.get("sand"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="dirt") {
				player.get(Item.useless.get("dirt"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="tree") {
				player.get(Item.useless.get("tree branch"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="toy") {
				player.get(Item.useless.get("tory truck"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="clothes") {
				player.get(Item.useless.get("clothles"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="leaflet") {
				player.get(Item.tools.get("leaflet hint"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else if(command.getSecondWord()=="book") {
				player.get(Item.tools.get("book"), playerInven, currentRoom.getRoomName(currentRoom), game);
			}
			else {
				System.out.println("get what?");
			}
		}
		 else if(commandWord.equals("drink")) {
			 if(command.hasSecondWord()) {
				 player.drink(Item.drink.get(command.getSecondWord()));
			 }
			 else {
				 System.out.println("Drink what?");
			 }
		 }
		 else if(commandWord.equals("drop")) {
			 else if(commandWord.equals("get")){
					if(command.getSecondWord()=="cookies") {
						player.drop(Item.food.get("cookies"));
					}
					else if(command.getSecondWord()=="cake") {
						player.drop(Item.food.get("cake"));
					}
					else if(command.getSecondWord()=="donuts") {
						player.drop(Item.food.get("donuts"));
					}else if(command.getSecondWord()=="ice") {
						player.drop(Item.food.get("ice cream"));
					}
					else if(command.getSecondWord()=="pie") {
						player.drop(Item.food.get("pie"));
					}
					else if(command.getSecondWord()=="empanada") {
						player.drop(Item.food.get("empanada"));
					}
					else if(command.getSecondWord()=="apple") {
						player.drop(Item.food.get("apple"));
					}else if(command.getSecondWord()=="water") {
						player.drop(Item.drink.get("water"));
					}
					else if(command.getSecondWord()=="milk") {
						player.drop(Item.food.get("milk"));
					}
					else if(command.getSecondWord()=="map") {
						player.drop(Item.tools.get("map"));
					}
					else if(command.getSecondWord()=="glasses") {
						player.drop(Item.food.get("glasses"));
					}
					else if(command.getSecondWord()=="cake") {
						player.drop(Item.food.get("cake"));
					}else if(command.getSecondWord()=="flashlight") {
						player.drop(Item.tools.get("flashlight"));
					}
					else if(command.getSecondWord()=="library") {
						player.drop(Item.tools.get("library card"));
					}
					else if(command.getSecondWord()=="backpack") {
						player.get(Item.tools.get("backpack"));
					}
					else if(command.getSecondWord()=="shed") {
						player.get(Item.tools.get("shed key"));
					}
					else if(command.getSecondWord()=="trophy 1") {
						player.get(Item.tools.get("trophy"));
					}
					else if(command.getSecondWord()=="trophy 2") {
						player.get(Item.tools.get("trophy 2"));
					}
					else if(command.getSecondWord()=="trophy 3") {
						player.get(Item.tools.get("trophy 3"));
					}
					else if(command.getSecondWord()=="trophy 4") {
						player.get(Item.tools.get("trophy 4"), playerInven, currentRoom.getRoomName(currentRoom), game);
					}
					else if(command.getSecondWord()=="ant") {
						player.get(Item.tools.get("ant farm"), playerInven, currentRoom.getRoomName(currentRoom), game);
					}
					else if(command.getSecondWord()=="bookshelf") {
						player.get(Item.tools.get("bookshelf"), playerInven, currentRoom.getRoomName(currentRoom), game);
					}
					else if(command.getSecondWord()=="flower") {
						player.get(Item.useless.get("flower"), playerInven, currentRoom.getRoomName(currentRoom), game);
					}
					else if(command.getSecondWord()=="sand") {
						player.get(Item.useless.get("sand"), playerInven, currentRoom.getRoomName(currentRoom), game);
					}
					else if(command.getSecondWord()=="dirt") {
						player.get(Item.useless.get("dirt"), playerInven, currentRoom.getRoomName(currentRoom), game);
					}
					else if(command.getSecondWord()=="tree") {
						player.get(Item.useless.get("tree branch"), playerInven, currentRoom.getRoomName(currentRoom), game);
					}
					else if(command.getSecondWord()=="toy") {
						player.get(Item.useless.get("tory truck"), playerInven, currentRoom.getRoomName(currentRoom), game);
					}
					else if(command.getSecondWord()=="clothes") {
						player.get(Item.useless.get("clothles"), playerInven, currentRoom.getRoomName(currentRoom), game);
					}
					else if(command.getSecondWord()=="leaflet") {
						player.get(Item.tools.get("leaflet hint"), playerInven, currentRoom.getRoomName(currentRoom), game);
					}
					else if(command.getSecondWord()=="book") {
						player.get(Item.tools.get("book"), playerInven, currentRoom.getRoomName(currentRoom), game);
					}
		 }
		 else if(commandWord.equals("talk")) {
			 if(command.getSecondWord() == "Dora") {
				 Dora dora = new Dora();
				 dora.speak();
			 }
			 else  if(command.getSecondWord() == "Arthur") {
				 Arthur arthur = new Arthur();
				 arthur.speak();
			 }
			 else if(command.getSecondWord() == "DW") {
				 DW dw = new DW();
				 dw.speak();
			 }
			 else if(command.getSecondWord() == "Max") {
				 Max max = new Max();
				 max.speak();
			 }
			 else if(command.getSecondWord() == "Ruby") {
				 Ruby ruby = new Ruby();
				 ruby.speak();
			 }
			 else if(command.getSecondWord() == "Mickey") {
				 Mickey mickey = new Mickey();
				 mickey.speak();
			 }
			 else if(command.getSecondWord() == "Minnie") {
				 Minnie minnie = new Minnie();
				 minnie.speak();
			 }
		 }
		 else if(commandWord.equals("read")) {
			 if(command.hasSecondWord()) {
				 player.read(Item.tools.get(command.getSecondWord()));
			 }
			 else {
				 System.out.println("Read what?");
			 }
		 }
		 else if(commandWord.equals("give")) {
			 if(command.hasSecondWord()) {
				 player.give(Item.tools.get(command.getSecondWord()));
			 }
			 else {
				 System.out.println("Give what?");
			 }
		 }
		 else if (commandWord.equals("eat")) {
			if(command.hasSecondWord()) {
				player.eat(Item.food.get(command.getSecondWord()), currentRoom.getRoomName(currentRoom), playerInven, game);
			}
			System.out.println("Do you really think you should be eating at a time like this?");
		} else if (commandWord.equals("kill")) {
			System.out.println("This is a kids game, why do you want to kill something?");
		} else if(commandWord.equals("burn")) {
			System.out.println("This is a kids game, why do you want to burn something?");
		}else if(commandWord.equals("climb")) {
			System.out.println("You climbed");
		}
		else if (commandWord.equals("take")) {
			if (command.hasSecondWord()) {
				player.take(Item.tools.get(command.getSecondWord()), playerInven, game);
			} else {
				System.out.println("Take what?");
			}
		}
		return false;
	}



public static void teleport(Inventory playerInven) {
		if(playerInven.checkPlayerInventory(map)) {
			String secondWord = "Main Room";
			currentRoom = masterRoomMap.get(secondWord.toUpperCase().replaceAll(" ", "_"));
			System.out.println(currentRoom.longDescription());
		} else {
			// no
			System.out.println("You do not have the map");
		}
	}

// implementations of user commands:
	/**
	 * Print out some help information. Here we print some stupid, cryptic message
	 * and a list of the command words.
	 */
	public static void printHelp() {
		System.out.println("You are currently in: " + currentRoom.getRoomName(currentRoom));
		System.out.println("Like I said at the beginning of this game...Go. Check. Out. The. Bloody. GAME WIKI!!!");
		System.out.println("Your Commands are: ");
		parser.showCommands();
	}

	/**
	 * Try to go to one direction. If there is an exit, enter the new room,
	 * otherwise print an error message.
	 */
	public static String goRoom(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println("Go where?");
		}else {
		String direction = command.getSecondWord();
// Try to leave current room.
		Room nextRoom = currentRoom.nextRoom(direction);
		if (nextRoom == null)
			System.out.println("There is no door!");
		else {
			currentRoom = nextRoom;
			System.out.println(currentRoom.longDescription());
		}
	}
		return null;

}
}
