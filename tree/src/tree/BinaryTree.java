package tree;
import java.util.*;

class Node{
	int data;
	Node left;
	Node right;
}


class BT{
	public Node CreateNewNode(int value) {
		Node a = new Node();
		a.data=value;
		a.left=null;
		a.right=null;
		
		return a;
	}
	
	public void inorder(Node node) {
		if(node==null)
			return;
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
		
	}
	
//	public void preorder(Node node) {
//		if(node==null)
//			return;
//		
//		System.out.print(node.data + " ");
//		preorder(node.left);
//		preorder(node.right);
//		
//	}
//	
//	public void postorder(Node node) {
//		if(node==null)
//			return;
//		postorder(node.left);
//		postorder(node.right);
//		System.out.print(node.data + " ");
//		
//	}
//	
//	public int getSumOfNodes(Node node) {
//		if(node==null)
//			return 0;
//		
//		return node.data + getSumOfNodes(node.left) + getSumOfNodes(node.right);
//	}
//	
//	
//	public int getDifferenceEvenOddValues(Node node) {
//		if(node==null)
//			return 0;
//		
//		return node.data - getDifferenceEvenOddValues(node.left) - getDifferenceEvenOddValues(node.right);
//		
//	}
//	
//	
//	public int getNumberOfNode(Node node) {
//		if(node==null)
//			return 0;
//		
//		return 1 + getNumberOfNode(node.left) + getNumberOfNode(node.right);
//		
//	}
//	
//	
//	public int getNumberOfLeafNode(Node node) {
//		if(node==null)
//			return 0;
//		if(node.left == null && node.right ==null) {
//			return 1;
//		}
//		
//		return getNumberOfLeafNode(node.left) + getNumberOfLeafNode(node.right);
//		
//	}
//	
//	
//	public int getHeightOfNode(Node node) {
//		if(node==null)
//			return 1;
//		
//		return max(getHeightOfNode(node.left) , getHeightOfNode(node.right))+1;
//		
//	}
//	
//	private int max(int a,int b) {
//		return a > b ? a : b;
//	}
//	
//	public void printAtGivenLevel(Node node,int level) {
//		if(node==null)
//			return ;
//		if(level==1) {
//			//level == 0 if root node is at level 0
//			System.out.print(node.data + " ");
//		}
//		
//		printAtGivenLevel(node.left,level-1);
//		printAtGivenLevel(node.right,level-1);
//		
//	}
//	
//	public void levelOrderTraversalUsingRecursion(Node node) {
//		if(node==null)
//			return;
//		
//		int h=getHeightOfNode(node);
//		
//		for(int i=0;i<=h;i++) {
//			printAtGivenLevel(node,i+1);
//			System.out.println();
//		}
//	}
//	
//	
//	public void levelOrderTraversalUsingQueue(Node node) {
//		if(node==null)
//			return;
//		Queue<Node> q= new LinkedList<Node>();
//		
//		q.add(node);
//		
//		while(q.size()>0) {
//			Node top=q.remove();
//			System.out.print(top.data + " ");
//			
//			if(top.left!=null)
//				q.add(top.left);
//			
//			if(top.right!=null)
//				q.add(top.right);
//		}
//	}
//	
//	public void reverseLevelOrderTraversalUsingRecursion(Node node) {
//		if(node==null)
//			return;
//		
//		int h=getHeightOfNode(node);
//		
//		for(int i=h;i>=0;i--) {
//			printAtGivenLevel(node,i+1);
//			System.out.println();
//		}
//		
//	}
//	
//	public void reverseLevelOrderTraversalUsingQueue(Node node) {
//		if(node==null)
//			return;
//		Queue<Node> q= new LinkedList<Node>();
//		Stack<Integer> s= new Stack<Integer>();
//		
//		q.add(node);
//		
//		while(q.size()>0) {
//			Node top=q.remove();
//			s.push(top.data);
//			
//			if(top.right!=null)
//				q.add(top.right);
//			
//			if(top.left!=null)
//				q.add(top.left);
//			
//		}
//		
//	   while(s.size()>0) {
//		  System.out.print(s.pop()+" "); 
//		   
//	   }	
//	}
//	
//	
//	public void levelOrderTraversalUsingQueueLineWise(Node node) {
//		if(node==null)
//			return;
//		Queue<Node> q= new LinkedList<Node>();
//		
//		q.add(node);
//		
//		while(true) {
//			int count=q.size();
//			if(count==0)
//				break;
//		
//		while(count>0) {
//			Node top=q.remove();
//			System.out.print(top.data + " ");
//			
//			if(top.left!=null)
//				q.add(top.left);
//			
//			if(top.right!=null)
//				q.add(top.right);
//			
//			count--;
//		}
//		
//		System.out.println("");
//		
//		}
//		
//	
//	}
//	
//	int maxLevel1=0;
//	public void leftViewOfTree(Node node,int level) {
//		if(node==null)
//			return;
//		if(level>=maxLevel1) {
//			System.out.print(node.data + " ");
//			maxLevel1++;
//		}
//		
//		leftViewOfTree(node.left,level+1);
//		leftViewOfTree(node.right,level+1);
//		
//	}
//	
//	
//	int maxLevel2=0;
//	public void rightViewOfTree(Node node,int level) {
//		if(node==null)
//			return;
//		if(level>=maxLevel2) {
//			System.out.print(node.data +" ");
//			maxLevel2++;
//		}
//		
//		rightViewOfTree(node.right,level+1);
//		rightViewOfTree(node.left,level+1);
//		
//	}
	
	
	public void inorderUsingStack(Node node) {
		if(node==null)
			return;
		
		Stack<Node> s = new Stack<Node>();
		
		while(node!=null) {
			s.push(node);
			node = node.left;
		}
		
		while(s.size()>0) {
			Node t = s.pop();
			System.out.print(t.data +" ");
			
			if(t.right!=null) {
				Node tmp = t.right;
				while(tmp!=null) {
					s.push(tmp);
					tmp = tmp.left;
				}
			}
			
		}
		
	}
	
