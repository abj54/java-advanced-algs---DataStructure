/* Anwesh Joshi
   TestPerf.java
*/

package cs310;
//import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.SequentialSearchST;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class TestPerf {
  /*
  LinearProbingHashST<String, Integer> lst = new LinearProbingHashST<String, Integer>();
  SequentialSearchST<String, Integer> sst = new SequentialSearchST<String, Integer>();
  ST<String, Integer> st = new ST<String, Integer>();
  SeparateChainingHashST<String, Integer> hst = new SeparateChainingHashST<String, Integer>();
  */

  public static long lstwordcounter(LinearProbingHashST<String, Integer> lst, String[] words) {
     long starttime = System.currentTimeMillis();
     int counter;
     int i;
     for (i=0; i < words.length; i++) {
       String word = words[i];
       if (!lst.contains(word)) {
        lst.put(word,1);
       }
       else {
         counter = lst.get(word);
         lst.put(word, counter+1);
     }
   }
   long endtime =  System.currentTimeMillis();
   return endtime - starttime;
  }


  public static long sstwordcounter(SequentialSearchST<String, Integer> sst, String[] words) {
       long starttime = System.currentTimeMillis();
        int counter;
        int i;
        for (i=0; i < words.length; i++) {
        String  word = words[i];
     if (!sst.contains(word)) {
       sst.put(word,1);
     }
     else {
       counter = sst.get(word);
       sst.put(word, counter+1);
     }
   }
   long endtime =  System.currentTimeMillis();
   return endtime - starttime;
   }


   public static long hstwordcounter(SeparateChainingHashST<String, Integer> hst, String[] words) {
     long starttime = System.currentTimeMillis();
      int counter;
      int i;
      for (i=0; i < words.length; i++) {
      String  word = words[i];
     if (!hst.contains(word)) {
       hst.put(word,1);
     }
     else {
       counter = hst.get(word);
       hst.put(word, counter+1);
     }
   }
   long endtime =  System.currentTimeMillis();
   return endtime - starttime;
   }


   public static long stwordcounter(ST<String, Integer> st, String[] words) {
     long starttime = System.currentTimeMillis();
      int counter;
      int i;
      for (i=0; i < words.length; i++) {
        String word = words[i];
     if (!st.contains(word)) {
       st.put(word,1);
     }
     else {
       counter = st.get(word);
       st.put(word, counter+1);
     }
   }
   long endtime =  System.currentTimeMillis();
   return endtime - starttime;
   }


  public static void main(String[] args) {

      LinearProbingHashST<String, Integer> lst = new LinearProbingHashST<String, Integer>();
      SequentialSearchST<String, Integer> sst = new SequentialSearchST<String, Integer>();
      ST<String, Integer> st = new ST<String, Integer>();
      SeparateChainingHashST<String, Integer> hst = new SeparateChainingHashST<String, Integer>();
      In in = new In(args[0]);
      String [] words = in.readAllStrings();
      //int uhst = 0;
      //long chst = 0;
      //String [] words = file.split("\\s+");
      long lsttimer = lstwordcounter( lst, words);
      long hsttimer = hstwordcounter(hst, words);
      long sttimer = stwordcounter( st, words);
      long ssttimer = sstwordcounter( sst ,words);
      /*for (String s : hst.keys()) {
          //System.out.println(s + " " + hst.get(s));
          uhst++;
          chst +=  hst.get(s);
      }*/
      System.out.println("SeparateChainingHashST time = "+ hsttimer +"ms");
      System.out.println("LinearProbingHashST time  = "+ lsttimer+"ms");
      System.out.println("SequentialSearchST time = "+ ssttimer+"ms");
      System.out.println("Ordered ST time = "+ sttimer+"ms");
     //System.out.println("Unique words="+ uhst);
      //System.out.println("Total words="+ chst);
  }
}
