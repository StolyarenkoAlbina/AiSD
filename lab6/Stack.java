//var 6 | DKrishen
public class Stack{
	private List list;

	public Stack(){
		list = new List();
	}
	public void push(String id){
		list.insertFirst(id);
	}
	public String pop(){
		return list.deleteFirst();
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}
	public void print(){
		list.printFirst();
	}
}
