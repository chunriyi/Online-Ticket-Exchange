/*
 * Sell.java
 * 
 */
//--------------------------------------------------------------------
// NAME  : April Zhang   
// 
// PURPOSE: return the info of games that are in transaction
//          
//
//--------------------------------------------------------------------

public class Sell extends Node {

	private String name;
	private int num;
	private int qua;
	
	public Sell (int num, int qua, String name) {
	    this.name=name;
	    this.num=num;
	    this.qua = qua;
	}
  
	public String getName() {  
		return name;
	} 
	
	// Get the game number
	public int getNum() {  
		return num;
	}
	
	// Set quantity of games left
	public void setQuantity(int a) {  
		qua = qua-a;
	}
	
	// Get quantity of games left
	public int getQuantity() {  // return the quantity
		return qua;
	}
}
