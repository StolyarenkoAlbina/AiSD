//var 6 | DKrishen
import java.util.Scanner;

class point
{
	int dx;
	int dy;

	public point (int x, int y){
		dx = x;
		dy = y;
	}
}

public class lab3_2{
	public static int step(int n, int x0, int y0, int c, int[][] a, point[] moves)	{
		for (int i = 0; i < 8; i++){
			int x = x0 + moves[i].dx;
			int y = y0 + moves[i].dy;
			if (x >= 0 && x < n && y >= 0 && y < n && a[x][y] == 0){
				c++;
				a[x][y] = c;
				c = step(n, x, y, c, a, moves);
			}
		}
		return c;
	}

	public static void main(String[] args){
		point[] moves =	{
			new point(-1 , -2),
			new point(1 , -2),
			new point(-2 , -1),
			new point(2 , -1),
			new point(-2 , 1),
			new point(2 , 1),
			new point(-1 , 2),
			new point(1 , 2)
		};
        
        System.out.print("\n\tEnter the size of the chess board \n\t:>> ");

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        System.out.println();

		int[][] a = new int[n][n];
		int c = 1;
		a[0][0] = 1;

		step(n, 0, 0, c, a, moves);
		for (int i = 0; i < n; i++)	{
			System.out.print("\t");
			for (int j = 0; j < n; j++)
				System.out.print(a[i][j] + "\t");
			System.out.println();
		}
		System.out.println();
	}
}
