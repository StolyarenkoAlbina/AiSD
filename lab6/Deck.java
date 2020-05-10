//var 6 | DKrishen
public class Deck{
	private List list;

	public Deck(){
		list = new List();
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}
	public void insertLeft(String id){
		list.insertFirst(id);
	}
	public void insertRight(String id){
		list.insertLast(id);
	}
	public String removeLeft(){
		return list.deleteFirst();
	}	
	public String removeRight(){
		return list.deleteLast();
	}	
	public void printLeft(){
		list.printFirst();
	}
	public void printRight(){
		list.printLast();
	}
}
