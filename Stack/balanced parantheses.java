class Stack{
	char[] arr;
	int top;
	int size;
	static final int MAX_SIZE = 1000;
	Stack(){
		arr = new char[MAX_SIZE];
		top = -1;
		size = 0;
	}

	void push(char data){
		if(size == MAX_SIZE - 1){
			System.out.println("Stack Overflow");
			return;
		}
		arr[++top] = data;
		size++;
	}

	char pop(){
		if(isEmpty()){
			System.out.println("Stack Underflow");
			return 'E';
		}
		char val = arr[top];
		top--;
		size--;
		return val;
	}

	boolean isEmpty(){
		return size == 0;
	}
}

class CheckBalancedParanthesis{
    
    static boolean isMatchingPair(char c1, char c2){
		if((c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']'))
			return true;
		return false;
	}
    
	public static boolean isBalanced(String s){
		Stack stk = new Stack();

		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			if(ch == '(' || ch == '{' || ch == '['){
				stk.push(ch);
			} else if(ch == ')' || ch == '}' || ch == ']'){
				if(!isMatchingPair(stk.pop(), ch)){
					return false;
				}
			}
		}
		if(!stk.isEmpty()){
			return false;
		}
		return true;
	}

	public static void main(String[] args){

		String str1 = "(){[()]}";
		String str2 = "(){[()]}}";
		String str3 = "(){[()]";

		System.out.println(isBalanced(str1));
		System.out.println(isBalanced(str2));
		System.out.println(isBalanced(str3));

	}
}
