// CodeChef :: Problem Code: COPS

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.Stream;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {
			String[] ins = br.readLine().split(" ");
			int m = Integer.parseInt(ins[0]);
			int x = Integer.parseInt(ins[1]);
			int y = Integer.parseInt(ins[2]);

			int coverage = x * y;

			int[] values = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			boolean[] houses = new boolean[101];

			for(int i = 0; i < values.length; i++) {
				houses[values[i]] = true;
				int j = values[i] - 1;
				int ctr = coverage;
				// iterate left of house
				while(j > 0 && ctr > 0) {
					houses[j--] = true;
					ctr--;
				}
				ctr = coverage;
				j = values[i] + 1;
				// iterate right of house
				while(j < 101 && ctr > 0) {
					houses[j++] = true;
					ctr--;
				}
			}
			int ans = 0;
			for(int i = 1; i < 101; i++) {
				if(!houses[i]) {
					ans++;
				}
			}
			System.out.println(ans);

		}
	}
}