package com.bayviewglen.zork;

/*
 * Author:  Michael Kolling
 * Version: 1.0
 * Date:    July 1999
 * 
 * test more
 * 
 * This class is part of Zork. Zork is a simple, text based adventure game.
 *
 * This parser reads user input and tries to interpret it as a "Zork"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Parser {
	private CommandWords commands; // holds all valid command words

	public Parser() {
		commands = new CommandWords();
	}

	public Command getCommand(Game game) {
		String inputLine = ""; // will hold the full input line
		String word1;
		String word2;
		String word3;
		String word4;
		System.out.print("> "); // print prompt
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			inputLine = reader.readLine();
		} catch (java.io.IOException exc) {
			System.out.println("There was an error during reading: " + exc.getMessage());
		}
		StringTokenizer tokenizer = new StringTokenizer(inputLine);
		if (tokenizer.hasMoreTokens())
			word1 = tokenizer.nextToken().toLowerCase(); // get first word
		else
			word1 = null;
		if (tokenizer.hasMoreTokens())
			word2 = tokenizer.nextToken().toLowerCase(); // get second word
		else
			word2 = null;
		if (tokenizer.hasMoreTokens())
			word3 = tokenizer.nextToken().toLowerCase(); // get third word
		else
			word3 = null;
		if (tokenizer.hasMoreTokens())
			word4 = tokenizer.nextToken().toLowerCase(); // get fourth word
		else
			word4 = null;
// note: we just ignore the rest of the input line.
// Now check whether this word is known. If so, create a command
		// with it. If not, create a "nil" command (for unknown command).
		if (commands.isCommand(word1)) {
			doAction(word1, word2, word3, word4, game);
			return new Command(word1, word2);
		}
		else {
			doAction(word2, word3, word4, " ",game);
			return new Command(null, word2);
		}
	}
		//have all the if statements that link it to the correct methods
		
		/*what this code does is it looks at the commands and checks to see if 
		the following word is applicable
		
		for example u can read a book but you can read a broom
		*/
		public void doAction(String word, String wordTwo, String wordThree, String wordFour, Game game) {
			if(word == CommandWords.validCommands[0]) {
				if(wordTwo == "book") {
					Game.player.read(Item.tools.get("book"));
				}
				else if(wordTwo=="map") {
					Game.player.read(Item.tools.get("map"));
				}
				else if(wordTwo == "leaflet hint") {
					Game.player.read(Item.tools.get("leaflet hint"));
				}
			}
			else if(word == CommandWords.validCommands[2]) {
				if(wordTwo == "game") {
					Game.player.quit(game);
				}
				else if(wordTwo == null) {
					Game.player.quit(game);
				}
			}
			else if(word == CommandWords.validCommands[4]) {
				if(wordTwo == "pie") {
					Game.player.eat(Item.food.get("pie"), Game.currentRoom.getRoomName(Game.currentRoom), Game.playerInven, game);
				}
				else if(wordTwo=="ice cream") {
					Game.player.eat(Item.food.get("ice cream"), Game.currentRoom.getRoomName(Game.currentRoom), Game.playerInven, game);
				}
				else if(wordTwo == "empanada") {
					Game.player.eat(Item.food.get("empanada"), Game.currentRoom.getRoomName(Game.currentRoom), Game.playerInven, game);
				}
				else if(wordTwo == "apple") {
					Game.player.eat(Item.food.get("apple"), Game.currentRoom.getRoomName(Game.currentRoom), Game.playerInven, game);
				}
				else if(wordTwo == "donut") {
					Game.player.eat(Item.food.get("donut"), Game.currentRoom.getRoomName(Game.currentRoom), Game.playerInven, game);
				}
				else if(wordTwo == "cookies") {
					Game.player.eat(Item.food.get("cookies"), Game.currentRoom.getRoomName(Game.currentRoom), Game.playerInven, game);
				}
				else if(wordTwo == "cake") {
					Game.player.eat(Item.food.get("cookies"), Game.currentRoom.getRoomName(Game.currentRoom), Game.playerInven, game);
				}
			}
			else if(word == CommandWords.validCommands[5]) {
				if(wordTwo == "flashlight") {
					Game.player.get(Item.tools.get("flashlight"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "glasses") {
					Game.player.get(Item.tools.get("glasses"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "library" && wordThree == "card") {
					Game.player.get(Item.tools.get("library card"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "backpack") {
					Game.player.get(Item.tools.get("backpack"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "shed" && wordThree == "key") {
					Game.player.get(Item.tools.get("shed key"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "ant farm") {
					Game.player.get(Item.tools.get("ant farm"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "trophy" && wordThree == "1") {
					Game.player.get(Item.tools.get("trophy 1"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "trophy" && wordThree == "2") {
					Game.player.get(Item.tools.get("trophy 2"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "trophy" && wordThree == "3") {
					Game.player.get(Item.tools.get("trophy 3"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "trophy" && wordThree == "4") {
					Game.player.get(Item.tools.get("trophy 4"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "bookshelf" && wordThree == "key") {
					Game.player.get(Item.tools.get("bookshelf key"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "flower") {
					Game.player.get(Item.useless.get("flower"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "tree" && wordThree == "branch") {
					Game.player.get(Item.useless.get("tree branch"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "sand") {
					Game.player.get(Item.useless.get("sand"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "pillow") {
					Game.player.get(Item.useless.get("pillow"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "toy" && wordThree == "truck") {
					Game.player.get(Item.useless.get("toy truck"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "clothes") {
					Game.player.get(Item.useless.get("clothes"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "dirt") {
					Game.player.get(Item.useless.get("dirt"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo=="map") {
					Game.player.get(Item.tools.get("map"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "leaflet" && wordThree == "hint") {
					Game.player.get(Item.tools.get("leaflet hint"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "book") {
					Game.player.get(Item.tools.get("book"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "pie") {
					Game.player.get(Item.food.get("pie"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo=="ice" && wordThree == "cream") {
					Game.player.get(Item.food.get("ice cream"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "empanada") {
					Game.player.get(Item.food.get("empanada"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "apple") {
					Game.player.get(Item.food.get("apple"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "donuts") {
					Game.player.get(Item.food.get("donuts"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "cookies") {
					Game.player.get(Item.food.get("cookies"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "cake") {
					Game.player.get(Item.food.get("cookies"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "water") {
					Game.player.get(Item.drink.get("water"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "milk") {
					Game.player.get(Item.drink.get("milk"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "glass" && wordThree == "of" && wordFour == "water") {
					Game.player.get(Item.drink.get("glass of water"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "glass" && wordThree == "of" && wordFour == "milk") {
					Game.player.get(Item.drink.get("glass of milk"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
			}
			else if(word == CommandWords.validCommands[6]) {
				System.out.println("You used the " + wordTwo);
			}
			else if(word == CommandWords.validCommands[7]) {
				if(wordTwo == "water") {
					Game.player.drink(Item.drink.get("water"));
				}
				else if(wordTwo == "milk") {
					Game.player.drink(Item.drink.get("milk"));
				}
				else if(wordTwo == "glass" && wordThree == "of" && wordFour == "water") {
					Game.player.drink(Item.drink.get("milk"));
				}
			}
			else if(word == CommandWords.validCommands[8]) {
				if(wordTwo == "at") {
					System.out.println("You looked at the " + wordThree);
				}
				else {
					System.out.println("You looked at the " + wordTwo);
				}
				
			}
			else if(word == CommandWords.validCommands[9]) {
				if(wordTwo == "glasses") {
					Game.player.give(Item.tools.get("glasses"));
				}
				else if(wordTwo == "ant farm") {
					Game.player.give(Item.tools.get("ant farm"));
				}
			}
			else if(word == CommandWords.validCommands[10]) {
				Game.player.move(wordTwo);
			}
			else if(word == CommandWords.validCommands[11]) {
				System.out.println("Why do you want to burn something...this is a kids game!");
			}
			else if(word == CommandWords.validCommands[12]) {
				if(wordTwo == "up") {
					Game.player.climb();
				}
			}
			else if(word == CommandWords.validCommands[13]) {
				if(wordTwo == null) {
					Game.teleport();
				}
				else if(wordTwo != null) {
					System.out.println("You can only teleport to the Treehouse");
				}
			}
			else if(word == CommandWords.validCommands[14]) {
				if(wordTwo == "trophy" && wordThree == "1") {
					Game.player.put(Item.tools.get("trophy 1"));
				}
				else if(wordTwo == "trophy" && wordThree == "2") {
					Game.player.put(Item.tools.get("trophy 2"));
				}
				else if(wordTwo == "trophy" && wordThree == "3") {
					Game.player.put(Item.tools.get("trophy 3"));
				}
				else if(wordTwo == "trophy" && wordThree == "4") {
					Game.player.put(Item.tools.get("trophy 4"));
				}
			}
			else if(word == CommandWords.validCommands[15]) {
				if(wordTwo == "trophy" && wordThree == "1") {
					Game.player.place(Item.tools.get("trophy 1"));
				}
				else if(wordTwo == "trophy" && wordThree == "2") {
					Game.player.place(Item.tools.get("trophy 2"));
				}
				else if(wordTwo == "trophy" && wordThree == "3") {
					Game.player.place(Item.tools.get("trophy 3"));
				}
				else if(wordTwo == "trophy" && wordThree == "4") {
					Game.player.place(Item.tools.get("trophy 4"));
				}
			}
			else if(word == CommandWords.validCommands[17]) {
				if(wordTwo == "flashlight") {
					Game.player.get(Item.tools.get("flashlight"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "glasses") {
					Game.player.get(Item.tools.get("glasses"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "library" && wordThree == "card") {
					Game.player.get(Item.tools.get("library card"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "backpack") {
					Game.player.get(Item.tools.get("backpack"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "shed" && wordThree == "key") {
					Game.player.get(Item.tools.get("shed key"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "ant farm") {
					Game.player.get(Item.tools.get("ant farm"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "trophy" && wordThree == "1") {
					Game.player.get(Item.tools.get("trophy 1"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "trophy" && wordThree == "2") {
					Game.player.get(Item.tools.get("trophy 2"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "trophy" && wordThree == "3") {
					Game.player.get(Item.tools.get("trophy 3"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "trophy" && wordThree == "4") {
					Game.player.get(Item.tools.get("trophy 4"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "bookshelf" && wordThree == "key") {
					Game.player.get(Item.tools.get("bookshelf key"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "flower") {
					Game.player.get(Item.useless.get("flower"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "tree" && wordThree == "branch") {
					Game.player.get(Item.useless.get("tree branch"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "sand") {
					Game.player.get(Item.useless.get("sand"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "pillow") {
					Game.player.get(Item.useless.get("pillow"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "toy" && wordThree == "truck") {
					Game.player.get(Item.useless.get("toy truck"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "clothes") {
					Game.player.get(Item.useless.get("clothes"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "dirt") {
					Game.player.get(Item.useless.get("dirt"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo=="map") {
					Game.player.get(Item.tools.get("map"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "leaflet" && wordThree == "hint") {
					Game.player.get(Item.tools.get("leaflet hint"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "book") {
					Game.player.get(Item.tools.get("book"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "pie") {
					Game.player.get(Item.food.get("pie"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo=="ice" && wordThree == "cream") {
					Game.player.get(Item.food.get("ice cream"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "empanada") {
					Game.player.get(Item.food.get("empanada"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "apple") {
					Game.player.get(Item.food.get("apple"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "donuts") {
					Game.player.get(Item.food.get("donuts"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "cookies") {
					Game.player.get(Item.food.get("cookies"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "cake") {
					Game.player.get(Item.food.get("cookies"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "water") {
					Game.player.get(Item.drink.get("water"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "milk") {
					Game.player.get(Item.drink.get("milk"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "glass" && wordThree == "of" && wordFour == "water") {
					Game.player.get(Item.drink.get("glass of water"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
				else if(wordTwo == "glass" && wordThree == "of" && wordFour == "milk") {
					Game.player.get(Item.drink.get("glass of milk"), Game.playerInven, Game.currentRoom.getRoomName(Game.currentRoom), game);
				}
			}
			else if(word == CommandWords.validCommands[18]) {
				if(wordTwo == "flashlight") {
					Game.player.throwObject(Item.tools.get("flashlight"));
				}
				else if(wordTwo == "glasses") {
					Game.player.throwObject(Item.tools.get("glasses"));
				}
				else if(wordTwo == "library" && wordThree == "card") {
					Game.player.throwObject(Item.tools.get("library card"));
				}
				else if(wordTwo == "backpack") {
					Game.player.throwObject(Item.tools.get("backpack"));
				}
				else if(wordTwo == "shed" && wordThree == "key") {
					Game.player.throwObject(Item.tools.get("shed key"));
				}
				else if(wordTwo == "ant farm") {
					Game.player.throwObject(Item.tools.get("ant farm"));
				}
				else if(wordTwo == "trophy" && wordThree == "1") {
					Game.player.throwObject(Item.tools.get("trophy 1"));
				}
				else if(wordTwo == "trophy" && wordThree == "2") {
					Game.player.throwObject(Item.tools.get("trophy 2"));
				}
				else if(wordTwo == "trophy" && wordThree == "3") {
					Game.player.throwObject(Item.tools.get("trophy 3"));
				}
				else if(wordTwo == "trophy" && wordThree == "4") {
					Game.player.throwObject(Item.tools.get("trophy 4"));
				}
				else if(wordTwo == "bookshelf" && wordThree == "key") {
					Game.player.throwObject(Item.tools.get("bookshelf key"));
				}
				else if(wordTwo == "flower") {
					Game.player.throwObject(Item.useless.get("flower"));
				}
				else if(wordTwo == "tree" && wordThree == "branch") {
					Game.player.throwObject(Item.useless.get("tree branch"));
				}
				else if(wordTwo == "sand") {
					Game.player.throwObject(Item.useless.get("sand"));
				}
				else if(wordTwo == "pillow") {
					Game.player.throwObject(Item.useless.get("pillow"));
				}
				else if(wordTwo == "toy" && wordThree == "truck") {
					Game.player.throwObject(Item.useless.get("toy truck"));
				}
				else if(wordTwo == "clothes") {
					Game.player.throwObject(Item.useless.get("clothes"));
				}
				else if(wordTwo == "dirt") {
					Game.player.throwObject(Item.useless.get("dirt"));
				}
				else if(wordTwo=="map") {
					Game.player.throwObject(Item.tools.get("map"));
				}
				else if(wordTwo == "leaflet" && wordThree == "hint") {
					Game.player.throwObject(Item.tools.get("leaflet hint"));
				}
				else if(wordTwo == "book") {
					Game.player.throwObject(Item.tools.get("book"));
				}
				else if(wordTwo == "pie") {
					Game.player.throwObject(Item.food.get("pie"));
				}
				else if(wordTwo=="ice" && wordThree == "cream") {
					Game.player.throwObject(Item.food.get("ice cream"));
				}
				else if(wordTwo == "empanada") {
					Game.player.throwObject(Item.food.get("empanada"));
				}
				else if(wordTwo == "apple") {
					Game.player.throwObject(Item.food.get("apple"));
				}
				else if(wordTwo == "donuts") {
					Game.player.throwObject(Item.food.get("donuts"));
				}
				else if(wordTwo == "cookies") {
					Game.player.throwObject(Item.food.get("cookies"));
				}
				else if(wordTwo == "cake") {
					Game.player.throwObject(Item.food.get("cookies"));
				}
				else if(wordTwo == "water") {
					Game.player.throwObject(Item.drink.get("water"));
				}
				else if(wordTwo == "milk") {
					Game.player.throwObject(Item.drink.get("milk"));
				}
				else if(wordTwo == "glass" && wordThree == "of" && wordFour == "water") {
					Game.player.throwObject(Item.drink.get("glass of water"));
				}
				else if(wordTwo == "glass" && wordThree == "of" && wordFour == "milk") {
					Game.player.throwObject(Item.drink.get("glass of milk"));
				}
			}
			else if(word == CommandWords.validCommands[19]) {
				if(wordTwo == "flashlight") {
					Game.player.drop(Item.tools.get("flashlight"));
				}
				else if(wordTwo == "glasses") {
					Game.player.drop(Item.tools.get("glasses"));
				}
				else if(wordTwo == "library" && wordThree == "card") {
					Game.player.drop(Item.tools.get("library card"));
				}
				else if(wordTwo == "backpack") {
					Game.player.drop(Item.tools.get("backpack"));
				}
				else if(wordTwo == "shed" && wordThree == "key") {
					Game.player.drop(Item.tools.get("shed key"));
				}
				else if(wordTwo == "ant farm") {
					Game.player.drop(Item.tools.get("ant farm"));
				}
				else if(wordTwo == "trophy" && wordThree == "1") {
					Game.player.drop(Item.tools.get("trophy 1"));
				}
				else if(wordTwo == "trophy" && wordThree == "2") {
					Game.player.drop(Item.tools.get("trophy 2"));
				}
				else if(wordTwo == "trophy" && wordThree == "3") {
					Game.player.drop(Item.tools.get("trophy 3"));
				}
				else if(wordTwo == "trophy" && wordThree == "4") {
					Game.player.drop(Item.tools.get("trophy 4"));
				}
				else if(wordTwo == "bookshelf" && wordThree == "key") {
					Game.player.drop(Item.tools.get("bookshelf key"));
				}
				else if(wordTwo == "flower") {
					Game.player.drop(Item.useless.get("flower"));
				}
				else if(wordTwo == "tree" && wordThree == "branch") {
					Game.player.drop(Item.useless.get("tree branch"));
				}
				else if(wordTwo == "sand") {
					Game.player.drop(Item.useless.get("sand"));
				}
				else if(wordTwo == "pillow") {
					Game.player.drop(Item.useless.get("pillow"));
				}
				else if(wordTwo == "toy" && wordThree == "truck") {
					Game.player.drop(Item.useless.get("toy truck"));
				}
				else if(wordTwo == "clothes") {
					Game.player.drop(Item.useless.get("clothes"));
				}
				else if(wordTwo == "dirt") {
					Game.player.drop(Item.useless.get("dirt"));
				}
				else if(wordTwo=="map") {
					Game.player.drop(Item.tools.get("map"));
				}
				else if(wordTwo == "leaflet" && wordThree == "hint") {
					Game.player.drop(Item.tools.get("leaflet hint"));
				}
				else if(wordTwo == "book") {
					Game.player.drop(Item.tools.get("book"));
				}
				else if(wordTwo == "pie") {
					Game.player.drop(Item.food.get("pie"));
				}
				else if(wordTwo=="ice" && wordThree == "cream") {
					Game.player.drop(Item.food.get("ice cream"));
				}
				else if(wordTwo == "empanada") {
					Game.player.drop(Item.food.get("empanada"));
				}
				else if(wordTwo == "apple") {
					Game.player.drop(Item.food.get("apple"));
				}
				else if(wordTwo == "donuts") {
					Game.player.drop(Item.food.get("donuts"));
				}
				else if(wordTwo == "cookies") {
					Game.player.drop(Item.food.get("cookies"));
				}
				else if(wordTwo == "cake") {
					Game.player.drop(Item.food.get("cookies"));
				}
				else if(wordTwo == "water") {
					Game.player.drop(Item.drink.get("water"));
				}
				else if(wordTwo == "milk") {
					Game.player.drop(Item.drink.get("milk"));
				}
				else if(wordTwo == "glass" && wordThree == "of" && wordFour == "water") {
					Game.player.drop(Item.drink.get("glass of water"));
				}
				else if(wordTwo == "glass" && wordThree == "of" && wordFour == "milk") {
					Game.player.drop(Item.drink.get("glass of milk"));
				}
			}		
			else if(word == CommandWords.validCommands[20]) {
				
			}
		}
		
	/**
	 * Print out a list of valid command words.
	 */
	public void showCommands() {
		commands.showAll();
	}
}
