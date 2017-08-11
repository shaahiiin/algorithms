// tree traversals - inorder , preorder , postorder

class Node{
	int data;
	Node left, right;

	Node(int data){
		this.data = data;
		left = right = null;
	}
}

class BinaryTree{
	Node root;

	BinaryTree(){
		root = null;
	}

	void inorder(Node root){
		if(root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	void preorder(Node root){
		if(root == null)
			return;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	void postorder(Node root){
		if(root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}
	
    void postorder()  {     postorder(root);  }
    void inorder()    {     inorder(root);   }
    void preorder()   {     preorder(root);  }
}

class Main{
	public static void main(String[] args){
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.preorder();
 
        System.out.println("\nInorder traversal of binary tree is ");
        tree.inorder();
 
        System.out.println("\nPostorder traversal of binary tree is ");
        tree.postorder();
	}
}