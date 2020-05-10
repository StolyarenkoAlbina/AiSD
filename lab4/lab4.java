//var 6 | DKrishen
import java.util.Scanner;

public class lab4{
	public static void PrintMenu(){
		System.out.println();
		System.out.println("\t<====================X====================>");
		System.out.println("\t1 - filling an array with random values - 1");
		System.out.println("\t2 - filling the array with the keyboard - 2");
		System.out.println("\t3 - print array to console              - 3");
		System.out.println("\t4 - select sort                         - 4");
		System.out.println("\t5 - insert sort                         - 5");
		System.out.println("\t6 - bubble sort                         - 6");
		System.out.println("\t7 - quick sort                          - 7");
		System.out.println("\t8 - heap short                          - 8");
		System.out.println("\t9 - program shutdown                    - 9");
		System.out.println("\t<====================X====================>");
		System.out.println();
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = 1; 
		int mas[] = new int[n]; 
		char controlButton;  
		while(true){
			PrintMenu();
			System.out.print(":>> ");
			controlButton = in.next().charAt(0);

			switch (controlButton) {
           	case  ('1'):////////////////////////////////////////////////////////////////////////////////////////////////////
           		System.out.print("Enter the size of the array :>> ");
               	n = in.nextInt();
				mas = new int[n];
				for (int i = 0; i < mas.length; i++) 
    				mas[i] =  (int)((Math.random() * 100)); 
          
				System.out.println("\n\t<Array filled successfully>");
               	break;
           	case ('2'):////////////////////////////////////////////////////////////////////////////////////////////////////
           		System.out.print("Enter the size of the array :>> ");
               	n = Integer.parseInt(in.next());
				mas = new int[n];
           		System.out.print("Enter array elements :>> ");
				for (int i = 0; i < mas.length; i++) 
    				mas[i] = in.nextInt();
				
				System.out.println("\n\t<Array filled successfully>");
               break;
           	case ('3'):////////////////////////////////////////////////////////////////////////////////////////////////////
           	    System.out.print("Array: ");
    	        for (int i = 0; i < mas.length; i++) System.out.print(mas[i] + " ");
	   			System.out.println();
               	break;
           	case ('4'):// select //////////////////////////////////////////////////////////////////////////////////////////////////
           		SelectSort selectSort = new SelectSort();
		        selectSort.sort(mas);

				System.out.println("\n\t<Array sorted successfully>");
           		break;
           	case ('5'):// insert //////////////////////////////////////////////////////////////////////////////////////////////////
           		InsertSort insertSort = new InsertSort();
		        insertSort.sort(mas);

				System.out.println("\n\t<Array sorted successfully>");
           		break;
           	case ('6'):// bubble //////////////////////////////////////////////////////////////////////////////////////////////////
           		BubbleSort bubbleSort = new BubbleSort();
		        bubbleSort.sort(mas);

				System.out.println("\n\t<Array sorted successfully>");
           		break;
           	case ('7'):// quick //////////////////////////////////////////////////////////////////////////////////////////////////
           		QuickSort quickSort = new QuickSort();
		        quickSort.sort(mas, 0, n - 1);

				System.out.println("\n\t<Array sorted successfully>");
           		break;
           	case ('8'):// heap //////////////////////////////////////////////////////////////////////////////////////////////////
		        HeapSort heapSort = new HeapSort();
		        heapSort.sort(mas);

				System.out.println("\n\t<Array sorted successfully>");
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
