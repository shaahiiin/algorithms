// detect loop in Linked list

/*	Algorithms:
1	- use HashSet and store references
2	- add a flag on each node to check if it has been visited
3	- Floyd's Cycle-Finding algorithm
*/

import java.util.HashSet;

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

	// HashSet algorithm
	boolean detectLoop(){
		Node temp = head;
		HashSet<Node> hs = new HashSet<>();

		while(temp != null){
			if(hs.contains(temp)){
				return true;
			}
			hs.add(temp);
			temp = temp.next;
		}
		return false;
	}

	// Floyd's Cycle-Finding algorithm
	boolean detectLoopWithPtr(){
		if(head == null){
			return false;
		}

		Node slowPtr = head, fastPtr = head;

		while(slowPtr != null && fastPtr != null && fastPtr.next != null){
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if(slowPtr == fastPtr){
				return true;
			}
		}

		return false;
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
		list.head.next.next.next.next = list.head.next;

		System.out.println(list.detectLoop());
		System.out.println(list.detectLoopWithPtr());
	}
}