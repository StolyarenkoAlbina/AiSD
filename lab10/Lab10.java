//var 6 | DKrishen
import java.util.Scanner;

//	 < class Lab10 >
//	
//	класс Lab10 предоставляет
//	интерфейс для взаимодействия
//	с классом Graph
//	
//	Я не знаю, что тут можно
//	объяснять, поэтому просто
//	пожелаю здоровья)
//	

public class Lab10{	
	public static void printMenu(){
		System.out.println();
		System.out.println("\t<==========X===========>");
		System.out.println("\t1 - add envelope     - 1");
		System.out.println("\t2 - add postcard     - 2");
		System.out.println("\t3 - create edges     - 3");
		System.out.println("\t4 - print graph      - 4");
		System.out.println("\t5 - task             - 5");
		System.out.println("\t9 - program shutdown - 9");
		System.out.println("\t<==========X===========>");
		System.out.println();
	}
	public static void main(String[] args){
		Graph graph = new Graph();
		char vertexName = 'a';
		Scanner in = new Scanner(System.in);
		char controlButton;  

		while(true){
			printMenu();
			System.out.print(":>> ");
			controlButton = in.next().charAt(0);

			switch (controlButton) {
           	case  ('1'):////////////////////////////////////////////////////////////////////////////////////////////////////
                System.out.print("\tEnter envelope sizes\n\t:>> ");
                double eW = in.nextInt();
                double eH = in.nextInt();
               	graph.addEnvelope(vertexName++,eW,eH);
				          
				System.out.println("\n\t<envelope add successfully>");
               	break;
           	case ('2'):////////////////////////////////////////////////////////////////////////////////////////////////////
           		System.out.print("\tEnter postcard sizes\n\t:>> ");
                double pW = in.nextInt();
                double pH = in.nextInt();
               	graph.addPostcard(vertexName++,pW,pH);
				          
				System.out.println("\n\t<envelope add successfully>");
                break;
           	case ('3'):////////////////////////////////////////////////////////////////////////////////////////////////////
                graph.createEdges();				          
				System.out.println("\n\t<edges create successfully>");
               	break;
           	case ('4'):////////////////////////////////////////////////////////////////////////////////////////////////////
				graph.printVertex();
				graph.printEdges();
               	break;
           	case ('5'):////////////////////////////////////////////////////////////////////////////////////////////////////
			   	System.out.println("\t" + graph.task(0));
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

	//			(\ /)
	//			(*•*)	
	//			(")(")
	//	<спасибо за внимание!>
