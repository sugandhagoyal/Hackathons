import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class FindSubstring {

	public static void main (String [] args){
		findString("dbaaac");
	}
	
	static List<String> findString(String str){
		System.out.println("length"+ str.length());
		TreeSet<String> tSet = new TreeSet<String>();
		List<String> subStr = new ArrayList<String>();
		for(int i = 0 ; i< str.length(); i++){
			for(int j =i ; j<=str.length(); j++){
				System.out.println(str.substring(i,j));
				tSet.add(str.substring(i,j));
			}
		}
		
		System.out.println("sorted order");
		Iterator iter =  tSet.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		return subStr;
	}
}
