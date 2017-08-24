// reverse string using stack
import java.util.Stack;

class Main{
	static String reverse(String str){
		// the following one liner will work
		// return new StringBuilder(str).reverse().toString();

		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < str.length(); i++){
			stack.push(str.charAt(i));
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args){
		String str = "abcdefghijk";
		System.out.println(reverse(str));
	}
}