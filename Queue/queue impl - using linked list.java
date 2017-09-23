// Queue implementation using Linked List

class Queue{
	Node front, rear;
	class Node{
		int key;
		Node next;
		Node(int key){
			this.key = key;
			this.next = null; // by default this is null anyway
		}
	}

	Queue(){
		front = null; // by default initialised as null
		rear = null;
	}

	void enqueue(int key){
		if(isEmpty()){
			front = rear = new Node(key);
			return;
		}
		rear.next = new Node(key);
		rear = rear.next;
	}

	int dequeue(){
		if(isEmpty()){
			System.out.println("Underflow");
			return -1;
		}

		int value = front.key;
		front = front.next;
		if(front == null){
			rear = null;
		}
		
		return value;
	}

	boolean isEmpty(){
		return front == null;
	}

}


class Main{
	public static void main(String[] args){
		Queue q = new Queue();

		q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();

        System.out.println("Queue is empty : " + q.isEmpty());

        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        System.out.println("Dequeued item is "+ q.dequeue());
	}
}