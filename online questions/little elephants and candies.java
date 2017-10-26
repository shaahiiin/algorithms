import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {
			String[] inp = br.readLine().split(" ");
			int n = Integer.parseInt(inp[0]);
			long c = Long.parseLong(inp[1]);
			long sum = 0;
			String[] inpValues = br.readLine().split(" ");
// 			String inpValues = br.readLine();

			for(int i = 0; i < n; i++) {
				sum += Long.parseLong(inpValues[i]);
				// sum += inpValues.charAt(i) - '0';
			}

			if(sum <= c) {
			    System.out.println("Yes");
			} else {
			    System.out.println("No");
			}
		}
	}
}