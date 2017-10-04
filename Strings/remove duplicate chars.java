class Main{
	public static void main(String[] args){
		String str = "aaabbbbbbccdddddaaddee";

		System.out.println(removeDuplicates(str));
	}

	static String removeDuplicates(String str){
		int[] alpha = new int[26];
		StringBuilder sb = new StringBuilder();
		for(char ch: str.toCharArray()){
		    if(!(ch >= 'a' && ch <= 'z')){
		        sb.append(ch);
		    }
			else if(alpha[ch - 'a'] > 0){
				continue;
			} else {
				sb.append(ch);
				alpha[ch - 'a']++;
			}
		}
		return sb.toString();
	}
}
