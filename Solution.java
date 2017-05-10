import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        // your code goes here
         String[][] arr = new String [r*3][ c*5];
        for(int i= 0; i<r ; i++){
            for(int j=0; j<c ;j++){
                arr[0+i*3][0+j*5] = ".";
                arr[0+i*3][1+j*5] = ".";
                arr[0+i*3][2+j*5] = "O";
                arr[0+i*3][3+j*5] = ".";
                arr[0+i*3][4+j*5] = ".";
                
                arr[1+i*3][0+j*5] = "O";
                arr[1+i*3][1+j*5] = ".";
                arr[1+i*3][2+j*5] = "o";
                arr[1+i*3][3+j*5] = ".";
                arr[1+i*3][4+j*5] = "O";
                
                arr[2+i*3][0+j*5] = ".";
                arr[2+i*3][1+j*5] = ".";
                arr[2+i*3][2+j*5] = "O";
                arr[2+i*3][3+j*5] = ".";
                arr[2+i*3][4+j*5] = ".";
                
            }
        }
        
        for(int i=0; i<r*3;i++){
            for(int j=0;j< c*5; j++)
                System.out.print(arr[i][j]);
            System.out.print("\n");
        }
       
    }
}
