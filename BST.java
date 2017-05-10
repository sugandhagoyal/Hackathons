import java.util.Scanner;

public class BST {
	Node root = null;
	public static void insert(Node root, int val){
		Node newNode = new Node(val);
		if (root == null){
			root = newNode;
			return;
		}
		
		Node current = root;
		while(true){
			if(val <= current.val)
			{
				if(current.left == null)
				{
					current.left  = newNode;
					return;
				}
				else
					current = current.left;
			}
			else
				if(val > current.val){
					if(current.right == null)
					{
						current.right = newNode;
						return;
					}
					else
						 current = current.right;
				}
		}		
	}
	
	public static int remove(Node root, int Val){
		// find node and parent 
		
		Node current = root;
		Node parent = root;
		
		while(current.val != Val){
			parent = current; 
			if(Val < current.val)
				current = current.left;
				else 
					if(Val > current.val)
						current = current.right;
			if(current== null)
				return -1;
		}
		
		
		
		// return if root
		if (current == root)
			{
				root = null;
				return 0;
			}
		
		// if left and right sub tree are null then assign null to parent
		if( current.left == null && current.right==null){
			parent = null;
			return 0;
		}
		
		// if right tree is not null and left is null
		// assign parent , node's right tree depending on if node is left or right child of parent
		else if(current.left == null && current.right != null){
			if(parent.left == current)
				parent.left = current.right;
			else if (parent.right == current)
				parent.right = current.right;
			current = null;
			return 0;
		}
		
		// if left tree is not null and right is null
		// assign parent, node's left tree depending on if node is left or right  child of parent
		else if(current.left != null && current.right == null){
			if(parent.left == current)
				parent.left = current.left;
			else
				if(parent.right == current)
					parent.right = current.left;
			current = null;
			return 0;
		}
		// if none of left right children are null
		// find smallest node from right subtree, to substitute the node
		else if( current.left != null && current.right != null){
			Node nextNode= findNextNode(current);
			if(parent.left == current){
				nextNode.left = current.left;
				parent.left = nextNode;
			}
			else
				 if(parent.right == current){
					 nextNode.left = current.left;
					 parent.right = current;
				 }
			return 0;
		}
			
		return -1;
	}
	
	public static Node findNextNode(Node current){
		Node min = current.right;
		Node Parent = current.right;
		while(min.left != null){
			Parent = min;
			min= min.left;
		}
		if(min != Parent) // first right child itself is next node
			Parent.left = null;
		return min;
	}
	public static boolean search ( Node root, int val){
		Node current = root;
		
		while(current.val != val){
			if(val < current.val)
				current = current.left;
			else
				if(val> current.val)
					current = current.right;
			if(current == null)
				return false;
		}
		return true;
	}
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		int nodeCount = scan.nextInt();
		BST tree= new BST();
		for(int i=0; i < nodeCount ; i++){
			int val = scan.nextInt();
			insert(tree.root, val);
		}
		
	}
}
