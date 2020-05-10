//var 6 | DKrishen

public class Node {
	Node parent;
    int data;
    Node left;
    Node right;
    boolean exist;

    Node(int value) {
        this.data = value;
        right = null;
        left = null;
        parent = null;
        exist = true;
    }
    Node() {
        data = 0;
        right = null;
        left = null;
        parent = null;
        exist = false;
    }
}
