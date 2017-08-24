// evaluation of postfix expr
/*
There are following limitations of above implementation.
1)	It supports only 4 binary operators ‘+’, ‘*’, ‘-‘ and ‘/’. 
	It can be extended for more operators by adding more switch cases.
2)	The allowed operands are only single digit operands. 
	The program can be extended for multiple digits by adding a separator like space between all elements - operators & operands
*/


import java.util.Stack;

class Main{

	static int evaluatePostfix(String exp){
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < exp.length(); i++){
			char ch = exp.charAt(i);
			if(Character.isDigit(ch)){
				stack.push(ch - '0');
			}
			else {
				int num1 = stack.pop();
				int num2 = stack.pop();
				switch(ch){
					case '+':
					stack.push(num2 + num1);
					break;

					case '-':
					stack.push(num2 - num1);
					break;

					case '*':
					stack.push(num2 * num1);
					break;

					case '/':
					stack.push(num2 / num1);
					break;
				}
			}
		}
		return stack.pop();
	}

	public static void main(String[] args){
		String exp="231*+9-";
        System.out.println(evaluatePostfix(exp));
	}
}