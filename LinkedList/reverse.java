// reverse a linked list

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

	void reverse(){
		Node prev = null, curr = head, next;

		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
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

		list.reverse();
		list.print();
	}
}