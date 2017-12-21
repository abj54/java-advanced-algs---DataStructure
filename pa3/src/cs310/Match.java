
package cs310;
//import edu.princeton.cs.algs4.*;

public class Match{
	public static Path match(String a, String b){
//		Path set = new Path();
		int sd,sb,sr;
		int i,j;
		int s1 = a.length();
		int s2 = b.length();
		Path[][]opt = new Path[s1+1][s2+1];
	//	Path init = new Path();
		for (i=0;i<=s1;i++) {
			for (j=0;j<=s2;j++){
			//	opt[i][j]=a;
				opt[i][j] = new Path();
				opt[i][j].row= i;
				opt[i][j].col = j;
			}
		}
		
		opt[s1][s2].cost = 0;
		opt[s1][s2].next = null;
//		init = opt[s1][s2];

		for (i=s1-1;i>=0;i--) 
			opt[i][s2].cost = opt[i+1][s2].cost+2;	
		 for (i=s2-1;i>=0;i--)
                          opt[s1][i].cost = opt[s1][i+1].cost+2;	
		 for (i=s1-1;i>=0;i--) {
			for (j=s2-1;j>=0;j--) {
				sd = opt[i+1][j+1].cost+(a.charAt(i)==b.charAt(j)?0:1);
				sr = opt[i+1][j].cost+2;
				sb = opt[i][j+1].cost+2;
				if (sd<=sr && sd<=sb) {
					opt[i][j].cost = sd;
					opt[i][j].next = opt[i+1][j+1];
				}
				else if(sr<=sd && sr<=sb) {
					opt[i][j].cost = sr;
					opt[i][j].next = opt[i+1][j];
				}
				else {
					opt[i][j].cost = sb;
					opt[i][j].next = opt[i][j+1];
				}

}

}
 return opt[0][0];			
}


public static void main(String[] args) {
          Path path = match("AACAGTTACC", "TAAGGTCA");
          for (Path p = path; p != null; p = p.next)
              System.out.printf(" %d,%d = %d\n",p.row,p.col,p.cost);
      }
}
