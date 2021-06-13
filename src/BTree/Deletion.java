package BTree;
import java.util.LinkedList;
import java.util.Queue;
import BTree.BinaryTree.Node;
public class Deletion {
	
	static Node root=null;
	
	public static Node deepestnode(Node root) {
		if(root==null) {
			return null;
		}
		Node temp=null;
		Queue<Node> q= new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			temp=q.poll();
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);	
		}
		return temp;
	}
	
	public static void delete(Node root,int ele) {
		if(root==null) {
			return;
		}
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
		//  /  /  /
		//  8  9 10
		root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		root.left.left.left=new Node(8);
		root.left.right.left=new Node(9);
		root.right.left.left=new Node(10);
		System.out.println("Inorder Traversal:");
		inorder(root);
		delete(root,10);
		System.out.println();
		//System.out.println("Inorder Traversal:");
		inorder(root);
	}
}
