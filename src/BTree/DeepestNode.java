package BTree;
import java.util.LinkedList;
import java.util.Queue;
import BTree.BinaryTree.Node;
public class DeepestNode {
	
	private static Node root=null;
	
	private static Node deepestnode(Node root) {
		Node temp=null;
		if(root==null) {
			return temp;
		}
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
		System.out.println("Deepest Node: "+(deepestnode(root).data));
	}

}
