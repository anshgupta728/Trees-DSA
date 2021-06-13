package BTree;
import java.util.LinkedList;
import java.util.Queue;

//also known as finding depth of tree
import BTree.BinaryTree.Node;
public class Height {
	
	private static Node root=null;
	
	private static int calc_height_recur(Node root) {
		if(root==null) {
			return 0;
		}
		int l=calc_height_recur(root.left);
		int r=calc_height_recur(root.right);
		return (Math.max(l,r)+1);
	}

	private static int calc_height_iter(Node root) {
		if(root==null) {
			return 0;
		}
		Queue<Node> q= new LinkedList<Node>();
		q.offer(root);
		q.offer(null);
		int count=0;
		while(!q.isEmpty()) {
			Node temp=q.poll();
			if(temp!=null) {
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
			else {
				count++;
				if(!q.isEmpty())
					q.offer(null);	
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
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
		System.out.println("Height: "+calc_height_recur(root));
		System.out.println("Height: "+calc_height_iter(root));
	}
}
