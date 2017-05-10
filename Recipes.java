import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Recipes {
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int q = in.nextInt();
	    for(int a0 = 0; a0 < q; a0++){
	        int r = in.nextInt(); // recipes
	        int p = in.nextInt(); // ingredients
	        int n = in.nextInt(); // dishes to prep
	        int m = in.nextInt(); // available
	        int[] pantry = new int[m];
	        for(int pantry_i=0; pantry_i < m; pantry_i++){
	            pantry[pantry_i] = in.nextInt();
	        }
	        int[] cost = new int[p];
	        for(int cost_i=0; cost_i < p; cost_i++){
	            cost[cost_i] = in.nextInt();
	        }
	        int[][] recipe = new int[r][p];
	        for(int recipe_i=0; recipe_i < r; recipe_i++){
	            for(int recipe_j=0; recipe_j < p; recipe_j++){
	                recipe[recipe_i][recipe_j] = in.nextInt();
	            }
	        }
	        // your code goes here
/*	        // Set cost of available ing to 0
	        for(int pantry_i=0; pantry_i < m; pantry_i++){
	           int ingNum=   pantry[pantry_i] ;
	           cost[ingNum] = 0;
	        }
	        ArrayList<Double> recCost = new ArrayList<Double>(); 
	        for(int recipeI =0;recipeI< r; recipeI++){
	        	Double totCost = 0.0;
	        	for(int ingJ=0 ; ingJ <p ; ingJ++){
	        		totCost = totCost+ (recipe[recipeI][ingJ] *cost[ingJ]  );
	        	}
	        	recCost.add(totCost);
	        }
	        recCost.sort(null);
	        Double findMin=0.0;
	        for(int i=0;i<n;i++)
	        	findMin= findMin+recCost.get(i);
	        System.out.println(findMin);*/
	        
	        
	        // Set cost of available ing to 0
	        double totalCostNRecp =0;
	        ArrayList<Integer> alreadyCalRecp = new ArrayList<Integer>();
	        for(int recp=0; recp<n; recp++){
	        
	        for(int pantry_i=0; pantry_i < m; pantry_i++){
	           int ingNum=   pantry[pantry_i] ;
	           cost[ingNum] = 0;
	        }
	        double minCost = 9999999999.9;
	        int mincostRecp = -1;
	        for(int recipeI =0;recipeI< r; recipeI++){
	        	double totCost = 0.0;
	        	if(!alreadyCalRecp.contains(recipeI))
	        	{
	        		for(int ingJ=0 ; ingJ <p ; ingJ++){
	        		totCost = totCost+ (recipe[recipeI][ingJ] *cost[ingJ]  );
	        		}
	        		if(totCost< minCost){	
	        			minCost= totCost;
	        			mincostRecp = recipeI;
	        		}
	        	}
	        }
	        totalCostNRecp = totalCostNRecp+minCost;
	        for(int ingJ=0 ; ingJ <p ; ingJ++){
	        	if(recipe[mincostRecp][ingJ] == 1)
	        		cost[ingJ]=0;
	        }
	        alreadyCalRecp.add(mincostRecp);
	        }
	        System.out.println(totalCostNRecp);
	    }
	}
}
