// add two numbers represented by linked lists
// least significant digit at start of list

class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

class LinkedList{
	Node head = null;

    // we can use this to build the answer - but it will take O(n^2) for adding n nodes to the result LL
	void append(int data){
		if(head == null){
			head = new Node(data);
			return;
		}
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = new Node(data);
	}

	int getLength(){
		if(head == null)
			return 0;
		Node temp = head;
		int length = 0;
		while(temp != null){
			length++;
			temp = temp.next;
		}
		return length;
	}

	LinkedList add(LinkedList num2){
		int l1 = this.getLength();
		int l2 = num2.getLength();
		Node temp1, temp2;
		int diff;

		// temp1 should point to the longer linkedlist
		if(l2 > l1){
			temp1 = num2.head;
			temp2 = this.head;
			diff = l2 - l1;
		} else {
			temp1 = this.head;
			temp2 = num2.head;
			diff = l1 - l2;
		}

		while(diff-- > 0){
			temp1 = temp1.next;
		}

		Node head = temp1, ansPtr = null;
		int carry = 0;
		LinkedList ans = new LinkedList();

		while(temp1 != null || temp2 != null){
			int a = temp1 != null ? temp1.data : 0;
			int b = temp2 != null ? temp2.data : 0;
			int sum = a + b + carry;

			// append 
			if(ans.head == null){
				ans.head = new Node(sum % 10);
				ansPtr = ans.head;
			} else {
				ansPtr.next = new Node(sum % 10);
				ansPtr = ansPtr.next;
			}

			carry = sum/10;

			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		if(carry != 0)
			ansPtr.next = new Node(1);

		return ans;
	}


	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Node temp = head;
		while(temp != null){
			sb.append(temp.data);
			temp = temp.next;
		}
		return sb.toString();
	}
}

class Main{
	public static void main(String[] args){
		LinkedList num1 = new LinkedList();
		LinkedList num2 = new LinkedList();
        
        num1.append(5);
        num1.append(6);
        num1.append(3);
        
        num2.append(8);
        num2.append(4);
        num2.append(2);
        
		LinkedList ans = num1.add(num2);
		System.out.println(num1 + " + " + num2 + " = "  + ans);
	}
}
