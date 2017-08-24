// Implement Queue using 2 stacks

/*
	Method 1 : make enqueue costly => on every push to s1, transfer it to stack2, push new elem to s2, transfer back to s1
	Method 2 : make dequeue costly => push new elems to s1, dequeue from s2, if s2 empty - transfer s1 to s2
	->	method 2 is preferred
	
	Another method is using single stack and recursion(function call stack) - code in another program
*/
import java.util.Stack;

class Main{
	static class Queue{
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		
		void enqueue(int data){
			s1.push(data);
		}

		void transfer(){
			while(!s1.isEmpty())
				s2.push(s1.pop());
		}

		int dequeue(){
			if(this.isEmpty()){
				System.out.println("Empty Queue");
				return -1;	// we can return Integer.MIN_VALUE if we are considering negative numbers
			}

			if(s2.isEmpty())
				this.transfer();

			return s2.pop();
		}

		boolean isEmpty(){
			return s1.isEmpty() && s2.isEmpty();
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