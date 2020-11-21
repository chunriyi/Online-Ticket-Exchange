/*
 * Customer.java
 * 
 */
//--------------------------------------------------------------------
// NAME  : April Zhang   
// 
// PURPOSE: return the customers' information
//          
//
//--------------------------------------------------------------------

package Assignment1;

public class Customer extends Node {
	
	private String name;

	public Customer(String name, Node next) {
		super(next);
		this.name = name;
	}
	
	public String getName() {   // get the name of the customer
		return name;
	}
	
	public void print() {   // print name of the customer
		System.out.print(name);
	}
}
