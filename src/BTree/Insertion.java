package BTree;
import java.util.LinkedList;
import java.util.Queue;
import BTree.BinaryTree.Node;
public class Insertion{
	
	private static Node root=null;
	
	private static void insert(Node root,int data) {
		if(root==null) {
			return;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp=q.poll();
			if(temp.left!=null)
				q.add(temp.left);
			else {
				Node n=new Node(data);
				temp.left=n;
				return;
			}
			if(temp.right!=null)
				q.add(temp.right);
			else {
				Node n=new Node(data);
				temp.right=n;
				return;
			}
		}
		return;
	}
	
	private static void inorder(Node root) {
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
		System.out.println("Inorder Traversal:");
		inorder(root);
		insert(root,9);
		insert(root,10);
		System.out.println();
		
		//		1
		//     /  \
		//    2    3
		//   / \  / \
		//  4  5  6  7
		// / \
		// 9 10
		System.out.println("Inorder Traversal:");
		inorder(root);
	}
}
