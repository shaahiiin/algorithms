// determine if two trees are identical

class Node{
	int data;
	Node left, right;
	Node(int data){
		this.data = data;
		this.left = this.right = null;
	}
}

class BinaryTree{

	Node root;
	BinaryTree(){
		root = null;
	}

	boolean isIdentical(BinaryTree tree){
		return isIdentical(root, tree.root);
	}

	boolean isIdentical(Node node1, Node node2){
		if(node1 == null && node2 == null)
			return true;
		if(node1 != null && node2 != null){
			return node1.data == node2.data
			 	&& isIdentical(node1.left, node2.left) 
			 	&& isIdentical(node1.right, node2.right);
		}
		return false;
	}


}

class Main{
	public static void main(String[] args){
		BinaryTree tree1 = new BinaryTree();
		BinaryTree tree2 = new BinaryTree();

		tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.left.left = new Node(4);
        tree1.root.left.right = new Node(5);

		tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);
        tree2.root.left.left = new Node(4);
        tree2.root.left.right = new Node(5);

        System.out.println(tree1.isIdentical(tree2));

	}
}
