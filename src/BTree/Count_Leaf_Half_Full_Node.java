package BTree;
import java.util.LinkedList;
import java.util.Queue;
import BTree.BinaryTree.Node;
public class Count_Leaf_Half_Full_Node {

	public static Node root=null;
	
	public static int[] count(Node root) {
		if(root==null) {
			return null;
		}
		Node temp=null;
		Queue<Node> q= new LinkedList<Node>();
		q.offer(root);
		int count_leaf=0,count_half=0,count_full=0;
		while(!q.isEmpty()) {
			temp=q.poll();
				if(temp.left==null && temp.right==null)
					count_leaf++;
				if(temp.left==null && temp.right!=null || temp.left!=null && temp.right==null)
					count_half++;
				if(temp.left!=null && temp.right!=null)
					count_full++;
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);	
		}
		int arr[]=new int[3];
		arr[0]=count_leaf;
		arr[1]=count_half;
		arr[2]=count_full;
		return arr;
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
		int arr[]=count(root);
		System.out.println("Leaf nodes: "+arr[0]);
		System.out.println("Half nodes: "+arr[1]);
		System.out.println("Full nodes: "+arr[2]);
	}

}
