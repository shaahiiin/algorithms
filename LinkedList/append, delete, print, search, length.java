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

	int getLengthIterative(){
		Node temp = head;
		int count = 0;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		return count;
	}
	int getLengthRecursive(Node root){
		if(root == null)
			return 0;
		return 1 + getLengthRecursive(root.next);
	}
	int getLength(){
		return getLengthRecursive(head);
	}

	boolean search(int key){
		Node temp = head;

		while(temp != null){
			if(temp.data == key){
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	boolean searchRec(Node root, int key){
		if(root == null){
			return false;
		}
		if(root.data == key){
			return true;
		}
		return searchRec(root.next, key);
	}
}

class Main{
	public static void main(String[] args){
		List l = new List();
		l.append(1);
		l.append(2);
		l.append(3);
		System.out.println(l.searchRec(l.head, 2));
		System.out.println(l.getLength());
		System.out.println(l.getLengthRecursive(l.head));
		l.deletePos(2);
		l.deletePos(2);
		l.append(4);
		l.print();
		System.out.println(l.searchRec(l.head, 1));
		System.out.println(l.searchRec(l.head, 2));
	}
}