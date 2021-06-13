package BTree;
import BTree.BinaryTree.Node;
public class SumReplace {
	
	private static Node root=null;
	
	private static void sumreplace(Node root) {
		if(root==null) {
			return;
		}
		sumreplace(root.left);
		sumreplace(root.right);
		if(root.left!=null)
			root.data+=root.left.data;
		if(root.right!=null)
			root.data+=root.right.data;
	}
	
	public static void inorder(Node root) {
		if(root==null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
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
		sumreplace(root);
		System.out.println("Inorder after sum replacement:");
		inorder(root);

	}

}
