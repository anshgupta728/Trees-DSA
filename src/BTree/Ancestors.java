package BTree;
import BTree.BinaryTree.Node;;
public class Ancestors {

	private static Node root=null;
	
	private static boolean print_ancestors(Node root,Node node) {
		if(root==null || node==null) {
			return false;
		}
		if(root.left==node || root.right==node || print_ancestors(root.left,node) || print_ancestors(root.right,node)) {
			System.out.print(root.data+" ");
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
			//       1
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
			Node node=root.left.left.left;
			System.out.println("Ancestors:");
		    print_ancestors(root,node);
	}

}
