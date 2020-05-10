//var 6 | DKrishen
import java.util.Scanner;

public class Lab8{	
	public static void printMenu(){
		System.out.println();
		System.out.println("\t<==========X===========>");
		System.out.println("\t1 - insert node      - 1");
		System.out.println("\t2 - print tree       - 2");
		System.out.println("\t3 - find node        - 3");
		System.out.println("\t4 - delete node      - 4");
		System.out.println("\t5 - order            - 5");
		System.out.println("\t6 - node analysis    - 6");
		System.out.println("\t9 - program shutdown - 9");
		System.out.println("\t<==========X===========>");
		System.out.println();
	}
	public static void main(String[] args){
		BinaryTree tree = new BinaryTree();
		Scanner in = new Scanner(System.in);
		char controlButton;  
		while(true){
			printMenu();
			System.out.print(":>> ");
			controlButton = in.next().charAt(0);

			switch (controlButton) {
           	case  ('1'):////////////////////////////////////////////////////////////////////////////////////////////////////
                System.out.print("Enter node :>> ");
               	tree.insert(in.nextInt());
				          
				System.out.println("\n\t<node add successfully>");
               	break;
           	case ('2'):////////////////////////////////////////////////////////////////////////////////////////////////////
           		tree.print(0, tree.root, "\nRoot: ");
                break;
           	case ('3'):////////////////////////////////////////////////////////////////////////////////////////////////////
                System.out.print("Enter key :>> ");
               	boolean check = tree.find(in.nextInt()).exist;
				          
				System.out.println(check ? "\n\t<node find successfully>" : "\n\t<node not found>");
               	break;
           	case ('4'):////////////////////////////////////////////////////////////////////////////////////////////////////
				System.out.print("Enter node :>> ");
               	tree.delete(in.nextInt());
				          
				System.out.println("\n\t<node add successfully>");
               	break;
           	case ('5'):////////////////////////////////////////////////////////////////////////////////////////////////////
			   		System.out.println("\nright : ");
					tree.preOrder(tree.root);
			   		System.out.println("\nreverse : ");
					tree.postOrder(tree.root);
			   		System.out.println("\nsimmetric : ");
					tree.inOrder(tree.root);
               	break;
            case ('6'):////////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.print("Enter node :>> ");
                  int tempKey = in.nextInt();
            System.out.println("depth: " + tree.depth(tempKey));
            System.out.println("hight: " + tree.hight(tempKey));
            System.out.println("layer: " + tree.layer(tempKey));
                break;
            case ('7'):////////////////////////////////////////////////////////////////////////////////////////////////////
                  tree.task();
                break;
           	case ('9'):////////////////////////////////////////////////////////////////////////////////////////////////////
           	    System.out.println("\t<Program shutdown>\n");
           		System.exit(0);
              	break;
           	default:////////////////////////////////////////////////////////////////////////////////////////////////////
               	System.out.println("\t<ERROR> unknown button <ERROR>");
               break;
       		}
		}

	}
}
