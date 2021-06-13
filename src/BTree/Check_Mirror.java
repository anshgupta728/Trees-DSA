package BTree;
import BTree.BinaryTree.Node;
public class Check_Mirror {
	
	private static Node root1=null;
	private static Node root2=null;
	
	private static boolean checkmirror(Node root1,Node root2) {
		if(root1==null && root2==null)
			return true;
		if(root1!=null && root2!=null && root1.data==root2.data) {
			return checkmirror(root1.right,root2.left) && checkmirror(root1.left,root2.right);
		}
		return false;
	}
	
	public static void main(String[] args) {
		//		1
		//     /  \
		//    2    3
		//   / \  / \
		//  4  5  6  7
		root1=new Node(1);
		root1.left=new Node(2);
		root1.right=new Node(3);
		root1.left.left=new Node(4);
		root1.left.right=new Node(5);
		root1.right.left=new Node(6);
		root1.right.right=new Node(7);
		//		1
		//     /  \
		//    3    2
		//   / \  / \
		//  7  6  5  4
		root2=new Node(1);
		root2.left=new Node(3);
		root2.right=new Node(2);
		root2.left.left=new Node(7);
		root2.left.right=new Node(6);
		root2.right.left=new Node(5);
		root2.right.right=new Node(4);
		System.out.println(checkmirror(root1,root2));
	}

}
