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
		//Need something that checks for an adjective
		String adjective = "ly";
				
		if(word1.substring(word1.length()-1, word1.length())== adjective) {
					
		}
		else if(word1.substring(word1.length()-1, word1.length())== adjective) {
					
		}
		else if(word1.substring(word1.length()-1, word1.length())== adjective) {
					
		}
		else if(word1.substring(word1.length()-1, word1.length())== adjective) {
				
		}
// Now check whether this word is known. If so, create a command
		// with it. If not, create a "nil" command (for unknown command).
		if (commands.isCommand(word1)) {
			doAction(word1, word2, game);
			return new Command(word1, word2);
		}
		else {
			doAction(word2, word3, game);
			return new Command(null, word2);
		}
	}
		//have all the if statements that link it to the correct methods
		
		/*what this code does is it looks at the commands and checks to see if 
		the following word is applicable
		
		for example u can read a book but you can read a broom
		*/
		public void doAction(String word, String wordTwo, Game game) {
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
			else if(word == CommandWords.validCommands[1]) {
				if(wordTwo == "straight") {
					
				}
			}
			else if(word == CommandWords.validCommands[2]) {
				
			}
			else if(word == CommandWords.validCommands[3]) {
				
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
			}
			else if(word == CommandWords.validCommands[5]) {
								
			}
			else if(word == CommandWords.validCommands[6]) {
				
			}
			else if(word == CommandWords.validCommands[7]) {
				
			}
			else if(word == CommandWords.validCommands[8]) {
				
			}
			else if(word == CommandWords.validCommands[9]) {
				
			}
			else if(word == CommandWords.validCommands[10]) {
				
			}
			else if(word == CommandWords.validCommands[11]) {
				
			}
			else if(word == CommandWords.validCommands[12]) {
				
			}
			else if(word == CommandWords.validCommands[13]) {
				
			}
		}
		
	/**
	 * Print out a list of valid command words.
	 */
	public void showCommands() {
		commands.showAll();
	}
}
