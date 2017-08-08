// Kadane's algorithm
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while(t-- > 0){
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			String[] inStr = br.readLine().split(" ");
			
			for(int i = 0; i < n; i++){
				arr[i] = Integer.parseInt(inStr[i]);
			}

			int ans = kadanesAlgorithm(arr);
			
			System.out.println(ans);
		}
	}

	static int kadanesAlgorithm(int[] arr){
		int currMax = arr[0];
		int gMax = arr[0];
		int start = 0, end = 0;

		for(int i = 1; i < arr.length; i++){
			if(arr[i] > arr[i] + currMax){
				currMax = arr[i];
				start = i;
			} else {
				currMax += arr[i];
			}

			if(currMax > gMax){
				gMax = currMax;
				end = i;
			}
		}
		// print 1-based index of subarray
		// System.out.println("Start => " + ++start + "; End => " + ++end);

		return gMax;
	}
}