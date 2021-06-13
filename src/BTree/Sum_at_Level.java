package BTree;
import java.util.LinkedList;
import java.util.Queue;
import BTree.BinaryTree.Node;
public class Sum_at_Level {
	
	private static Node root=null;
	
	private static void sum_at_k(Node root) {
		if(root==null) {
			return;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		int sum=0;
		int level=0;
		while(!q.isEmpty()) {
			int n=q.size();
			for(int i=0;i<n;i++) {
				Node temp=q.poll();
				sum=sum+temp.data;
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
			System.out.println("Sum at level "+level+" is: "+sum);
			level++;
			sum=0;
		}
	}
	
	public static void max_sum(Node root) {
		if(root==null) {
			return;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		int sum=0,k=0,level=0,maxsum=Integer.MIN_VALUE;
		while(!q.isEmpty()) {
			int n=q.size();
			for(int i=0;i<n;i++) {
				Node temp=q.poll();
				sum=sum+temp.data;
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
			if(sum>maxsum) {
				maxsum=sum;
				level=k;
			}
			k++;
			sum=0;
		}
		System.out.println("Maxsum is "+maxsum+" at level "+level);
	}
	
	public static int sum(Node root) {
		if(root==null) {
			return 0;
		}
		return (root.data)+sum(root.left)+sum(root.right);
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
		root.left.left.left=new Node(8);
		root.left.left.right=new Node(9);
		System.out.println("Sum at all levels:");
		sum_at_k(root);
		System.out.println("*******************************************");
		max_sum(root);
		System.out.println("*******************************************");
		System.out.println("Sum of all nodes: "+sum(root));
	}

}
