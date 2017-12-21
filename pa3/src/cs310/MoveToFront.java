package cs310;
import edu.princeton.cs.algs4.*;
import java.util.LinkedList;

public class MoveToFront {
    // apply move-to-front encoding, reading from standard input and writing to standard output
   private static int R = 256; 
   
   public static void encode()
{
	int i,j,k;
	LinkedList<Integer> seq = new LinkedList<Integer>();
	for (i = 0; i <R;i++)
		seq.add(i);
	String a = BinaryStdIn.readString();
	char [] in = a.toCharArray();
	for (char c : in) {
		j = seq.indexOf((int) c);
		BinaryStdOut.write( j,8);
		k = seq.remove(j);
		seq.addFirst(k);
	}
	BinaryStdOut.close();
}	
    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode()
{
	int i,j,k;
	LinkedList<Integer> seq = new LinkedList<Integer> ();
	for (i=0;i<R;i++)
		seq.add(i);
	String a = BinaryStdIn.readString();
	char[] in = a.toCharArray();
	for (char c:in) {
		j = seq.remove((int) c);
		BinaryStdOut.write( j,8);
		seq.addFirst(j);
	}
//	System.out.println();
	BinaryStdOut.close();
}
    // if args[0] is '-', apply move-to-front encoding
    // if args[0] is '+', apply move-to-front decoding
    public static void main(String[] args)
{
	if (args[0].equals("-"))
		encode();
	else if (args[0].equals("+"))
		decode();
//	System.out.println("");
}	
	
}
