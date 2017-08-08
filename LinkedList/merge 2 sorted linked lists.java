// Merge 2 sorted Linked Lists

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

	// This util function just performs merge sort on 2 linked lists
	public static List merge(List ls1, List ls2){
		Node temp1 = ls1.head;
		Node temp2 = ls2.head;
		List sortedList = new List();

		while(temp1 != null && temp2 != null){
			if(temp1.data < temp2.data){
				sortedList.append(temp1.data);
				temp1 = temp1.next;
			} else {
				sortedList.append(temp2.data);
				temp2 = temp2.next;
			}
		}
		if(temp1 == null){
			while(temp2 != null){
				sortedList.append(temp2.data);
				temp2 = temp2.next;
			}
		}
		else if(temp2 == null){
			while(temp1 != null){
				sortedList.append(temp1.data);
				temp1 = temp1.next;
			}
		}

		return sortedList;
	}
}

class Main{
	public static void main(String[] args){
		List list1 = new List();
		List list2 = new List();

		list1.append(10);
		list1.append(20);
		list1.append(30);
		list1.append(40);
		list1.print();

		list2.append(15);
		list2.append(25);
		list2.append(35);
		list2.append(45);
		list2.print();

		List sorted = List.merge(list1, list2);
		sorted.print();
	}
}