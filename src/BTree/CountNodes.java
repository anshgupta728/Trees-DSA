package BTree;
//also known as finding the size of tree
import java.util.LinkedList;
import java.util.Queue;
import BTree.BinaryTree.Node;
public class CountNodes {
	
	private static Node root=null;
	
	private static int count_recur(Node root) {
		if(root==null) {
			return 0;
		}
		int left=count_recur(root.left);
		int right=count_recur(root.right);
		return 1+left+right;
	}
	
	private static int count_iter(Node root) {
		if(root==null) {
			return 0;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		int count=0;
		while(!q.isEmpty()) {
			Node temp=q.poll();
			count++;
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
		return count;
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
		System.out.println("Count: "+count_iter(root));
		System.out.println("Count: "+count_recur(root));
	}
}
