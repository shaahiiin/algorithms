// stack using two queues


class StackUsingQueue{
	Queue q1 = new Queue();
	Queue q2 = new Queue();

	class Queue{
		int[] queue = new int[4];
		int rear = -1;
		int front = 0;
		int size = 0;

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
			front = ++front%queue.length;
			return value;
		}

		boolean isEmpty(){
			return size == 0;
		}
		boolean isFull(){
			return size == queue.length;
		}
	}

	void push(int data){
		if(isFull()){
			System.out.println("Overflow");
			return;
		}
		q2.enqueue(data);
		while(!q1.isEmpty()){
			q2.enqueue(q1.dequeue());
		}
		// swap to avoid another switch
		Queue temp = q1;
		q1 = q2;
		q2 = temp;
	}

	int pop(){
		if(isEmpty()){
			System.out.println("Underflow");
			return -1;
		}
		
		return q1.dequeue();
	}

	boolean isEmpty(){
		return q1.isEmpty();
	}

	boolean isFull(){
		return q1.isFull();
	}
}

class Main{
	public static void main(String[] args){
		StackUsingQueue stack = new StackUsingQueue();

		stack.push(3);
		stack.push(6);
		stack.push(9);
		stack.push(12);
		stack.push(99);

		System.out.println(stack.isEmpty());
		System.out.println(stack.isFull());

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		System.out.println(stack.pop());

		System.out.println(stack.isEmpty());
		System.out.println(stack.isFull());

	}
}