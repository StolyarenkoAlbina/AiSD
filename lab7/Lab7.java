//var 6 | DKrishen
import java.util.Scanner;

public class Lab7{	
	public static void printMenu(){
		System.out.println();
		System.out.println("\t<==========X===========>");
		System.out.println("\t1 - insert elem      - 1");
		System.out.println("\t2 - print table      - 2");
		System.out.println("\t3 - find elem        - 3");
		System.out.println("\t9 - program shutdown - 9");
		System.out.println("\t<==========X===========>");
		System.out.println();
	}
	public static void main(String[] args){
		HashTable table = new HashTable();
		Scanner in = new Scanner(System.in);
		char controlButton;  

		while(true){
			printMenu();
			System.out.print(":>> ");
			controlButton = in.next().charAt(0);

			switch (controlButton) {
           	case  ('1'):////////////////////////////////////////////////////////////////////////////////////////////////////
                System.out.print("Enter elem :>> ");
               	table.insert(in.next());
				          
				System.out.println("\n\t<student add successfully>");
               	break;
           	case ('2'):////////////////////////////////////////////////////////////////////////////////////////////////////
           		table.print();
                break;
           	case ('3'):////////////////////////////////////////////////////////////////////////////////////////////////////
				System.out.print("Enter elem :>> ");
               	
				System.out.print("\n" + table.find(in.next()));
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
