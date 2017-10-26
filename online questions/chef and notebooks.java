import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {
			String[] inp = br.readLine().split(" ");
			int x = Integer.parseInt(inp[0]);
			int y = Integer.parseInt(inp[1]);
			int k = Integer.parseInt(inp[2]);
			int n = Integer.parseInt(inp[3]);
			boolean canBuy = false;
			x -= y;

			for(int i = 0; i < n; i++) {
				String[] inpValues = br.readLine().split(" ");
				int p = Integer.parseInt(inpValues[0]);
				int c = Integer.parseInt(inpValues[1]);

				if(p >= x && c <= k) {
					canBuy = true;
					break;
				}
			}

			if(canBuy) {
				System.out.println("LuckyChef");
			} else {
				System.out.println("UnluckyChef");
			}
		}
	}
}