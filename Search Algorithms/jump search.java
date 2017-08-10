// jump search
/*
	Time complexity : O(n/m + (m-1)) => (sqrt(n)) [m is minimum if it is sqrt(n)]
	Space complexity: O(1)
*/
class Main{
	public static void main(String[] args){
		int[] arr = new int[]{1, 2, 4, 5, 6, 9, 11, 15, 23, 27, 31};
		int key = 23;

		int idx = jumpSearch(arr, key);
		if(idx != -1)
			System.out.println("Index of key : " + ++idx);
		else
			System.out.println("Key Not found");
	}

	static int jumpSearch(int[] arr, int key){
		int n = arr.length;
		int step = (int)Math.sqrt(n);
        int prev = 0;
        
		// searching for the block which contains key
		while(arr[Math.min(step, n) -1] < key){
			prev = step;
			step += (int)Math.sqrt(n);
			if(prev >= n)
				return -1;
		}

		// linear search for the key
		while(prev < step && prev < n){
			if(arr[prev] == key)
				return prev;
			prev++;
		}
		return -1;
	}

}