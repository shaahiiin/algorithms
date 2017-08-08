class Main{
	static String reverse(String s){
		if(s.length() == 1)
			return s;
		return s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
	}

	public static void main(String[] args){
		String str = "Hello world";

		System.out.println(reverse(str));
	}
}