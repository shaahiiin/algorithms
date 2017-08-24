// reverse words in a given string

class Main{
	// with inbuilt function string split (can be also done with pattern split(regex))
	static String reverseWithSplit(String str){
		String[] words = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = words.length-1; i >= 0; i--){
			sb.append(words[i] + " ");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	// without inbuilt functions
	// reverse individual words - then reverse the whole string
	static String reverse(String str){
		StringBuilder sb = new StringBuilder(str);
		int wordBegin = -1;

		for(int i = 0; i < sb.length(); i++){
			// if we're iterating spaces and suddenly encounter a word - start scanning the word using wordBegin
			if(wordBegin == -1 && sb.charAt(i) != ' '){
				wordBegin = i;
			}
			//if we're scanning a word and we encounter a space - reverse scanned word
			else if(wordBegin != -1 && sb.charAt(i) == ' '){
				//reverse string from wordBegin --> i-1
				reverseWord(sb, wordBegin, i-1);
				// sb.setCharAt(wordBegin, (char)((int)sb.charAt(i) ^ (int)sb.charAt(wordBegin) ^ (int) (sb.setCharAt(i, sb.charAt(wordBegin)))))
				wordBegin = -1;
			}
		}
		// if string doesn't end with space
		if(wordBegin != -1){
		    reverseWord(sb, wordBegin, sb.length()-1);
		}

		// reversing the whole string
		// we can simply use sb.reverse() but we don't want to use in-built functions.....
		reverseWord(sb, 0, sb.length()-1);

		return sb.toString();
	}
	
	// utility function to reverse i -> j in a StringBuilder
	static void reverseWord(StringBuilder sb, int i, int j){
		while(i < j){
			char temp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, temp);
			i++;
			j--;
		}
	}

	public static void main(String[] args){
		String str = "i like this program very much";

		System.out.println(reverseWithSplit(str));

		System.out.println(reverse(str));
	}
}