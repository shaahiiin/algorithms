// Permutations of a string using backtracking

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class Main {
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    // int t = 1;
	    
	    while(t-- > 0){
	        String s = br.readLine();
	        // String s = "ABC";

	        char[] arr = s.toCharArray();
	        Arrays.sort(arr);
	        s = new String(arr);
	        
	        permuteString(s, 0, s.length()-1);
	        
	    }

	    
	    
	}

	static void permuteString(String s, int l, int r){
	    	if(l == r){
	    		System.out.println(s);
	    	} else {
	    		for(int i = l; i <= r; i++){
	    			s = swap(s, l, i);
	    			permuteString(s, l+1, r);
	    			s = swap(s, l, i);
	    		}
	    	}
	    }

	    static String swap(String s, int i, int j){
	    	StringBuilder sb = new StringBuilder(s);

	    	char temp = sb.charAt(i);
	    	sb.setCharAt(i, sb.charAt(j));
	    	sb.setCharAt(j, temp);

	    	return sb.toString();
	    }
}