package BTree;
import java.util.*;
import BTree.BinaryTree.Node;
public class ZigZag {

	private static Node root=null;
	
	private static ArrayList<Integer> zigzagOrder(Node root) {
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) {
            return res;
        }
		Queue<Node> q=new LinkedList<Node>();
		ArrayList<Integer> curr=new ArrayList<Integer>();
		boolean LeftToRight=true;
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
				if(LeftToRight) {
					ArrayList<Integer> c_curr=new ArrayList<Integer>(curr);
					res.addAll(c_curr);
				}
				else {
					ArrayList<Integer> c_curr=new ArrayList<Integer>();
					Stack<Integer> s=new Stack<Integer>();
					s.addAll(curr);
					while(!s.isEmpty()) {
						c_curr.add(s.pop());
					}
					res.addAll(c_curr);
				}
                if(!q.isEmpty()){
				q.offer(null);
				curr.clear();
				LeftToRight=!LeftToRight;
                }
			}
		}
		return res;
    }
	
	private static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null) {
            return res;
        }
		Queue<Node> q=new LinkedList<Node>();
		ArrayList<Integer> curr=new ArrayList<Integer>();
		boolean LeftToRight=true;
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
				if(LeftToRight) {
					ArrayList<Integer> c_curr=new ArrayList<Integer>(curr);
					res.add(c_curr);
				}
				else {
					ArrayList<Integer> c_curr=new ArrayList<Integer>();
					Stack<Integer> s=new Stack<Integer>();
					s.addAll(curr);
					while(!s.isEmpty()) {
						c_curr.add(s.pop());
					}
					res.add(c_curr);
				}
                if(!q.isEmpty()){
				q.offer(null);
				curr.clear();
				LeftToRight=!LeftToRight;
                }
			}
		}
		return res;
    }
	
	
	private static void zigzag(Node root) {
		if(root==null) {
			return;
		}
		Queue<Node> q=new LinkedList<Node>();
		ArrayList<Integer> curr=new ArrayList<Integer>();
		boolean LeftToRight=true;
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
				if(LeftToRight) {
					ArrayList<Integer> c_curr=new ArrayList<Integer>(curr);
					for(int i:c_curr)
						System.out.print(i+" ");
				}
				else {
					Stack<Integer> s=new Stack<Integer>();
					s.addAll(curr);
					while(!s.isEmpty()) {
						System.out.print(s.pop()+" ");
					}
				}
				if(!q.isEmpty()) {
					q.offer(null);
					curr.clear();
					LeftToRight=!LeftToRight;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		  //     1
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
		System.out.println("Zig-Zag Traversal: ");
		zigzag(root);
		System.out.println();
		System.out.println(zigzagLevelOrder(root));
		System.out.println(zigzagOrder(root));
	}
}
