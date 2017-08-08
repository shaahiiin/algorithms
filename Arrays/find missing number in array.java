// find missing number in unordered array of natural numbers 1 to n

import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while(t-- > 0){
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n-1];
			String[] inStr = br.readLine().split(" ");
			
			for(int i = 0; i < n-1; i++){
				arr[i] = Integer.parseInt(inStr[i]);
			}

			int ans = missingNum(arr);
			
			System.out.println(ans);
		}
	}

	static int missingNum(int[] arr){
		int x1 = 0, x2 = 0;

		for(int i = 1; i <= arr.length + 1; i++){
			x1 ^= i;
		}

		for(int i = 0; i < arr.length; i++){
			x2 ^= arr[i];
		}

		return x1^x2;
	}
}