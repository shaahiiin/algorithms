//Swap nodes in a linked list without swapping data
/*
Cases to handle:
1) x and y may or may not be adjacent.
2) Either x or y may be a head node.
3) Either x or y may be last node.
4) x and/or y may not be present in linked list.
*/

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

	void swap(int x, int y){
		if(x == y)
			return;

		if(head == null){
			System.out.println("Empty List. Cannot swap.");
			return;
		}

		Node nodeX = head, prevX = null;
		while(nodeX != null && nodeX.data != x){
			prevX = nodeX;
			nodeX = nodeX.next;
		}
		if(nodeX == null){
			System.out.println("Couldn't find first key");
			return;
		}

		Node nodeY = head, prevY = null;
		while(nodeY != null && nodeY.data != y){
			prevY = nodeY;
			nodeY = nodeY.next;
		}
		if(nodeY == null){
			System.out.println("Couldn't find second key");
			return;
		}

		// check if head and handle prev nodes
		if(prevX != null){
			prevX.next = nodeY;
		} else {
			head = nodeY;
		}

		if(prevY != null){
			prevY.next = nodeX;
		} else {
			head = nodeX;
		}

		// swap the next nodes
		Node temp = nodeX.next;
		nodeX.next = nodeY.next;
		nodeY.next = temp;
	}
}

class Main{
	public static void main(String[] args){
		List list = new List();
		list.append(10);
		list.append(20);
		list.append(30);
		list.append(40);
		list.append(50);
		list.append(60);
		list.print();

		list.swap(20, 30);
		list.print();
	}
}