	  public void preorderUsingStack(Node node) {
		    if(node == null) {
		      return;
		    }
		    
		    Stack<Node> s = new Stack<Node>();
		    
		    s.push(node);
		    
		    while(s.size() > 0) {
		      Node t = s.pop();
		      System.out.print(t.data + " ");
		      
		      if(t.right != null) {
		        s.push(t.right);
		      }
		      
		      if(t.left != null) {
		        s.push(t.left);
		      }
		    }
		  }
	  
	  public Node mirrorTree(Node node) {
		  if(node==null)
			  return null;
		  
		  Node t = node.left;
		  node.left = node.right;
		  node.right = t;
		  
		  mirrorTree(node.left);
		  mirrorTree(node.right);
		  
		  return node;
	  }
		
	  
	  public Node deleteNode(Node node) {
		  if(node==null)
			  return null;
		  
		 node.left=deleteNode(node.left);
		 node.right=deleteNode(node.right);
		 
		 System.out.print("Deleting node: "+ node.data);
		 System.out.println();
		 node=null;
		 
		 return node;
		 }
	
}

public class BinaryTree {
	public static void main(String[] args) {
		BT a = new BT();
		Node root = a.CreateNewNode(2);
//		root.left = a.CreateNewNode(7);
//		root.right = a.CreateNewNode(5);
//		root.left.left = a.CreateNewNode(2);
//		root.left.right = a.CreateNewNode(6);
//		root.left.right.left = a.CreateNewNode(5);
//		root.left.right.right = a.CreateNewNode(11);
//		root.right.right = a.CreateNewNode(9);
//		root.right.right.left = a.CreateNewNode(4);
//		
		
//		System.out.print("Inorder: ");
//		a.inorder(root);
//		System.out.println("");
//		
		
//		System.out.print("Preorder: ");
//		a.preorder(root);
//		System.out.println("");		
		
//		System.out.print("Postorder: ");
//		a.postorder(root);
//		System.out.println("");
		
//		System.out.println("Sum Of Nodes: " + a.getSumOfNodes(root));
//		
//		System.out.println("Difference Of Even Odd Values: " + a.getDifferenceEvenOddValues(root));
//		
//		System.out.println("Total number of Node: " + a.getNumberOfNode(root));
//		
//		System.out.println("Total number of Leaf Node: " + a.getNumberOfLeafNode(root));
//		
//		System.out.println("Height Of Tree: " + a.getHeightOfNode(root));
//		
//		System.out.println("Node at level 2 :"); 
//		a.printAtGivenLevel(root,2);
//		System.out.println("");
//		
//		
//		System.out.print("Level Order Traversal Using Recurrsion: ");
//		System.out.println();
//		a.levelOrderTraversalUsingRecursion(root);
//		
//		
//		System.out.print("Level Order Traversal Using Queue: ");
//		System.out.println();
//		a.levelOrderTraversalUsingQueue(root);
//		System.out.println();
//		
//		System.out.print("Reverse Level Order Traversal Using Recurrsion: ");
//		System.out.println();
//		a.reverseLevelOrderTraversalUsingRecursion(root);
//		
//		System.out.print("Reverse Level Order Traversal Using Queue: ");
//		System.out.println();
//		a.reverseLevelOrderTraversalUsingQueue(root);
//		System.out.println();
//		
//		System.out.print("Level Order Traversal Using Queue Line Wise: ");
//		System.out.println();
//		a.levelOrderTraversalUsingQueueLineWise(root);
//		System.out.println();
//		
//		System.out.print("Left View Of Tree: ");
//		System.out.println();
//		a.leftViewOfTree(root,0);
//		System.out.println();
//		
//		System.out.print("Right View Of Tree: ");
//		System.out.println();
//		a.rightViewOfTree(root,0);
//		System.out.println();
		
		System.out.print("Inorder traversal using Stack: ");
		System.out.println();
		a.inorderUsingStack(root);
		System.out.println();
		
		
		System.out.print("Preorder traversal using Stack: ");
		System.out.println();
		a.preorderUsingStack(root);
		System.out.println();
		
		
		Node mirror = a.mirrorTree(root);
		a.inorder(mirror);
		
		
	    root = a.deleteNode(root);
	    a.inorder(root);
		
	}
}
