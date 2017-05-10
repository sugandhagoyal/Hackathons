import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class DeepCopy {
	
	public static void main(String args[]){
		LinkedList<RandomListNode> list = new LinkedList<RandomListNode>();
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		list.add(node1);
		list.add(node2);
		list.add(node3);
		node1.random= node3;
		node2.random= node1; 
		node3.random= node1;	
		deepCopy(list);
	}
	
	public static void deepCopy(LinkedList<RandomListNode> list){
		LinkedList<RandomListNode> newList = new LinkedList<RandomListNode>();
		Hashtable<Integer, RandomListNode> mapNode = new Hashtable<Integer,RandomListNode>();
		Iterator<RandomListNode> iter=  list.iterator();
		while(iter.hasNext()){
			RandomListNode node = iter.next();
			RandomListNode newNode = new RandomListNode(node.label);
			mapNode.put(node.hashCode(),newNode);
			newList.add(newNode);		
		}
		
		iter=  list.iterator();
		Iterator<RandomListNode> iterNew = newList.iterator();
		while(iter.hasNext() && iterNew.hasNext()){
			RandomListNode nextNode = iter.next();
			if(nextNode.random != null){
				int key = nextNode.random.hashCode();
				iterNew.next().random = mapNode.get(key);
			}
		}
		
		iterNew = newList.iterator();
		while(iterNew.hasNext()){
			RandomListNode nextNode = iterNew.next();
			System.out.print( "node val: "+ nextNode.label) ;
			System.out.println( "random val: "+ nextNode.random.label) ;
		}
		
	}
}

class RandomListNode {
	   int label;
	   RandomListNode next, random;
	   RandomListNode(int x) { this.label = x; }
}