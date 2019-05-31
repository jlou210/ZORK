package com.bayviewglen.zork;

public class Mickey implements Character {
	String description = "Meeska mooska Mickey Mouse! Congratulations pal! You made it to the end of the game! You did mousekamazing ! \n" + 
"If you haven't eaten the cake yet you should try it! It's deeeeelicious!";
	public void speak(){
		System.out.println(description);
	}
}
