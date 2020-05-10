//var 6 | DKrishen
public class List{
	private Link first;
	private Link last;

	public List(){
		first = null;
		last = null;
	}
	public boolean isEmpty(){
		return first == null;
	}
	public void insertLast(String id){
		Link newLink = new Link(id);
		if(isEmpty()) first = newLink;
		else last.next = newLink;
		last = newLink;
	}
	public void insertFirst(String id){
		Link newLink = new Link(id);			
		newLink.next = first;
		first = newLink;
	}
	public String deleteLast(){/////////////////////////////////////////////
		Link current = first;
		String temp = "";
		while(current.next != null){
			if(current.next.next == null) {
				temp = current.next.id;
				current.next = null;
				last = current;
				return temp;
			}
			current = current.next;
		}	
		return temp;
	}
	public String deleteFirst(){
		String temp = first.id;
		if(first.next == null) last = null;
		first = first.next;
		return temp;
	}
	public void printFirst(){
		System.out.print(first.id);
	}
	public void printLast(){
		System.out.print(last.id);
	}

}
