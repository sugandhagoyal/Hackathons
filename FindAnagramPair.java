import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindAnagramPair {
	public static void main (String args[]){
		//findPair("abba");
		findPair("ifailuhkqq");
	}
	static int findPair(String str){
		List<String> listSubStr = new ArrayList<String>();
		HashSet<String> hashSubStr = new HashSet<String>(); 
		int countPair = 0;
		for(int i = 0 ; i< str.length(); i++){
			for(int j =i+1 ; j<=str.length(); j++){
				String subStr = str.substring(i,j);
				char[] subCharArr =   subStr.toCharArray();
				Arrays.sort(subCharArr);
				String morphedSubStr = String.valueOf(subCharArr);
				if(hashSubStr.contains(morphedSubStr)){
					countPair++;
					System.out.println("found : "+ subStr);
				}
				else
				{
					hashSubStr.add(morphedSubStr);
				}
			}
		}
		
		System.out.println("pairs: "+ countPair);
		return countPair;
	}
}
