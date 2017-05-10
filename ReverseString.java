import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class ReverseString {
	public static void main(String args[]){
		reverse("this is eclipse  ide");
	}
	
	static void reverse(String str){
		
		
		int lastIndexSpace = str.lastIndexOf(' ');
		StringBuffer revStr= new StringBuffer();
		while(lastIndexSpace >-1){
			System.out.println(lastIndexSpace);
			String word = str.substring(lastIndexSpace, str.length());
			revStr.append(word.trim()).append(" ");
			str=str.substring(0,lastIndexSpace);
			lastIndexSpace = str.lastIndexOf(' ');
			HashSet<String> test = new HashSet<String>();
			
		}
		revStr.append(str);
	   System.out.println(revStr);	
	}
}

//this is eclipse ide







