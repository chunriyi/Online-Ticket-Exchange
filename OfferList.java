/*
 * OfferList.java
 * 
 */
//--------------------------------------------------------------------
// NAME  : April Zhang   
// 
// PURPOSE: Store the info of games that are available
//
//--------------------------------------------------------------------

package Assignment1;

public class OfferList extends GenericList {
	
	// Add transaction info, which includes the game number, numbers of tickets,
	// the team name , and the customer info
	public void addOffer(String[] token, CustomerList customerList) {
		this.addFront(Integer.parseInt(token[1]), 
				Integer.parseInt(token[2]),token[3] + " " + token[4],customerList);
	}
	
	public void addFront(int game, int quantity, String name, CustomerList customerList) {
		Offer newOffer = new Offer(game, quantity, name);
		newOffer.setNext(top);
	}
	
	// Delete the 
	public void deleteOffer(String name) {
		Offer curr = (Offer) top;
		Offer prev = curr;
   
		while (curr != null) {
			if (curr.getName().equals(name)) {
				if (curr == (Offer)top) {
					top = top.getNext();
				} 
				else { // fixed indenting/newline
					prev.setNext(curr.getNext());
				}
			}
			else {
       // only advance the prevNode when there's no match.
				prev = curr;
			}
			curr = (Offer)curr.getNext();
		}
	}
	
	// Search if the team name and customer info exist
	public boolean search(String name, CustomerList customerList) {
		boolean result = false;
		Customer curr = (Customer) customerList.top;
   
		while(curr != null) {
			if(curr.getName().equals(name))
				result = true;
     
			curr = (Customer) curr.getNext();
		}
   
		return result;
	}
 
	public void print() {
		Offer curr = (Offer) top;
		while (curr != null) {
			System.out.print(curr.getName() + " ");
			System.out.print(curr.getQuantity() + " ");
			System.out.println(curr.getGame());
   
			curr = (Offer)curr.getNext();
		}
	}
}
