// CodeChef
// Problem Code: CHN15A
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
			int n = Integer.parseInt(ins[0]);
			int k = Integer.parseInt(ins[1]);
			int[] values = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).map(x -> x + k).toArray();
			int count = 0;
			for(int i = 0; i < n; i++) {
			    if(values[i] % 7 == 0) {
			        count++;
			    }
			}
			System.out.println(count);
			
		}
	}
}