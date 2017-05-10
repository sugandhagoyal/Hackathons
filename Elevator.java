
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Elevator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();
        int c = in.nextInt();
        int m = in.nextInt();
        TreeSet<Person> personSort = new TreeSet<Person>(new PersonComparator());
        int roryHashCode = -1;
        for(int a0 = 0; a0 < n; a0++){
            int id = in.nextInt();
            int t = in.nextInt();
            int f = in.nextInt();
            // your code goes here
            Person p = new Person(id, t, f);
            
            if(a0== m-1)
            	roryHashCode = p.hashCode();
            
            personSort.add(p);
              
        }
        // make soreted list
        Iterator iter = personSort.iterator();
        ArrayList<Person> person = new ArrayList<Person>();
        
        while(iter.hasNext())
        {	
        	Person p = (Person)iter.next();
        	System.out.println(p);
        	person.add(p);
        }
        
        int trip =0;
        int totalTime = 0;
        int waitTime = 0;
        int startTime = 1;
        Person nextPerson = null;
        System.out.println("Rory Hascode : "+ roryHashCode);
        if(roryHashCode == -1)
        	System.out.print(trip + " "+ totalTime);
        
        if(person.size()>0 && person.get(0)!= null){
        	nextPerson = person.get(0);
        	waitTime = waitTime+person.get(0).t+w; // assume that person is in elevator;
         }
        System.out.println("waitTime : "+ waitTime);
        
        totalTime = person.get(0).t;
        boolean foundRory = false;
        while(nextPerson != null && !foundRory){
        	int maxFlr = 0;
        	 System.out.println("waitTime : "+ waitTime);
        	ArrayList<Person> elevator = new ArrayList<Person>();
        	// find people to carry in elevator in one trip
        	ArrayList<EligiblePerson> eligiblePerson = new ArrayList<EligiblePerson>();
        	for(int i=0 ; i<person.size(); i++){
        		if(person.get(i).t<= waitTime){
        			Person p = new Person( person.get(i).id,  person.get(i).t,  person.get(i).f);
        			//eligiblePerson.add(new EligiblePerson(i, p,person.get(i).hashCode()));
        			eligiblePerson.add(new EligiblePerson(i, person.get(i),person.get(i).hashCode()));
        		}
        		else
        			break;
        	}
        	
        	// add Prof first
        	for(EligiblePerson ep: eligiblePerson){
        		if(ep.p.id == 2 && elevator.size()<c){
        			elevator.add(ep.p);
        			//person.remove(ep.index);
        			person.remove(ep.p);
        		}
        	}
        	
        	// add students next
        	for(EligiblePerson ep: eligiblePerson){	
        		if(ep.p.id == 1 && elevator.size()<c){
        			if(ep.personCode == roryHashCode)
        				{foundRory = true;
        					maxFlr = ep.p.f;
        				}
        			elevator.add(ep.p);
        			//person.remove(ep.index);
        			person.remove(ep.p);
        		}
        	}
        	
        	if(!foundRory){
        		for(Person eleP : elevator){
        			// if rory is not found then find max flr for round trip time
        			if(eleP.f > maxFlr)
        				maxFlr = eleP.f;
        		}
        	}
        	totalTime = totalTime+w;
        	if(foundRory)
        		totalTime= totalTime+ maxFlr;
        	else
        		totalTime =totalTime+ 2*maxFlr;
        	trip= trip+1;
        	
        	if(foundRory)
        		nextPerson = null;
        	else
        	{
        		if(person.size()>0 && person.get(0)!= null){
        			nextPerson = person.get(0);
        			waitTime = totalTime+1+w;
        		}
        	}
        }
        
        System.out.print(trip + " "+ totalTime);
        
       	
        
    }
    
    public static class EligiblePerson{
    	int index;
    	Person p;
    	int personCode; 
    	public EligiblePerson(){}
    	public EligiblePerson(int index, Person p, int personCode){
    		this.index = index;
    		this.p = p;
    		this.personCode = personCode;
    	}
    }
    
    public static class Person {
    	int id;
    	int t;
    	int f;
    	public Person(){}
    	public Person(int id, int t, int f){
    		this.id = id;
    		this.t = t;
    		this.f = f;
    	}
    	public String toString(){
    		return "id: "+id + " time: "+t +" floor: "+f +" hashcode: "+ this.hashCode();
    	}
    }
    	
    public static class PersonComparator implements Comparator<Person>{
		@Override
		public int compare(Person arg0, Person arg1) {
			if(arg0.t> arg1.t)
				return 1;
			else
				return -1;
		}    	
    }
    	
    
}