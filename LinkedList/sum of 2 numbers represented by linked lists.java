// find sum of 2 numbers represented by linked lists - no extra space used or modifying the linked lists
// least significant digit at end of linked list

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

    // pushes to front of linkedlist - we need this for building the result linkedlist
	void push(int data){
		if(head == null){
			head = new Node(data);
			return;
		}
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
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
		int diff = 0;

		Node temp1, temp2;
        
        // temp1 should point to the longer linkedlist
		if(l2 > l1){
			temp1 = num2.head;
			temp2 = this.head;
			diff = l2-l1;
		}
		else {
			temp1 = this.head;
			temp2 = num2.head;
			diff = l1-l2;
		}

		Node head = temp1;

        // increment temp1 till temp1 and temp2 have same lengths to end of list
		while(diff > 0){
			temp1 = temp1.next;
			diff--;
		}

		LinkedList ans = new LinkedList();

		int carry = addRec(temp1, temp2, ans);
        
        // if any carry add that to the remaining linkedlist of temp1
        if(carry != 0){
            int c = addCarry(head, temp1, ans);
            if(c == 1)	// extra carry after final addition - push that as well
            	ans.push(1);
        }
        
		return ans;
	}
	
	// add carry of addRec to remaining linkedlist
	int addCarry(Node head, Node temp, LinkedList ans){
	    if(head == temp)
	    	return 1;	// carry from addRec added

	    int sum = head.data + addCarry(head.next, temp, ans);
	    ans.push(sum % 10);

	    return sum/10;
	}
    
    // add equal lengths of both linked lists recursively - returns carry
	int addRec(Node temp1, Node temp2, LinkedList ans){
		if(temp1 == null && temp2 == null)
			return 0;
		int sum = temp1.data + temp2.data + addRec(temp1.next, temp2.next, ans);
		
		ans.push(sum%10); // push ones digit alone
		return sum/10; // return carry
	}

	void printList(){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
}

class Main{
	public static void main(String[] args){
		LinkedList num1 = new LinkedList();
		LinkedList num2 = new LinkedList();

        // 999
		num1.push(9);
		num1.push(9);
		num1.push(9);

        // 18
		num2.push(8);
		num2.push(1);

		LinkedList ans = num1.add(num2);
		
		num1.printList();
		System.out.println("+");
		num2.printList();
		
        System.out.println("=");
		ans.printList();
	}

}