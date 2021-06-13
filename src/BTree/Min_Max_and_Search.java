package BTree;
import BTree.BinaryTree.Node;
import java.util.Queue;
import java.util.LinkedList;
public class Min_Max_and_Search {
	
	private static Node root=null;
	
	private static int minimum_iter(Node root) {
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		int min=Integer.MAX_VALUE;
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp=q.poll();
			if(temp.data<min)
				min=temp.data;
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);	
		}
		return min;
	}
	
	private static int minimum_recur(Node root) {
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		int min=root.data;
		if(root.left!=null)
			min=Math.min(minimum_recur(root.left),min);
		if(root.right!=null)
			min=Math.min(minimum_recur(root.right),min);
		return min;
	}
	
	private static int maximum_iter(Node root) {
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		int max=Integer.MIN_VALUE;
		while(!q.isEmpty()) {
			Node temp=q.poll();
			if(temp.data>max) {
				max=temp.data;
			}
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
		return max;
	}
	
	private static int maximum_recur(Node root) {
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		int max=root.data;
		if(root.left!=null)
			max=Math.max(max, maximum_recur(root.left));
		if(root.right!=null)
			max=Math.max(max, maximum_recur(root.right));
		return max;
	}
	
	private static boolean find_iter(Node root,int data) {
		if(root==null) {
			return false;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp=q.poll();
			if(temp.data==data)
				return true;
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);	
		}
		return false;
	}
	
	private static boolean find_recur(Node root,int data) {
		if(root==null) {
			return false;
		}
		if(root.data==data) 
			return true;
		return find_recur(root.left,data) || find_recur(root.right,data);
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
		System.out.println("Maximum: "+maximum_recur(root));	
		System.out.println("Minimum: "+minimum_recur(root));
		System.out.println("Maximum: "+maximum_iter(root));	
		System.out.println("Minimum: "+minimum_iter(root));
		System.out.println(find_iter(root,1));
		System.out.println(find_recur(root,3));
		System.out.println(find_recur(root,0));
	}
}
