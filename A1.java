/*
 * A1.java
 *
 * Main class
 * 
 */
//--------------------------------------------------------------------
// NAME  : April Zhang   
// 
// PURPOSE: The main file of my program.
//          
//
//--------------------------------------------------------------------

package Assignment1;

import java.io.*;

// GameList is InventoryList
// BuyerList is CustomerList
// OfferList is TransactionList
// SellList is InventoryList

public class A1 {
	public static void main(String[] args) {
    // read games.txt file
    BufferedReader gamesFile = File.openInputFile("games.txt");
    String line = File.getLine(gamesFile);
    String[] token = line.split(" ");
    GameList gameList = new GameList(); 
    
    // import games.txt to gameList
    while (line != null) {
    	token = line.split(" ");
        if (line.charAt(0) == '#')
        	System.out.println(line);
        else 
        	gameList.addGame(token);
        line = File.getLine(gamesFile);
    }

   
   //read ticketHolders.txt file
   gamesFile = File.openInputFile("ticketHolders.txt");
   line = File.getLine(gamesFile);
   token = line.split(" ");
   Market holderList = new Market();
   
   // import ticketHolders.txt to holderList
   while (line != null) {
	   token = line.split(" ");
	   if (line.charAt(0) == '#')
		   System.out.println(line);
	   else 
		   holderList.addHolder(token);
	   line = File.getLine(gamesFile);
   }
   
   File.closeFile(gamesFile);

   // use test0X.txt to test the program
   gamesFile = File.openInputFile("test04.txt");
   
   CustomerList customerList = new CustomerList();
   OfferList offerList = new OfferList();
   SellList sellList = new SellList();
   // Event processing loop.
   line = File.getLine(gamesFile);
  
   token = line.split(" ");
   
   while (line != null) {
	   token = line.split(" ");
	   if (line.charAt(0) == '#')
		   System.out.println(line);
	   else if (token[0].equals("ADD"))  // add a new ticket buyer to the exchange
		   customerList.addCustomer(token);
	   else if (token[0].equals("BUY")) {   // a buyer offers to buy tickets
		   if (offerList.search(token[3] + " " + token[4], customerList)) {
			   if(gameList.search(Integer.parseInt(token[1]))) {   // if the game number exists
				   offerList.addOffer(token, customerList);
				   System.out.println(line+ " succeed");
			   }
			   else
				   System.out.println(line+" is not a valid game number");
		   }
		   else {
			   if (!gameList.search(Integer.parseInt(token[1])))
				   System.out.println(line+ " both game and member invalid");
			   else
				   System.out.println(line +" is not a member of the exchange");
		   }
	   }
	   
	   else if(token[0].equals("CAN")) {   // a buyer cancels an offer to buy tickets
		   if (offerList.search(token[2] + " " + token[3], customerList)) {
			   if(gameList.search(Integer.parseInt(token[1]))){
				   offerList.deleteOffer(token[2] + " " + token[3]);
				   System.out.println(line +" succed!");
			   }
			   else
				   System.out.println(line+" is not a valid game number");
		   }
		   else {
			   if (!gameList.search(Integer.parseInt(token[1])))
				   System.out.println(line+ " both game and member invalid");
			   else
				   System.out.println(line +" is not a member of the exchange");
		   }
	   }
	   
	   else if (token[0].equals("REM")) {   // a buyer removes her account from the exchange
		   if (customerList.search(token[1] + " " + token[2])) {
			   customerList.deleteCustomer(token);
			   System.out.println(line+ " succeed");
		   }
		   else {
			   System.out.println(line +" is not a buyer in the exchange");
		   }
    
	   }
	    else if (token[0].equals("SEL")) {   // a season ticket holder offers ticket for sale
      
		    if (gameList.search(Integer.parseInt(token[1]))) {
			    if (holderList.compare(token)){
          
				    if (holderList.search(token)){
					   sellList.addSell(token);
					   System.out.println(line+ " succeed");
				    }
				    else 
					   System.out.println(line + " is not a ticket holder.");
			   	}
			    else {
			    	System.out.println(line+ " is more than the number owned by the ticket holder");
			    } 
		    }
		    else
		    	System.out.println(line+" is not a valid game number");
	    }
	   	line = File.getLine(gamesFile);
   	} // while
   
	randomAssign(offerList,sellList);
	File.closeFile(gamesFile);
	
	//System.out.println("Buyers--------------------------------");
	//buyerList.print();
    //System.out.println("Offers--------------------------------");
    //offerList.print();
    //System.out.println("      --------------------------------");
    //gameList.print();
    //System.out.println("--------------------------------");
    //sellList.print();
    System.out.println("\n\nEnd of processing.");
    //System.exit(0);
 }  // main
	
	
	/* Two nested for loop doing comparison between OfferList and SellList
	 * 
	 */
	 public static void randomAssign(OfferList offer, SellList sell) {
		 Offer theOffer = (Offer) offer.top; 	
		 
		 while (theOffer != null) {
			 Sell theSell = (Sell) sell.top;
			 
			 while (theSell != null) {
				 // If theSell and theOffer have the same game number, and the quantity of games left for theOffer is smaller or equal to
				 // that of theSell
				 
				 if (theSell.getNum() == theOffer.getGame() && theOffer.getQuantity() <= theSell.getQuantity()) {
					 System.out.println("Assign BUY " + theOffer.getQuantity() + " tickets from " + theOffer.getName() + " to " + theSell.getName() + "!");
					 // theOffer cannot offer more tickets if the numbers of tickets available is smaller than the numbers of tickets needed.
					 theSell.setQuantity(theOffer.getQuantity());
					 offer.deleteOffer(theOffer.getName());
					 
					 if (theOffer.getQuantity() == theSell.getQuantity())
						 sell.deleteSellList(theSell.getName());
				 }
				 theSell = (Sell) theSell.getNext();
			 }
			 theOffer = (Offer) theOffer.getNext();
		 }
	 }
} // class A1

