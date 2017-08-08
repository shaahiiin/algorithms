// Program for nth node from the end of a Linked List

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

	void deletePos(int pos){
		if(pos == 1){
			head = head.next;
			return;
		}
		pos -= 2;
		Node temp = head;
		while(pos > 0){
			temp = temp.next;
			pos--;
		}
		temp.next = temp.next.next;
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
	int getLength(){
		Node temp = head;
		int count = 0;
		while(temp != null){
			temp = temp.next;
			count++;
		}
		return count;
	}
	void printNthFromEndLength(int n){
		int len = getLength();
		int i = 0;
		Node temp = head;
		while(temp != null && i < len-n){
			temp = temp.next;
			i++;
		}
		if(temp == null)
			return;
		System.out.println(temp.data);
	}
	void printNthFromEnd(int n){
		Node fastPtr = head, slowPtr = head;
		while(n-- > 0){
			if(fastPtr == null){
				System.out.println("n is greater than length");
				return;
			}
			fastPtr = fastPtr.next;
		}

		while(fastPtr != null){
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}
		System.out.println(slowPtr.data);
	}
}

class Main{
	public static void main(String[] args){
		List list = new List();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);

		list.printNthFromEndLength(2);
		list.printNthFromEnd(4);
	}
}