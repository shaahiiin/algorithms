class DualStack{
	int[] arr;
	int top1;
	int top2;

	DualStack(){
		arr = new int[6];
		top1 = -1;
		top2 = arr.length;
	}

	void push1(int data){
		if(top1 >= top2 - 1){
			System.out.println("Stack Overflow");
			return;
		}
		arr[++top1] = data;
	}

	int pop1(){
		if(top1 == -1){
			System.out.println("Stack underflow");
			return -1;
		}
		int val = arr[top1];
		top1--;
		return val;
	}
	
	void push2(int data){
		if(top1 >= top2 - 1){
			System.out.println("Stack Overflow");
			return;
		}

		arr[--top2] = data;
	}

	int pop2(){
		if(top2 == arr.length){
			System.out.println("Stack underflow");
			return -1;
		}
		int val = arr[top2--];
		return val;
	}

	void display(){
		System.out.println("Stack 1 :");
		for(int i = 0; i <= top1; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		System.out.println("Stack 2 :");
		for(int i = arr.length - 1; i >= top2; i--){
			System.out.print(arr[i] + " ");
		}
        System.out.println();
	}
}

class Main{
	public static void main(String[] args){
		DualStack stk = new DualStack();

		stk.push1(1);
		stk.push1(2);
		stk.push1(3);
		stk.display();

		stk.push2(10);
		stk.push2(20);
		stk.push2(30);
		stk.display();
		System.out.println(stk.pop2());

	}
}