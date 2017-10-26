// CodeChef
// Problem Code: SALARY
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.Stream;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] values = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
			int inc = 0;

			for(int i = 1; i < n; i++) {
				values[i] += inc;
				int diff = values[i] - values[i-1];
				inc += diff;
			}
			System.out.println(inc);
			
		}
	}
}