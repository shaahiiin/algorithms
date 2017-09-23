// Sort a linked list of 0s, 1s and 2s


class LinkedList{
	Node head;

	class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			// this.next = null;	// not needed - by default null
		}
	}

	void sortList(){
		Node node = head;
		int[] count = {0, 0, 0};

		while(node != null){
			count[node.data]++;
			node = node.next;
		}

		int i = 0;
		node = head;

		while(node != null){
			if(count[i] == 0)
				i++;
			else{
				node.data = i;
				count[i]--;
				node = node.next;
			}
		}
	}

	void push(int data){
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	void printList(){
		Node temp = head;

		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

class Main{
	public static void main(String[] args){
		LinkedList list = new LinkedList();

		list.push(0);
        list.push(1);
        list.push(0);
        list.push(2);
        list.push(1);
        list.push(1);
        list.push(2);
        list.push(1);
        list.push(2);

        System.out.println("Before sorting:");
        list.printList();

        list.sortList();

        System.out.println("After sorting: ");
        list.printList();
	}
}