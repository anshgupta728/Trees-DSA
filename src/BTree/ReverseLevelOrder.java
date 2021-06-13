package BTree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import BTree.BinaryTree.Node;
public class ReverseLevelOrder {
	
	private static Node root=null;
	
	private static void revlevelorder(Node root) {
		if(root==null) {
			return;
		}
		Queue<Node> q= new LinkedList<Node>();
		Stack<Node> s=new Stack<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp=q.poll();
			s.push(temp);
			if(temp.right!=null)
				q.add(temp.right);
			if(temp.left!=null)
				q.add(temp.left);
		}
		while(!s.isEmpty())
			System.out.print(s.pop().data+" ");
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
		System.out.println("Reverse Level Order Traversal");
		revlevelorder(root);
	}
}       