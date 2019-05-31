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
			Item.initializeItems();

			Inventory.initializeRooms(this);
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
			finished = processCommand(command, playerInven);
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
		System.out.println("Zork is a new, incredibly boring adventure game. Just like your love life.");
		System.out.println("Type 'help' if you need help");
		System.out.println("The objective of this game is to collect all 4 trophies that will allow you to reach the special world where you will find a special prize!");
		System.out.println("For more info on what this game is really about, please visit our game Wiki. Please. I'm begging you. We wouldn't of wanted to work so very hard on it for no visitors.");
		System.out.println();
		System.out.println(currentRoom.longDescription());
	}

	/**
	 * Given a command, process (that is: execute) the command. If this command ends
	 * the game, true is returned, otherwise false is returned.
	 */

	private static boolean processCommand(Command command, Inventory playerInven) {
		if (command.isUnknown()) {
			System.out.println("I don't know what you mean...");
			return false;
		}
		String commandWord = command.getCommandWord();
		if (commandWord.equals("help")) {
			printHelp();
		} else if (commandWord.equals("teleport")) {
			if (command.hasSecondWord()) //Can't teleport to a place of the player's choosing.
				teleport(command.getSecondWord(), playerInven);
		}else if (commandWord.equals("go"))
			goRoom(command);
		 else if (commandWord.equals("quit")) {
			if (command.hasSecondWord())
				System.out.println("Quit what?");
		} else {
			return true; // signal that we want to quit
		}
		if (commandWord.equals("eat")) {
			System.out.println("Do you really think you should be eating at a time like this?");
		}
		return false;
	}



private static void teleport(Inventory playerInven) {
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
		System.out.println("You are currently in: " + currentRoom);
		System.out.println("Like I said at the beginning of this game...Go. Check. Out. The. Bloody. GAME WIKI!!!");
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
