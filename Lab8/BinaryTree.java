//var 6 | DKrishen
import java.util.ArrayList;

public class BinaryTree {
    Node root;

    ////////////////////////////////////////////////////////////////////////////////////////////////////
   	public void insert (int data){
   		Node newNode = new Node(data);
   		if(root==null)
   			root = newNode;
   		else {
   			Node current = root;
   			Node parent;

   			while(true){
   				parent = current;
   				if(data < current.data){
   					current = current.left;
   					if(current == null){
   						newNode.parent = parent;
   						parent.left = newNode;
   						return;
   					}
   				}
   				else {
   					current = current.right;
   					if(current == null){
   						newNode.parent = parent;
   						parent.right = newNode;
   						return;
   					}
   				}
   			}
   		}
   	}
    ////////////////////////////////////////////////////////////////////////////////////////////////////
   	public Node find(int key){
   		Node current = root;
   		while(current.data != key){
   			if(key < current.data)
   				current = current.left;
   			else
   				current = current.right;
   			if(current == null) 
   				return new Node();
   		}
   		return current;
   	}
    ////////////////////////////////////////////////////////////////////////////////////////////////////
   	private int findSmallestValue(Node root) {
   		return root.left == null ? root.data : findSmallestValue(root.left);
	  }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
   	public void delete(int key){
   		Node current = find(key);

   		if(current != null){
   			if(current.right == null && current.left == null) {    			  				
   				if(current.parent.data > key) current.parent.left = null;
   				else current.parent.right = null;
   			}
   			else if (current.right == null) {
				System.out.println("a: 3");
   				if(current.parent.data > key) current.parent.left = current.left;
   				else current.parent.right = current.left;
   			}
			else if (current.left == null) {
   				if(current.parent.data > key) current.parent.left = current.left;
   				else current.parent.right = current.right;
			}
   			else {
   				int smallestValue = findSmallestValue(current.right);
				delete(smallestValue);
				current.data = smallestValue;
   			}			
   		}
   	}
    ////////////////////////////////////////////////////////////////////////////////////////////////////
   	public void print(int i, Node current, String out){
   		for(int j = 0; j < i; j++) System.out.print("\t");
   		System.out.println(out + current.data);
   		if (current.left != null) print(i+1, current.left, "L: ");
   		if (current.right != null)print(i+1, current.right, "R: ");
   	}
    ////////////////////////////////////////////////////////////////////////////////////////////////////
   	public int depth(int key){	//глубина узла (количество родителей)
  		Node current = find(key);
  		int count = 0;

  		while (current.parent != null){
  			count++;
  			current = current.parent;
  		}
  		
  		return count;
   	}
    ////////////////////////////////////////////////////////////////////////////////////////////////////
   	public static int hightAlgoritm(Node current){
  		if(current.right == null && current.left == null) 			  				
  	   		return 0;
  	   	else if (current.right == null) 
  			return hightAlgoritm(current.left) + 1;
  		else if (current.left == null) 
  			return hightAlgoritm(current.right) + 1;
  	   	else {
  	   		int l = 1 + hightAlgoritm(current.left);
  	   		int r = 1 + hightAlgoritm(current.right);
  	   		return l > r ? l : r;
  	   	}	
   	}
    ////////////////////////////////////////////////////////////////////////////////////////////////////
   	public int hight(int key){	//высота узла  (максимальный путь потомков)
    	Node current = find(key);
    	return hightAlgoritm(current); 
	  }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
   	public int layer(int key){	//уровень узла (разница глубины и высоты)
   		return Math.abs(hight(key) - depth(key));
   	}
    ////////////////////////////////////////////////////////////////////////////////////////////////////
   	public void inOrder(Node localRoot){
   		if(localRoot != null){
   			inOrder(localRoot.left);
   			System.out.print(localRoot.data + " ");
   			inOrder(localRoot.right);
   		}
   	}
    ////////////////////////////////////////////////////////////////////////////////////////////////////
   	public void postOrder(Node localRoot){
   		if(localRoot != null){
   			postOrder(localRoot.left);
   			postOrder(localRoot.right);
   			System.out.print(localRoot.data + " ");
   		}
   	}
    ////////////////////////////////////////////////////////////////////////////////////////////////////
   	public void preOrder(Node localRoot){
   		if(localRoot != null){
   			System.out.print(localRoot.data + " ");
   			preOrder(localRoot.left);
   			preOrder(localRoot.right);
   		}
   	}
    ////////////////////////////////////////////////////////////////////////////////////////////////////
   	public static int maxWay(Node current, String str){
   		int tempFirst = 0;
   		int tempSecond = 0;
   		if(str.equals("parent")){
   			if(current.left != null) tempFirst = maxWay(current.left, "parent");
   			if(current.right != null) tempSecond = maxWay(current.right, "parent");
   		}
   		if(str.equals("left")){
   			if(current.parent != null) tempFirst = maxWay(current.parent, current.data > current.parent.data ? "right" : "left");
   			if(current.right != null) tempSecond = maxWay(current.right, "parent");
   		}
   		if(str.equals("right")){
   			if(current.left != null) tempFirst = maxWay(current.left, "parent");
   			if(current.parent != null) tempSecond = maxWay(current.parent, current.data > current.parent.data ? "right" : "left");
   		}
   		return tempFirst > tempSecond ? tempFirst + 1 : tempSecond + 1;
   	}
    ////////////////////////////////////////////////////////////////////////////////////////////////////
   	public static Node findList(Node current, int key){
   		Node temp = new Node();
   		if(current.left == null && current.right == null && current.data > key)
   			temp = current;
   		else if(current.left == null && current.right != null)
   			temp = findList(current.right, key);
   		else if(current.right == null && current.left != null)
   			temp = findList(current.left, key);
   		else if (current.data > key){
   			temp = findList(current.left, key);
   			if (!temp.exist) 
   				temp = findList(current.right, key);   
   		}
   		else if (current.data < key)
   			temp = findList(current.right, key);
   	return temp;
   	}
    ////////////////////////////////////////////////////////////////////////////////////////////////////
   	public static Node findFirstList(Node current){
   		Node temp = new Node();
   		if (current != null){
   			if(current.left == null && current.right == null)
   				temp = current;
   			else if(current.left == null)
   				temp = findFirstList(current.right);
   			else if(current.right == null)
   				temp = findFirstList(current.left);
   			else 
   				temp = findFirstList(current.left);
   		}
   		return temp;
   	}
    ////////////////////////////////////////////////////////////////////////////////////////////////////
   	public void task(){
   		int maxDepth = hight(root.data);
   		Node maxNode = findFirstList(root);

   		ArrayList<Node> lists = new ArrayList<>();
   		while(maxNode.exist){
   			lists.add(maxNode);
   			maxNode = findList(root, maxNode.data);
   		}

   		maxNode = findFirstList(root);

   		for(int i = 0; i < lists.size(); i++){
   			if(maxWay(lists.get(i), lists.get(i).data > lists.get(i).parent.data ? "right" : "left") >
   			maxWay(maxNode, maxNode.data > maxNode.parent.data ? "right" : "left")) {
   				maxNode = lists.get(i);
   			}
   			else if(maxWay(lists.get(i), lists.get(i).data > lists.get(i).parent.data ? "right" : "left") ==
   			maxWay(maxNode, maxNode.data > maxNode.parent.data ? "right" : "left")) {
   				if(depth(lists.get(i).data) < depth(maxNode.data)){ 
   					maxNode = lists.get(i);
   				}
   			}
   		}
   		delete(maxNode.data);
   	}
}
