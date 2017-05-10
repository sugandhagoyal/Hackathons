import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ShirtSize {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[] sizes = new int[n];
            for(int sizes_i=0; sizes_i < n; sizes_i++){
                sizes[sizes_i] = in.nextInt();
            }
            int v = in.nextInt();
            SizeInterval[] allIntervals= new SizeInterval[v];
            for(int a1 = 0; a1 < v; a1++){
                int smallest = in.nextInt();
                int largest = in.nextInt();
                allIntervals[a1] = new SizeInterval();
                allIntervals[a1].smallest = smallest;
                allIntervals[a1].largest = largest;
            }
            
            TreeSet<Integer> sortSize = new TreeSet<Integer>();
            TreeSet<SizeInterval> sortInterval = new TreeSet<SizeInterval>(new IntervalComparator());
            for(int i=0; i< sizes.length; i++){
           	 sortSize.add(sizes[i]);
            }
            for(int a1 = 0; a1 < v; a1++){
            	sortInterval.add(allIntervals[a1]);
            }
            
            ArrayList<SizeInterval> combineIntervalList = new ArrayList<SizeInterval>();
            SizeInterval[] sortedIntervalList = sortInterval.toArray(new SizeInterval[sortInterval.size()] );
            SizeInterval combineInterval = new SizeInterval(sortedIntervalList[0].smallest, sortedIntervalList[0].largest);
            for(int i=1; i< sortedIntervalList.length; i++ ){
            	if(sortedIntervalList[i].smallest >= combineInterval.smallest && sortedIntervalList[i].smallest <= combineInterval.largest 
            	   && sortedIntervalList[i].largest > combineInterval.largest ){
            		combineInterval.largest = sortedIntervalList[i].largest;
            	}
            	else            		
            	if(sortedIntervalList[i].smallest >= combineInterval.smallest && sortedIntervalList[i].smallest >= combineInterval.largest ){
            		combineIntervalList.add(combineInterval);
            		combineInterval = new SizeInterval(sortedIntervalList[i].smallest, sortedIntervalList[i].largest); 
            	}            		
            }
            combineIntervalList.add(combineInterval);
            
            SizeInterval compareInterval = null;
            Iterator iterCombineList = combineIntervalList.iterator();
            if(iterCombineList.hasNext())
            	compareInterval = (SizeInterval) iterCombineList.next();
            int totalSizeFound = 0;
            for(int i : sortSize){
            	if(compareInterval != null && i>compareInterval.largest && iterCombineList.hasNext())
              	{
              		compareInterval = (SizeInterval) iterCombineList.next();
              	}
            	
              	if(compareInterval != null && i>= compareInterval.smallest && i<= compareInterval.largest)
             		 totalSizeFound ++;
             	
            }
            
            System.out.println(totalSizeFound);
            
        }
        
        
    }
    
    public static class SizeInterval{
    	int smallest;
    	int largest;
    	public SizeInterval(){
    		
    	}
    	public SizeInterval(int small, int large){
    		smallest = small;
    		largest = large;
    	}
    	public String toString(){
    		 return ("smallest :"+ smallest + " largest :"+largest);
    	}
    }
    
    public static class IntervalComparator implements Comparator<SizeInterval>{

    	@Override
    	public int compare(SizeInterval interval1, SizeInterval interval2) {
    		// TODO Auto-generated method stub
    		if(interval1.smallest> interval2.smallest)
    			return 1;
    		else
    			return -1;
    	}
    }
}



