// Find the middle of a given linked list

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

	int middle(){
		Node temp = head;
		
		int count = 0;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		
		int i = 0;
		temp = head;

		// add -1 to get n/2'th element
		while(i < ((count+1)/2)){
			temp = temp.next;
			i++;
		}
		return temp.data;
	}

	int midSlowPtr(){
		Node fastPtr = head, slowPtr = head;
		int prev = -1;
		if(head != null){
			while(fastPtr!= null && fastPtr.next != null){
				fastPtr = fastPtr.next.next;
				prev = slowPtr.data;
				slowPtr = slowPtr.next;
			}
		}

		// remove this if for getting n/2+1th element
		if(fastPtr == null)
			return prev;

        return slowPtr.data;
	}

	int midSlowCount(){
		if(head == null) return -1;

		Node temp = head;
		Node mid = head;
		int count = 0;
		// Add this statement to get n/2th element
        // temp = temp.next;
		while(temp != null){
			temp = temp.next;
			if(count % 2 != 0){
				mid = mid.next;
			}
			count++;
		}
		return mid.data;
	}
}

class Main{
	public static void main(String[] args){
		List list = new List();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		list.append(6);

		System.out.println(list.middle());
		System.out.println(list.midSlowPtr());
		System.out.println(list.midSlowCount());
	}
}