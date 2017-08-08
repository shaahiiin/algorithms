class Main{
	public static void main(String[] args){
		String str = "St  rin g wi th     man y spa    c    es  ";
		String s = "things";
		String ss = "    ";
		System.out.println(removeSpaces(str));
		System.out.println(removeSpaces(s));
		System.out.println(removeSpaces(ss));
	}

	static String removeSpaces(String str){
		char[] arr = str.toCharArray();
		int idx = 0;
		while(arr[idx] != ' '){
			idx++;
			if(idx == arr.length){
			    return str;
			}
		}

		for(int i = idx+1; i < arr.length; i++){
			char ch = arr[i];
			if(ch != ' '){
				arr[idx] = ch;
				idx++;
			}
		}
		return new String(arr, 0, idx);
	}
}