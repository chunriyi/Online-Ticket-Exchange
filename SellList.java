/*
 * OfferList.java
 * 
 */
//--------------------------------------------------------------------
// NAME  : April Zhang   
// 
// PURPOSE: Store the info of transaction
//
//--------------------------------------------------------------------

public class SellList extends GenericList{
  
	public void addSell(String []token) {
		String name ="";
		for(int i=3; i<token.length;i++) {
			name+=token[i];
			if(token.length-i>1)
				name+=" ";
		}
		this.addFront(Integer.parseInt(token[1]), Integer.parseInt(token[2]),name);
	}
	
	public void addFront(int num, int quantity, String name) {

		Sell newSell = new Sell(num, quantity, name);
     
		newSell.setNext(top);
		top = newSell;
	}
 
	public void deleteSellList(String name) {
		Sell curr = (Sell) top;
		Sell prev = curr;
   
		while (curr != null) {
			if (curr.getName().equals(name)) {
				if (curr == (Sell)top)
					top = top.getNext();
				else // fixed indenting/newline
					prev.setNext(curr.getNext());
				
			} 
			else
				// only advance the prevNode when there's no match.
				prev = curr;
			curr = (Sell)curr.getNext();
		}
   
	}
 
	public boolean search(String name, CustomerList buyerlist) {
		boolean result = false;
		Customer curr = (Customer) buyerlist.top;
   
		while(curr != null) {
			if(curr.getName().equals(name))
				result = true;
			curr = (Customer) curr.getNext();
		}
   
		return result;
	}
 
	public void print() {
		Sell curr = (Sell) top;
		while (curr != null) {
			System.out.print(curr.getName() + " ");
			System.out.print(curr.getQuantity() + " ");
			System.out.println(curr.getNum());
   
			curr = (Sell)curr.getNext();
		}
	}
}
