package BTree;
import BTree.BinaryTree.Node;
public class LeastCommonAncestor {

	private static Node root=null;
	
	private static Node LCA(Node root,Node n1,Node n2) {
		if(root==null)
			return root;
		if(root==n1 || root==n2)
			return root;
		Node left=LCA(root.left,n1,n2);
		Node right=LCA(root.right,n1,n2);
		if(left!=null && right!=null) {
			return root;
		}
		else
			return (left!=null)?left:right;
	}
	
	public static void main(String[] args) {
		 //      1
		//     /   \
	   //     2     3
		//   /  \  / \
		//  4   5  6  7
		// / \ / \
		// 8 9 10 11
		root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		root.left.left.left=new Node(8);
		root.left.left.right=new Node(9);
		root.left.right.left=new Node(10);
		root.left.right.right=new Node(11);
		Node temp1=root.left.left.left;
		Node temp2=root.left.right;
		System.out.println(LCA(root,temp1,temp2).data);
	}

}
