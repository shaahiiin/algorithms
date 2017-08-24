// left view of a tree

// two algos - level order traversal algo, and recursive algo

import java.util.Queue;
import java.util.LinkedList;

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
	static int maxLevel;
	
	BinaryTree(){
		root = null;
	}

	// Recursive algorithm
	void leftViewUtil(Node node, int level){
		if(node == null)
			return;
		if(level > maxLevel){
			System.out.print(node.data + " ");
			maxLevel = level;
		}

		leftViewUtil(node.left, level+1);
		leftViewUtil(node.right, level+1);
	}

	void leftView(){
		maxLevel = 0;
		leftViewUtil(root, 1);
		System.out.println();

		// this function call is for the level order algo
        // leftViewLevel();
	}
	
	// level order algo
	// we will print root node first, and then print every node after a null (except last null)
	// Queue will be like [12, null, 10, 30, null, 25, 40, null] - order of insertions - not actual queue repr
	void leftViewLevel(){
	    Queue<Node> queue = new LinkedList<>();
	    queue.add(root);
	    queue.add(null);
	    if(root != null)
	        System.out.print(root.data + " ");
        
	    while(!queue.isEmpty()){
	        Node temp = queue.poll();
	        if(temp != null){
	            if(temp.left != null)
    	            queue.offer(temp.left);
                if(temp.right != null)
                    queue.offer(temp.right);
	        }
	        else {
	            if(!queue.isEmpty()){
	                System.out.print(queue.peek().data +" ");
	                queue.offer(null);
	            }
	        }
	    }
	    System.out.println();
	}

}

class Main{
	public static void main(String[] args){
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);
        // tree.root.left.left = new Node(100);
        
        tree.leftView();
        tree.leftView();
	}
}