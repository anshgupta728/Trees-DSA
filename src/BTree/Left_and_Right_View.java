package BTree;
import java.util.*;
import BTree.BinaryTree.Node;
public class Left_and_Right_View {

	private static Node root=null;
	
	private static void right_view2(Node root) {
		if(root==null) {
			return;
		}
		ArrayList<Integer> curr=new ArrayList<>();
		Queue<Node> q= new LinkedList<Node>();
		q.offer(root);
		q.offer(null);
		while(!q.isEmpty()) {
			Node temp=q.poll();
			if(temp!=null) {
				curr.add(temp.data);
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
			else {
				System.out.print(curr.get(curr.size()-1)+" ");
				if(!q.isEmpty()) {
				curr.clear();
				q.offer(null);	
				}
			}
		}
	}
	
	private static void left_view2(Node root) {
		if(root==null) {
			return;
		}
		ArrayList<Integer> curr=new ArrayList<>();
		Queue<Node> q= new LinkedList<Node>();
		q.offer(root);
		q.offer(null);
		while(!q.isEmpty()) {
			Node temp=q.poll();
			if(temp!=null) {
				curr.add(temp.data);
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
			else {
				System.out.print(curr.get(0)+" ");
				if(!q.isEmpty()) {
				curr.clear();
				q.offer(null);	
				}
			}
		}
	}
	
	private static void left_view1(Node root) {
		if(root==null) {
			return;
		}
		Queue<Node> q= new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			int n=q.size();
			for(int i=0;i<n;i++) {
				Node temp=q.poll();
				//printing first element of a particular level
				if(i==0)
					System.out.print(temp.data+" ");
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
	}
	
	private static void right_view1(Node root) {
		if(root==null) {
			return;
		}
		Queue<Node> q= new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			int n=q.size();
			for(int i=0;i<n;i++) {
				Node temp=q.poll();
				//printing last element of a particular level
				if(i==n-1)
					System.out.print(temp.data+" ");
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
	}
	
	public static void main(String[] args) {
		 //      1
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
		System.out.println("Left View:");
		left_view1(root);
		System.out.println();
		System.out.println("Left View:");
		left_view2(root);
		System.out.println();
		System.out.println("Right View:");
		right_view1(root);
		System.out.println();
		System.out.println("Right View:");
		right_view2(root);
	}
}
