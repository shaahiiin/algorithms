// level order traversal

import java.util.Queue;
import java.util.LinkedList;

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

	void levelOrderTraversal(){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			Node temp = queue.poll();
			System.out.print(temp.data + " ");
			if(temp.left != null)
				queue.offer(temp.left);
			if(temp.right != null)
				queue.offer(temp.right);
		}
	}

}

class Main{
	public static void main(String[] args){
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Level order traversal of binary tree is ");
        tree.levelOrderTraversal();
        
	}
}