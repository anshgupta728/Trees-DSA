package BTree;
import java.util.LinkedList;
import java.util.Queue;
import BTree.BinaryTree.Node;
public class MinimumDepth {

	private static Node root=null;
	
	private static int minimum_height(Node root) {
		if(root==null)
			return -1;
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		q.add(null);
		int count=1;
		while(!q.isEmpty()) {
			Node temp=q.poll();
			if(temp!=null) {
				if(temp.left==null && temp.right==null)
					return count;
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
			else {
				count++;
				if(!q.isEmpty()) {
					q.add(null);
				}	
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		//		1
		//     /  \
		//    2    3
		//   / \ 
		//  4  5  
		// /
		// 6
		root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.left.left.left=new Node(6);
		System.out.println("Minimum Depth:"+minimum_height(root));
	}

}
