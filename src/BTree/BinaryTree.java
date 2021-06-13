package BTree;
public class BinaryTree {
	
	private static Node root=null;

	public static class Node {
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data=data;
			left=null;
			right=null;
		}
	}
	
	private static void preorder(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	private static void inorder(Node root) {
		if(root==null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	private static void postorder(Node root) {
		if(root==null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
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
		/* Pre-Order states that first go to root then left subtree and then right subtree
		1 2 4 5 3 6 7*/
		preorder(root);
		System.out.println();
		System.out.println("In-Order Traversal");
		/* In-Order states that first go to left subtree then root and then right subtree
		4 2 5 1 6 3 7*/
		inorder(root);
		System.out.println();
		System.out.println("Post-Order Traversal");
		/* Post-Order states that first go to left subtree then right subtree and then root
		4 5 2 6 7 3 1*/
		postorder(root);
		System.out.println();
	}
}
