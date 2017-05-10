import java.util.Scanner;
import java.util.stream.IntStream;

public class FindLeaves {
 public static void main(String args[]){
	 Scanner in = new Scanner(System.in);
	 System.out.println("Number of inputs");
	 int inputSize =  in.nextInt();
	 int[] tree = new int[inputSize];
	 IntStream.rangeClosed(0, inputSize-1).forEach(i -> tree[i] = in.nextInt());
	 IntStream.rangeClosed(0, inputSize-1).forEach(i -> System.out.println(tree[i]));
	 FindLeaves leaf = new FindLeaves();
	 leaf.FindAllLeaves(tree, 0, inputSize-1);
	 
 }
 
 	void FindAllLeaves(int[] tree, int parentIndex, int lastIndex){
 		if(parentIndex != lastIndex){
 			int index = -1;
 			
 			// find next max 
 			// has only left subtree
 			if(index == -1)
 			{	
 				index = lastIndex;
 				FindAllLeaves(tree, parentIndex+1, index);
 			}
 			
 			else if(index){
 				
 			}
 			}
 			
 		}
 	}
}
