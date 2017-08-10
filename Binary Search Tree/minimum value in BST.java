class Node{
	int data;
	Node left, right;
	Node(int data){
		this.data = data;
		left = right = null;
	}
}

class BinarySearchTree{
	Node root;
	
	BinarySearchTree(){
		root = null;
	}
	
	void insert(int key){
		root = insertRec(root, key);
	}
	Node insertRec(Node root, int key){
		if(root == null){
			return new Node(key);
		}
		// search
		if(key < root.data){
			root.left = insertRec(root.left, key);
		} else {
			root.right = insertRec(root.right, key);
		}
		return root;
	}

	// Minimum value of BST
	int minValue(Node root){
		while(root.left != null){
			root = root.left;
		}
		return root.data;
	}

	void inorder(){
		inorderRec(root);
	}
	void inorderRec(Node root){
		if(root == null)
			return;
		inorderRec(root.left);
		System.out.print(root.data + " ");
		inorderRec(root.right);
	}

}

class Main{
	public static void main(String[] args){
		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
 
        System.out.println("Inorder traversal of the given tree");
        bst.inorder();
 
        System.out.println("\nMinimum value of BST");
        System.out.println(bst.minValue(bst.root));
	}
}