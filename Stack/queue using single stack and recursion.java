//  Implement queue using one user stack and one Function Call Stack

import java.util.Stack;

class Main{
	static class Queue{
		Stack<Integer> stack = new Stack<>();

		void enqueue(int data){
			stack.push(data);
		}

		int dequeue(){
			if(this.isEmpty()){
				System.out.println("Empty Queue");
				return -1;
			}

			int x = stack.pop(), front;

			if(this.isEmpty()){
				return x;
			}
			else {
				front = this.dequeue();
				this.enqueue(x);
				return front;
			}
		}

		boolean isEmpty(){
			return this.stack.isEmpty();
		}
	}

	public static void main(String[] args){
		Queue q = new Queue();
		q.enqueue(9);
		q.enqueue(7);
		q.enqueue(1);
		q.enqueue(8);
		q.enqueue(11);

		while(!q.isEmpty())
			System.out.println(q.dequeue() + " ");
		
		System.out.println(q.dequeue());	// should print error
	}
}