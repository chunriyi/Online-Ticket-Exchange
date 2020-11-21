/*
 * Market.java
 * 
 */
//--------------------------------------------------------------------
// NAME  : April Zhang   
// 
// PURPOSE: Store the info of transaction.
//          
//
//--------------------------------------------------------------------

package Assignment1;

public class Market extends GenericList {
	
	public void addHolder(String[] token) {
		this.addFront(Integer.parseInt(token[token.length-1]), makeName(token));
		System.out.println(token[token.length-1]);
	}
	
	public String makeName(String[] token) {
		String name = "";

		for (int i = 0; i < token.length - 1; i++) {
			name += token[i] + " ";
		} 
		return name;
	}
  
	public void addFront(int num, String name) {  
		Holder newHolder = new Holder(num, name);
		newHolder.setNext(top);
		top = newHolder;
	}
 
 	//compare the number of tickets
 	public boolean compare(String[] token) {
 		boolean result = false;
 		String name = makeName(token);
 		Holder curr = (Holder) top;
  
 		while(curr != null) {
 			if(curr.getName().equals(name) && curr.getNum() >= Integer.parseInt(token[2]))
 				result = true;
 			curr = (Holder) curr.getNext();
 		}
 		return result;
 	}
 
 	//search if we have a holder with this name
 	public boolean search(String[] token) {
 		boolean result = false;
 		String name = makeName(token);
 		Holder curr = (Holder) top;
  
 		while(curr != null) {
 			if (curr.getName().equals(name))
 				result = true;
 			curr = (Holder) curr.getNext();
 		}
 		return result;
 	}
  
 	public void print() {
 		Holder curr = (Holder) top;
 		while (curr != null) {
 			System.out.print(curr.getNum() + " ");
 			System.out.println(curr.getName());
    
 			curr = (Holder)curr.getNext();
 		}
 	}
}
