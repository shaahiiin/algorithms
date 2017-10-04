// level order traversal

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Node{
	int data;
	ArrayList<Node> children = new ArrayList<>();

	Node(int data){
		this.data = data;
	}
}

class Tree{
	Node root;
	Tree(){
		root = null;
	}

	void levelOrderTraversal(){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while(!queue.isEmpty()){
			Node temp = queue.poll();
			System.out.print(temp.data + " ");
		    System.out.println("Children of " + temp.data + " are :");
			for(int i = 0; i < temp.children.size(); i++){
			    System.out.println(temp.children.get(i).data);
                queue.offer(temp.children.get(i));
			}
		}
	}

}

class Main{
	public static void main(String[] args){
		Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.children.add(new Node(2));
        tree.root.children.add(new Node(3));
        tree.root.children.add(new Node(4));

        tree.root.children.get(0).children.add(new Node(5));
        tree.root.children.get(1).children.add(new Node(6));
        tree.root.children.get(1).children.add(new Node(7));

        System.out.println("Level order traversal of binary tree is ");
        tree.levelOrderTraversal();

	}
}
