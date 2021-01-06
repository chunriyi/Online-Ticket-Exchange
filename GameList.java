/*
 * GameList.java
 * 
 */
//--------------------------------------------------------------------
// NAME  : April Zhang   
// 
// PURPOSE: Store the information of games.
//          
//
//--------------------------------------------------------------------

public class GameList extends GenericList{
	
	public void addGame(String[] token) {
		String opponent = "";
		//make up a long name
		for(int i = 2; i < token.length; i++) {
			opponent += token[i] + " ";
		}
		this.addFront(Integer.parseInt(token[0]), token[1], opponent);
//		System.out.println(token[0] + " " + token[1] + " " + opponent);
	}
	
	public void addFront(int num, String date, String opponent) {
		Game newGame = new Game(num, date,opponent);
		newGame.setNext(top);
		top = newGame;
	}
	
	//search if the game number exist
	public boolean search(int num) {
		boolean result = false;
		Game curr = (Game) top;
  
		while(curr != null) {
			if (curr.getNum() == num)
				result = true;
   
			curr = (Game) curr.getNext();
		}
		return result;
	}
 
	public void print() {
		Game curr = (Game) top;
		while (curr != null) {
			System.out.println(curr.getNum() + " " + curr.getDate() + " " + curr.getOpponent());
			curr = (Game)curr.getNext();
		}
	}
}
