// CodeChef :: Problem Code: RAINBOWA

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.regex.Pattern;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			String s = br.readLine().replaceAll("\\s", "");
			
			// below regex checks for a fixed palindrome
			System.out.println(Pattern.matches("(1+)(2+)(3+)(4+)(5+)(6+)7+\\6\\5\\4\\3\\2\\1", s));

			
		}
	}
}