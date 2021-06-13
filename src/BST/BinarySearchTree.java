package BST;
public class BinarySearchTree {

	public Node root;  
	public BinarySearchTree() {
		root=null;
	}
	
	//Node of Binary Search Tree
	public static class Node{  
        int data;  
        Node left;  
        Node right;  
        public Node(int data){    
            this.data = data;  
            left = null;  
            right = null;  
        }  
	}
	
	//Pre-Order states that first go to root then left subtree and then right subtree
	void preorder() {
		System.out.println("Pre-Order Traversal");
		preorderRec(root);
		System.out.println();
	}
	public void preorderRec(Node root) {
		if(root==null) {
			return;
		}
			System.out.print(root.data+" ");
			preorderRec(root.left);
			preorderRec(root.right);
	}
	
	//In-Order states that first go to left subtree then root and then right subtree
	void inorder() {
		System.out.println("In-Order Traversal");
		inorderRec(root);
		System.out.println();
	}
	public static void inorderRec(Node root) {
		if(root==null) {
			return;
		}
			inorderRec(root.left);
			System.out.print(root.data+" ");
			inorderRec(root.right);
	}
	
	//Post-Order states that first go to left subtree then right subtree and then root
	void postorder() {
		System.out.println("Post-Order Traversal");
		postorderRec(root);
		System.out.println();
	}
	public void postorderRec(Node root) {
		if(root==null) {
			return;
		}
		postorderRec(root.left);
		postorderRec(root.right);
		System.out.print(root.data+" ");
	}
	
    //Insertion in a Binary Search Tree
	void insert(int data){
         root = insertRec(root, data);
    }
    public Node insertRec(Node root, int data){
        if (root == null){
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
 
        return root;
    }
    
    //Deletion in a Binary Search Tree
    void delete(int data){
        root = deleteRec(root, data);
    }
    public Node deleteRec(Node root,int data) {
    	if(root==null) {
    		return root;
    	}
    	if(data<root.data)
    		root.left = deleteRec(root.left, data);
        else if (data>root.data)
            root.right = deleteRec(root.right, data);
        else {
        	//If a node has one or no children
        	if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
        	//If a nose has 2 children
        	root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
    	return root;	
    }
    
    //Finding minimum value in BST
    public void min() {
    	System.out.println("Minimum value:"+minValue(root));
    }
    public int minValue(Node root) {
        int minv = root.data;
        while (root.left != null){
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
    
   //Finding maximum value in BST
    public void max() {
    	System.out.println("Maximum value:"+maxValue(root));
    }
    public int maxValue(Node root){
    	 int maxv = root.data;
         while (root.right != null){
             maxv = root.right.data;
             root = root.right;
         }
         return maxv;
    }
}
