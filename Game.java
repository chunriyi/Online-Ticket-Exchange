/*
 * Game.java
 * 
 */
//--------------------------------------------------------------------
// NAME  : April Zhang   
// 
// PURPOSE: return the info of games
//          
//
//--------------------------------------------------------------------

package Assignment1;

public class Game extends Node{
  
	private int num;
	private String date;
	private String opponent;
  
	public Game (int num, String date, String opponent) {
		this.num = num;
		this.date = date;
		this.opponent = opponent;
	}
  
	public int getNum() {  // return the game number
		return num;
	}
  
	public String getDate() {  // return the game Date
		return date;
	}
  
	public String getOpponent() {  // return the game Opponent
		return opponent;
	}
}
