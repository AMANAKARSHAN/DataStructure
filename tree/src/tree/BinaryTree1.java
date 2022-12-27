package tree;

class BT1 extends BT{
	
	public boolean checkIfIdentical(Node t1 , Node t2) {
		if(t1==null && t2==null)
			return true;
		
		if(t1==null || t2==null)
			return true;
		
		return t1.data == t2.data && checkIfIdentical(t1.left,t2.left) 
				&& checkIfIdentical(t1.right,t2.right);
		
	}
	
	
	public int getLevelOfNode(Node node , int val , int level) {
		if(node==null)
			return 0;
		int l;
		
		if(node.data==val)
			return level;
		
		l=getLevelOfNode(node.left,val,level+1);
		
		if(l!=0)
			return l;
		
		l=getLevelOfNode(node.right,val,level+1);
		
		return l;
	}
	
	
}


public class BinaryTree1 {

	public static void main(String[] args) {
		BT1 a = new BT1();
		Node root = a.CreateNewNode(2);
		root.left = a.CreateNewNode(7);
		root.right = a.CreateNewNode(5);
		root.left.left = a.CreateNewNode(2);
		root.left.right = a.CreateNewNode(6);
		root.left.right.left = a.CreateNewNode(5);
		root.left.right.right = a.CreateNewNode(11);
		root.right.right = a.CreateNewNode(9);
		root.right.right.left = a.CreateNewNode(4);
		
		
		Node root_temp = a.CreateNewNode(2);
		root_temp.left = a.CreateNewNode(7);
		root_temp.right = a.CreateNewNode(5);
		root_temp.left.left = a.CreateNewNode(2);
		root_temp.left.right = a.CreateNewNode(6);
		root_temp.left.right.left = a.CreateNewNode(5);
		root_temp.left.right.right = a.CreateNewNode(11);
		root_temp.right.right = a.CreateNewNode(9);
		root_temp.right.right.left = a.CreateNewNode(4);
		
		
		System.out.println("Inorder Traversal: ");
		a.inorder(root);
		System.out.println();
		
		System.out.println(a.checkIfIdentical(root,root_temp));
		
		System.out.println(a.getLevelOfNode(root,9,1));
		
		
		
		
	}

}
