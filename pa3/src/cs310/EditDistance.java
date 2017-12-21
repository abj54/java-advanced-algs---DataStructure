package cs310;
//import edu.princeton.cs.algs4.*;
import java.util.Scanner;
public class EditDistance {
	public static void main(String[]args) {
	//	String []s1 = StdIn.readAllLines(); 
		int i,j = 0;
	//	String[] s = {"GGGAATCACGAGAGCAGACAGATCACACAGGTTTATGGGTTCTACGACGAGTGTTTAGGGAATCATGAGAGCAGACGATCACACAAGTTTATGGTTTCTATGATGAATGTTTA" ,"TAAGGTCA"};
	//	String[] s = {"GGGAATCACGAGAGCAGACAGATCACACAGGTTTATGGGTTCTACGACGAGTGTTTA","GGGAATCATGAGAGCAGACGATCACACAAGTTTATGGTTTCTATGATGAATGTTTA"};
		Scanner read = new Scanner(System.in);
		String[] s = new String[2];//{"AACAGTTACC","TAAGGTCA"};
		while (j<2)
			s[j++] = read.nextLine(); 
		read.close();
		Path a =  Match.match(s[0],s[1]);
		String s1 = s[0].concat(" ");
		String s2 = s[1].concat(" ");
		System.out.printf("Edit distance = %d\n", a.cost);	
		for (Path p = a;p.next!=null;p=p.next) {
			System.out.printf("%s ",s1.charAt(p.row));
			System.out.printf("%s ",(p.col == p.next.col)?"-":s2.charAt(p.col));
			System.out.printf("%d\n",p.cost-p.next.cost); 
			
}
}
} 
