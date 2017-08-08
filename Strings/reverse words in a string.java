// reverse words in a string (words separated by .)

import java.io.*;

class Main {
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    
	    while(t-- > 0){
	        String s = br.readLine();
	        String[] words = s.split("\\.");
	        
	        String separator = "";
	        for(int i = words.length-1; i >= 0; i--){
    	        System.out.print(separator + words[i]);
    	        separator = ".";
	        }
	        System.out.println();
	    }
	    
	}
}