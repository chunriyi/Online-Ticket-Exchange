package Assignment1;

public class Node {
	private Node next;	
	
	public Node(Node nextItem) {
		next = nextItem;
	}
	
	public Node() {
		next = null;
	}
	
	public void setNext(Node newNext) {
		next = newNext;
	}
	
	public Node getNext() {
		return next;
	}
	
}
