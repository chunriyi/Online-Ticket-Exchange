public class Holder extends Node{
	private String name;
	private int num;
  
	public Holder(int num, String name) {
		this.name=name;
		this.num=num;
	}
  
	public String getName() {  
		return name;
	} 
  
	public int getNum() {  // return the number
		return num;
	}
}
