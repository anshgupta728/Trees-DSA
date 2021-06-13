package BTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import BTree.BinaryTree.Node;
public class LevelOrder {
	
	private static Node root=null;
	
	private static void level_order1(Node root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer> >();
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
				ArrayList<Integer> c_curr=new ArrayList<>(curr);
				res.add(c_curr);
				curr.clear();
				if(!q.isEmpty())
					q.offer(null);	
			}
		}
		System.out.print(res);
	}
	
	private static void level_order2(Node root) {
		if(root==null) {
			return;
		}
		Queue<Node> q= new LinkedList<Node>();
		q.offer(root);
		while(!q.isEmpty()) {
			Node temp=q.poll();
				System.out.print(temp.data+" ");
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
	}
	
	public static void main(String[] args)  {
		//		1
		//     /  \
		//    2    3
		//   / \  / \
		//  4  5  6  7
		//  /
		// 8
		root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		root.left.left.left=new Node(8);
		System.out.println("Level Order Traversal");
		level_order1(root);  //using null
		System.out.println();
		System.out.println("Level Order Traversal");
		level_order2(root);  //without null
	}
}                                                                                              