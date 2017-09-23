class Main{
	public static void main(String[] args){
		String str = "St  rin g wi th     man y spa    c    es  ";
		String s = "things";
		String ss = "    ";
		System.out.println(removeSpaces(str));
		System.out.println(removeSpaces(s));
		System.out.println(removeSpaces(ss));
	}

	static String removeSpaces(String s){
		char[] str = s.toCharArray();
        int count = 0;
        
        for(int i = 0; i < str.length; i++){
            if(str[i] != ' ')
                str[count++] = str[i];
        }
        
        String ans = new String(str, 0, count);
        return ans;
    }
}