class Main{
	static class Stack{
		int top = -1;
		int[] stack = new int[100];

		void push(int data){
			if(top == 99){
				System.out.println("Overflow");
				return;
			}

			stack[++top] = data;
		}

		int pop(){
			if(isEmpty())
				return -1;

			return stack[top--];
		}

		boolean isEmpty(){
			return this.top == -1;
		}
	}

	public static void main(String[] args){
		int[] arr = new int[]{11, 13, 21, 3};

		printNGE(arr);
	}

	static void printNGE(int[] arr){
		Stack stack = new Stack();
		
		stack.push(arr[0]);

		for(int i = 1; i < arr.length; i++){
			if(stack.isEmpty()){
				stack.push(arr[i]);
				continue;
			}

			int top = stack.pop();
			int next = arr[i];

			while(top < next){
				System.out.println(top + " -> " + next);
				if(stack.isEmpty())
				    break;
				top = stack.pop();
			}

			if(top > next){
				stack.push(top);
			}

			stack.push(next);

		}

		while(!stack.isEmpty()){
			System.out.println(stack.pop() + " -> " + -1);
		}
		

	}
}