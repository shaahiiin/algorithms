// CodeChef :: Problem Code: CSUB

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			String str = br.readLine();

			int oneCount = countOnes(str);
			
			long ans = sumOfNaturalNums(oneCount);

			System.out.println(ans);
		}
	}

	public static int countOnes(String str) {
		int count = 0;
		for(char ch: str.toCharArray()) {
			if(ch == '1')
				count++;
		}
		return count;
	}

	public static long sumOfNaturalNums(long n) {
		return (n * (n+1)) / 2;
	}
}