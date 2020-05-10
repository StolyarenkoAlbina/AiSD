//var 6 | DKrishen
import java.util.Scanner;

class Result {
	public int start;
	public int end;
	public int profit;
};

public class lab3_1{
	public static void PrintMenu(){
		System.out.println();
		System.out.println("\t<====================X====================>");
		System.out.println("\t1 - filling an array with random values - 1");
		System.out.println("\t2 - filling the array with the keyboard - 2");
		System.out.println("\t3 - print array to console              - 3");
		System.out.println("\t4 - array processing (sum output)       - 4");
		System.out.println("\t5 - program shutdown                    - 6");
		System.out.println("\t<====================X====================>");
		System.out.println();
	}
	public static void maxsubarray(int[] arr, int l, int m, int r, Result results)		//нахождение  макс. подмассива, который пересекает среднее значение и сумму его значений
	{
		int leftsum = -99999, sum = 0, maxleft = -1;
		for (int i = m; i >= l; i--)
		{
			sum += arr[i];
			if (sum > leftsum)
			{
				leftsum = sum;
				maxleft = i;
			}
		}
		int rightsum = -99999, maxright = -1;
		sum = 0;
		for (int i = m + 1; i <= r; i++)
		{
			sum += arr[i];
			if (sum > rightsum)
			{
				rightsum = sum;
				maxright = i;
			}
		}
		results.start = maxleft;
		results.end = maxright;
		results.profit = leftsum + rightsum;
	}

	public static void findmaxarray(int[] arr, int l, int r, Result results){		//"разделяй и властвуй"
		if (r == l)	{
			results.start = l;
			results.end = r;
			results.profit = arr[l];
			return;
		}
		else{
			int m = (l + r) / 2;
			findmaxarray(arr, l, m, results);
			int leftlow = results.start;
			int lefthigh = results.end;
			int leftsum = results.profit;
			findmaxarray(arr, m + 1, r, results);
			int rightlow = results.start;
			int righthigh = results.end;
			int rightsum = results.profit;
			maxsubarray(arr, l, m, r, results);
			int crosslow = results.start;
			int crosshigh = results.end;
			int crosssum = results.profit;

			if (leftsum >= rightsum && leftsum >= crosssum){
				results.start = leftlow;
				results.end = lefthigh;
				results.profit = leftsum;
				return;
			}
			else{
				if (rightsum >= leftsum && rightsum >= crosssum){
					results.start = rightlow;
					results.end = righthigh;
					results.profit = rightsum;
					return;
				}
				else{
					results.start = crosslow;
					results.end = crosshigh;
					results.profit = crosssum;
					return;
				}
			}
		}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = 1; 
		int mas[] = new int[n]; 
		char controlButton;  
		Double sum;
		int tempMas[] = new int[n-1];
		Result results = new Res();
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
           	case ('4'):////////////////////////////////////////////////////////////////////////////////////////////////////
           		tempMas = new int[n-1];
				for (int i = 0; i < n - 1; i++)
					tempMas[i] = mas[i + 1] - mas[i];

				int l = 0, r = n - 2;
				findmaxarray(tempMas, l, r, results);

				System.out.println("\n\n\tfirst day: "+results.start+"\n\tsecond day: "+(results.end+1)+"\n\tprofit: "+results.profit);
               	break;
           	case ('5'):////////////////////////////////////////////////////////////////////////////////////////////////////
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
