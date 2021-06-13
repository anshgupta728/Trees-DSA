package BTree;
import BTree.BinaryTree.Node;
public class Diameter {
	
	public static Node root=null;
	
	public static int calcheight(Node root) {
		if(root==null) {
			return 0;
		}
		int l=calcheight(root.left);
		int r=calcheight(root.right);
		return (Math.max(l,r)+1);
	}
	
	public static int diameter(Node root) {
		if(root==null) {
			return 0;
		}
		int len1=calcheight(root.left)+calcheight(root.left)+1;
		int len2=Math.max(diameter(root.left), diameter(root.right));
		return Math.max(len1,len2);
	}
	
	public static void main(String[] args) {
		//		1
		//     /  \
		//    2    3
		//   / \  / \
		//  4  5  6  7
		// /   \
		// 8   9
		//     \
		//     10
		root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.left.left=new Node(8);
		root.left.right=new Node(5);
		root.left.right.right=new Node(9);
		root.left.right.right.right=new Node(10);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		System.out.println(diameter(root));
	}
}
