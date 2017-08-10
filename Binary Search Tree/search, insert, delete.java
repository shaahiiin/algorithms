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

	void deleteKey(int key){
		root = deleteRec(root, key);
	}
	Node deleteRec(Node root, int key){
		if(root == null){
			System.out.println("Key not present");
			return root;
		}
		if(key < root.data){
			root.left = deleteRec(root.left, key);
		} else if(key > root.data){
			root.right = deleteRec(root.right, key);
		} else {
			// if one child or no child
			if(root.left == null){
				return root.right;
			} else if (root.right == null){
				return root.left;
			}

			root.data = minValue(root.right);

			root.right = deleteRec(root.right, root.data);
		}

		return root;
	}

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
 
        System.out.println("\nDelete 20");
        bst.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        bst.inorder();
 
        System.out.println("\nDelete 30");
        bst.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        bst.inorder();
 
        System.out.println("\nDelete 50");
        bst.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        bst.inorder();
	}
}