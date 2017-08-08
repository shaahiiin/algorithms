class Main{
	public static void main(String[] args){
		String s = "The quick brown fox jumps over the lazy dog";
		String s2 = "Just another sentence";

		System.out.println(isPangram(s));
		System.out.println(isPangram(s2));
	}

	static boolean isPangram(String s){
		boolean[] alpha = new boolean[26];

		for(char ch : s.toLowerCase().toCharArray()){
			if(!(ch >= 'a' && ch <= 'z'))
				continue;
			alpha[ch-'a'] = true;
		}

		for(boolean b: alpha){
			if(!b)
				return false;
		}
		return true;
	}
}