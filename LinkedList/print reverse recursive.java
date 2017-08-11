// recursive function to print reverse of a linked list

class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

class List{
	Node head;
	List(){
		head = null;
	}

	void append(int key){
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

	// wrapper function to call the recursive function
	void printReverse(){
		printReverse(head);
	}
	
	void printReverse(Node head){
		if(head == null)
			return;
		printReverse(head.next);
		System.out.print(head.data + " ");
		if(head == this.head)
			System.out.println();
	}
}

class Main{
	public static void main(String[] args){
		List list = new List();

		list.append(10);
		list.append(20);
		list.append(30);
		list.append(40);

		list.printReverse(list.head);
	}
}