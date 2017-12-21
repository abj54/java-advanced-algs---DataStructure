

package cs310;
//import edu.princeton.cs.algs4.*;
import java.util.Scanner;
public class Coins {

	private static int[] change;
	private static  int[] previous;
	
	public static int makechange(int T, int[] coins) {
		change = new int[T+1];
		previous = new int[T+1];
		int n = coins.length;
		int i,j,s;
		change[0] = 0;
	//	previous[0] = 0;
		for (i = 1;i<=T;i++) 
			change[i] = Integer.MAX_VALUE;
		for (i=1;i<=T;i++) {
			for (j=0;j<n;j++) {
				if (coins[j]<=i) {
					 s = change[i-coins[j]];
					if (s!=Integer.MAX_VALUE && s+1<change[i]) {	
						change[i] = s+1;
						previous[i] = coins[j];
					}
					}
				}
			}	
		return change[T];	 		
				
	
}
	public static void main(String[] args) {
		int i=0;
		int k = 1;
		Scanner read = new Scanner(System.in);
		int coin;
		int V = read.nextInt();//140;
		//int [] a = {1,10,21,34,70,100};
		read.nextLine();
		String b =read.nextLine();//.split(" ");
		String [] c = b.split(" ");
		int [] a = new int [c.length];
		for (String d: c)
			a[i++] = Integer.parseInt(d);
//		while (read.hasNextInt())
//			a[i++] = read.nextInt();
		read.close();
		int num = makechange(V,a);
		System.out.printf("coins required %d\n",num);
		System.out.println("needed coins are:");
		for (i = 0; i < num;i++) {
			
			coin = previous[V];
			V = V -  previous[V];
			if (coin != previous[V]) {
				System.out.printf("%d x %d is required\n",k,coin);
				k=1;
			}
			else
				k++;
}
//		System.out.println(c[1]);
}
}
