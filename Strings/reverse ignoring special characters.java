import java.util.*;
import java.io.*;

class GFG {

	static boolean isAlpha(char ch){
		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
	}

	static String reverse(String str){
		StringBuilder s = new StringBuilder(str);

		int i = 0; 
		int j = s.length()-1;
        
        outer:
		while(i < j){
			//iterate till i and j are pointing to alphabets, then swap (if still i < j)
			if(!isAlpha(s.charAt(i))){
				i++;
			} else if(!isAlpha(s.charAt(j))){
				j--;
			} else {
    			//swap
    			char temp = s.charAt(i);
    			s.setCharAt(i, s.charAt(j));
    			s.setCharAt(j, temp);
    			i++;
    			j--;
			}
		}

		return s.toString();
	}
	
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    
	    while(t-- > 0){
	        String s = br.readLine();

	        System.out.println(reverse(s));

	    }
	    
	}
}