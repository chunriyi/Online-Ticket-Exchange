/*
 * CustomerList.java
 * 
 */
//--------------------------------------------------------------------
// NAME  : April Zhang   
// 
// PURPOSE: store the customers' information
//          
//
//--------------------------------------------------------------------

public class CustomerList extends GenericList{
	
	public void addCustomer (String[] token) {
		this.addFront(token[1] + " " + token[2]);
	}
 
	public void addFront (String name) {  // add a buyer to the buyer list
		if (!this.search(name)) {
			Customer newName = new Customer(name, top);
			top = newName;
			System.out.println("ADD "+name +" success!");
		}
		else
			System.out.println(name+ " is already in the exchange as a buyer");
	}
 
	//delete customer with this name
	public void deleteCustomer (String[] token) {
		String name = token[1] + " " + token[2];
		Customer curr = (Customer) top;
		Customer prev = curr;
		
		while (curr != null) {
			if (curr.getName().equals(name)) {
				if (curr == (Customer)top) 
					top = top.getNext();
				else
					prev.setNext(curr.getNext());
       
			} 
			else 
				// only advance the prev when there's no match.
				prev = curr;
			curr = (Customer)curr.getNext();
		}
	}
 
	public boolean search(String name) {
		boolean res = false;
		Customer curr = (Customer) top;
  
		while(curr != null) {
			if (curr.getName().equals(name))
				res = true;
   
			curr = (Customer) curr.getNext();
		}
  
		return res;
	}
 
	public void print() {
		Customer curr = (Customer) top;
		while (curr != null) {
			System.out.println(curr.getName());
			curr = (Customer) curr.getNext();
		}
	}	
}
