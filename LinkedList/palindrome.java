// check if the char linked list is palindrome

import java.util.Stack;

class Node{
	char data;
	Node next;
	Node(char data){
		this.data = data;
		this.next = null;
	}
}

class List{
	Node head;
	List(){
		head = null;
	}

	void append(char key){
		if(head == null){
			head = new Node(key);
			return;
		}
		Node temp = head;

		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = new Node(key);
	}

	void print(){
		if(head == null){
			System.out.println("Empty List");
			return;
		}
		System.out.println("List :");
		Node temp = head;

		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	boolean isPalindrome(){
		Node temp = head;
		Stack<Node> stack = new Stack<>();
		while(temp != null){
			stack.push(temp);
			temp = temp.next;
		}

		temp = head;
		while(temp != null){
			Node t = stack.pop();
			if(t.data != temp.data){
				return false;
			}
			temp = temp.next;
		}
		return true;

	}

}

class Main{
	public static void main(String[] args){
		List list = new List();

		list.append('R');
		list.append('A');
		list.append('D');
		list.append('A');
		list.append('R');
		list.print();

		System.out.println(list.isPalindrome());
	}
}