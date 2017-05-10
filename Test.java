import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.*;

public class Test
{
    public static void main(String args[])
    {
        
            int x = 5;
            {
                 x = 10;
                System.out.println(x);
               IntStream.range(1, 5).forEach(i-> System.out.println(i));
            }
            System.out.println(x);
          for(int var =0 ; var< x; var++){
        	  System.out.println(var);
          }
          for(int var =0 ; var< x; var++){
        	  System.out.println(var);
          }
        /*  Scanner in = new Scanner(System.in);
           String line = in.nextLine();
         String rowCol[]=  line.split(",");
         int row =  Integer.parseInt(rowCol[0]);
         int col =  Integer.parseInt(rowCol[1]);
         for(int i=0; i< row ;i++){
        	 line = in.nextLine();
        	 String rowVal[] = line.split(",");
        	 for(String j : rowVal)
        		 System.out.println(j);
         }*/
         StringBuilder s = new StringBuilder();
         s.append("a").append("b").append(",");
         System.out.println( s.substring(0, s.length()-1));
         
         //System.out.println(s.append("a").append("b").append(","));
    }
}