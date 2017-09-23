// queue implementation with array

class Queue{
	int front, rear, size;
	int[] queue;
	Queue(int capacity){
		front = 0;
		rear = -1;
		size = 0;
		queue = new int[capacity];
	}

	void enqueue(int data){
		if(isFull()){
			System.out.println("Overflow");
			return;
		}
		size++;
		queue[++rear%queue.length] = data;
	}

	int dequeue(){
		if(isEmpty()){
			System.out.println("Underflow");
			return -1;
		}
		size--;
		int value = queue[front];
		queue[front] = 0;
		front = ++front % queue.length;
		return value;
	}

	boolean isEmpty(){
		// if((rear+1)%queue.length == front && queue[front] == 0)	// array initialized with 0; 0 set on dequeue
			// return true;
		// else
			// return false;
		return size == 0;
	}
	boolean isFull(){
		// if((rear+1)%queue.length == front && queue[front] != 0)	// array initialized with 0; 0 set on dequeue
			// return true;
		// else
			// return false;
		return size == queue.length;
	}

}

class Main{
	public static void main(String[] args){
		Queue q = new Queue(5);
		q.enqueue(3);
		q.enqueue(5);
		q.enqueue(7);
		q.enqueue(9);
		q.enqueue(11);

		System.out.println(q.isFull());
		System.out.println(q.isEmpty());

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

		System.out.println(q.dequeue());

		System.out.println(q.isFull());
		System.out.println(q.isEmpty());
	}
}