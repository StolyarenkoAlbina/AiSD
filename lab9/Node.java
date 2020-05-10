
//   < class Node >
//  
//  класс Node реализует
//  вершину кучи


public class Node {
    private static final String BORDER_LINE_RIGHT = "- "; 
    private static final String BORDER_LINE = "|";

    private int value;
    private int degree;
    private Node parent;
    private Node child;
    private Node sibling;

	//	конструктор

    public Node(int value) {
        this.value = value;
    }

    //	геттер значения вершины

    public int getValue() {
        return value;
    }

    //	геттер и сеттер для степени вершины

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    //	сеттеры и геттеры
    //	для родственных связей
    //	вершин в куче.

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }

    public Node getSibling() {
        return sibling;
    }

    public void setSibling(Node sibling) {
        this.sibling = sibling;
    }

    //	преобразование кучи
    //	в строку для вывода
    //	на экран.

    //  
    //    +       x             *             x
    //              (\ /)   *           *       
    //      *       (*•*)         +             *
    //          x   (")(")          *       +   
    //  < а можно мне не в конце кода посидеть? >      
    //

    public String toString(int level) {
        Node current = this;
        StringBuilder result = new StringBuilder();

        while (current != null) {

            result
                .append((BORDER_LINE + " ").repeat(level - 1))
                .append(BORDER_LINE_RIGHT)
                .append(current.value)
                .append("\n");

            if (current.child != null) {
                result.append(current.child.toString(level + 1));
            }

            current = current.sibling;
        }

        return result.toString();
    }
}
