package com.bayviewglen.zork;

public class Dora implements Character{
	String description = "Hola niños! Bienvinido a Zork: Childhood Recollection! Estamos en mi casa ahora mismo. Oh. \n "
			+ "You don't speak Spanish? Well, you should start learning some. Anyways, try looking around for some items that might help you on your adventure. Buena suerte!";
	public void speak(){
		System.out.println(description);
	}
}
