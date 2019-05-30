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

	public Command getCommand() {
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
			word1 = tokenizer.nextToken(); // get first word
		else
			word1 = null;
		if (tokenizer.hasMoreTokens())
			word2 = tokenizer.nextToken(); // get second word
		else
			word2 = null;
		if (tokenizer.hasMoreTokens())
			word3 = tokenizer.nextToken(); // get third word
		else
			word3 = null;
		if (tokenizer.hasMoreTokens())
			word4 = tokenizer.nextToken(); // get fourth word
		else
			word4 = null;
// note: we just ignore the rest of the input line.
// Now check whether this word is known. If so, create a command
		// with it. If not, create a "nil" command (for unknown command).
		if (commands.isCommand(word1))
			return new Command(word1, word2);
		else
			return new Command(null, word2);
		//After this is dead code. whY>!>>!>..1./??!?!?!??!?!?!??!?!wa;jh weuil fleubg puifhudhoidgrhugvf'ngfofh'hjfuh
			
		//Need something that checks for an adjective
		/*
		String adjective = "ly";
		
		if(word1.substring(word1.length()-1, word1.length())== adjective) {
			
		}
		else if(word1.substring(word1.length()-1, word1.length())== adjective) {
			
		}
		else if(word1.substring(word1.length()-1, word1.length())== adjective) {
			
		}
		else if(word1.substring(word1.length()-1, word1.length())== adjective) {
			
		}
		
		//have all the if statements that link it to the correct methods
		
		//what this code does is it looks at the commands and checks to see if 
		//the following word is applicable
		
		//for example u can read a book but you can read a broom
		
		
		for (int i = 0; i < CommandWords.validCommands.length; i++) {
			if(word1 == CommandWords.validCommands[i]) {
				if(word2 == "book") {
					
				}
				else if(word2=="poster") {
					
				}
			}
			else if(word1 == CommandWords.validCommands[i]) {
				if(word2 == "straight") {
					
				}
			}
		}
		*/
	}	

	/**
	 * Print out a list of valid command words.
	 */
	public void showCommands() {
		commands.showAll();
	}
}
