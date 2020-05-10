//var 6 | DKrishen
public class Queue{
	private List list;

	public Queue(){
		list = new List();
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}
	public void insert(String id){
		list.insertLast(id);
	}
	public String remove(){
		return list.deleteFirst();
	}	
	public void printFirst(){
		list.printFirst();
	}
	public void printLast(){
		list.printLast();
	}
}
