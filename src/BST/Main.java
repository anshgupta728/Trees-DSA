package BST;

public class Main {

	public static void main(String[] args) {
		
		//		18
		//     /  \
		//    17  25
		//   /    / \
		//  10   19 46
		//        \  \
		//        20  48
		BinarySearchTree obj=new BinarySearchTree();
		obj.insert(18);
		obj.insert(25);
		obj.insert(17);
		obj.insert(10);
		obj.insert(19);
		obj.insert(20);
		obj.insert(46);
		obj.insert(48);
		//In order: 10 17 18 19 20 25 46 48
		obj.inorder();
		//Post order: 10 17 20 19 48 46 25 18
		obj.postorder();
		//Pre order: 18 17 10 25 19 20 46 48
		obj.preorder();
		obj.delete(25);
		//10 17 18 19 20 46 48
		obj.inorder();
		obj.min();
		obj.max();
	}

}
