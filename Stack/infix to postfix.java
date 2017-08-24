// infix to postfix
import java.util.Stack;

class Main{
	static int prec(char ch){
		if (ch == '+' || ch == '-')
			return 1;
		if (ch == '*' || ch == '/')
			return 2;
		if (ch == '^')
			return 3;
		return -1;
	}
	static String infixToPostfix(String exp){
		String result = new String();
		Stack<Character> stack = new Stack<>();

		for(int i = 0; i < exp.length(); i++){
			char ch = exp.charAt(i);

			if(Character.isLetterOrDigit(ch)){
				result += ch;
			}
			else if(ch == '('){
				stack.push(ch);
			}
			else if(ch == ')'){
				while(!stack.isEmpty() && stack.peek() != '('){
					result += stack.pop();
				}
				if(stack.isEmpty()){
					System.out.println("Invalid expression");
				} else {
					stack.pop();
				}
			}
			else{
				while(!stack.isEmpty() && prec(ch) <= prec(stack.peek())){
					result += stack.pop();
				}
				stack.push(ch);
			}
		}
		while(!stack.isEmpty()){
			result += stack.pop();
		}
		return result;
	}

	public static void main(String[] args){
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
	}
}