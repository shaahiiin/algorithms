// Insert in sorted linked list

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

	// iterate till data of next node > key, and insert
	void insertSorted(int key){
		// empty list
		if(head == null){
			head = new Node(key);
			return;
		}

		// 1st node insert
		if(head.data > key){
			Node temp = new Node(key);
			temp.next = head;
			head = temp;
			return;
		}

		// normal insert
		Node temp = head;

		while(temp.next != null && temp.next.data < key){
			temp = temp.next;
		}
		//last elem insert
		if(temp.next == null){
			temp.next = new Node(key);
			return;
		}
		
		Node n = new Node(key);
		n.next = temp.next;
		temp.next = n;
		
	}
}

class Main{
	public static void main(String[] args){
		List list = new List();

		list.append(10);
		list.append(20);
		list.append(30);
		list.append(40);
		list.print();

		list.insertSorted(25);
		list.print();
	}
}