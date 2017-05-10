
public class ReplaceToPalindrome {

	public static void main (String args[]){
		replacePalindrome(125331, 1, 6 );
	}
	
	static void replacePalindrome(int val, int maxReplace, int n ){
		if(n%2 != 0)
			System.out.println("not a palindrome");
		int[] arr = new int[n];
		int k = 0 ;
		for(int i=n-1;i>=1;i--){
			arr[n-i-1] = val/(int) Math.pow(10, i);
			System.out.println(arr[n-i-1]);
			val = val%(int) Math.pow(10, i);
		}
		arr[n-1]= val;
		int mid = n/2; 
		int countReplace = 0;
		for(int i = 0 ; i< mid; i++){
			if(arr[mid-1-i] != arr[mid+i]){
				countReplace++;
				if(countReplace>maxReplace)
					System.out.println("invalid");
				else
					arr[mid-1-i]= arr[mid+i];
			}
		}
		if(countReplace>0)
			System.out.println("not a palindrome");
		else
			System.out.println("Is a palindrome");
		for(int a : arr )
			System.out.print(a);
	}
}
