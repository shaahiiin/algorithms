// CodeChef :: Problem Code: LAPIN

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {

			String str = br.readLine();

			System.out.println(checkLapin(str) ? "YES" : "NO");

		}
	}

	public static boolean checkLapin(String str) {
		int i = 0;
		int j = str.length() - 1;
		int[] alpha = new int[26];

		while(i < j) {
			alpha[str.charAt(i) - 'a']++;
			alpha[str.charAt(j) - 'a']--;
		}
		for(int num : alpha) {
			if(num != 0) {
				return false;
			}
		}
		return true;
	}
}