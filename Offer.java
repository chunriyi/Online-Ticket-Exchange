/*
 * Offer.java
 * 
 */
//--------------------------------------------------------------------
// NAME  : April Zhang   
// 
// PURPOSE: return the info of games that are available
//          
//
//--------------------------------------------------------------------

package Assignment1;

public class Offer extends Node {
	private int game; // game number
	private int quantity; // how many tickets are wanted
	private String name; // name of the ticket holder
	
	public Offer (int game, int quantity, String name){
		this.game = game;
		this.quantity = quantity;
		this.name= name;
	}
	
	public int getGame() {  // get the game number
		return game;
	}
	
	public int getQuantity() {  // get how many ticket are wanted
		return quantity;
	}
	
	public String getName() {  // get the name of the ticket holder
		return name;
	}	
}
