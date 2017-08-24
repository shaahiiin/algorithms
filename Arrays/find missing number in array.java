// find missing number in an array containing values 1 -> n
// 2 methods

class Main{
	public static void main(String[] args){
		int arr[] = {1,2,4,5,6};
		int mis = getMissingNum(arr, 5);
		int mis2 = getMissingNumXor(arr, 5);
		
		System.out.println(mis);
		System.out.println(mis2);	// should output 3 for both prints
	}

	static int getMissingNum(int[] arr, int n){
		int sum = ((n+1)*(n+2))/2;
		for(int i = 0; i < n; i++){
			sum -= arr[i];
		}
		return sum;

	}
	static int getMissingNumXor(int[] arr, int n){
		int xor1 = 0;
		int xor2 = 0;

		// xor of all array elements
		for(int i = 0; i < n; i++){
			xor1 ^= arr[i];
		}
		// xor of all nums from 1 to n+1
		for(int i = 1; i <= n+1; i++){
			xor2 ^= i;
		}
		
		return xor1 ^ xor2;
	}
}