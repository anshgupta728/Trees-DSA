package BTree;

import BTree.BinaryTree.Node;

public class Pre_Post_In {
	
	static Node root=null;
	
	public static void preorder_recur(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		preorder_recur(root.left);
		preorder_recur(root.right);
	}
	
	public static void inorder_recur(Node root) {
		if(root==null) {
			return;
		}
		inorder_recur(root.left);
		System.out.print(root.data+" ");
		inorder_recur(root.right);
	}
	
	public static void postorder_recur(Node root) {
		if(root==null) {
			return;
		}
		postorder_recur(root.left);
		postorder_recur(root.right);
		System.out.print(root.data+" ");
	}
	
	public static void main(String[] args) {
		//		1
		//     /  \
		//    2    3
		//   / \  / \
		//  4  5  6  7
		root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		System.out.println("Pre-Order Traversal");
		preorder_recur(root);
		System.out.println();
		System.out.println("In-Order Traversal");
		inorder_recur(root);
		System.out.println();
		System.out.println("Post-Order Traversal");
		postorder_recur(root);
		System.out.println();
	}
}
