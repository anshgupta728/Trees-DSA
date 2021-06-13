package BTree;
import BTree.BinaryTree.Node;
public class Mirror {

	private static Node root= null;
	
	private static void inorder(Node root) {
		if(root==null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	private static void mirror(Node root) {
		if(root==null) {
			return;
		}
		mirror(root.left);
		mirror(root.right);
		Node temp=root.left;
		root.left=root.right;
		root.right=temp;
		
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
		System.out.println("Inorder Traversal");
		inorder(root);
		System.out.println();
		//		1
		//     /  \
		//    3    2
		//   / \  / \
		//  7  6  5  4
		mirror(root);
		System.out.println("Inorder Traversal");
		inorder(root);

	}

}
