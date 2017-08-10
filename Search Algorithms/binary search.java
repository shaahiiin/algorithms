// binary search
/*
	Time complexity : O(log(n))
	Space complexity: 0(1)	for iterative, else
					: O(log(n)) for recursion call stack space
*/
class Main{
	public static void main(String[] args){
		int[] arr = new int[]{1, 2, 4, 5, 6, 9, 11, 15, 23};
		int key = 23;
		int idx = binarySearch(arr, 0, arr.length-1,  key);
		if(idx != -1)
			System.out.println("Index of key : " + ++idx);
		else
			System.out.println("Key Not found");
	}

	static int binarySearch(int[] arr, int low, int high, int key){
		if(low > high)
			return -1;

		// int mid = (low+high)/2;
		int mid = low + (high-low)/2;	// This statement avoids overflow of low + high

		if(key == arr[mid]){
			return mid;
		} else if(key < arr[mid]){
			return binarySearch(arr, low, mid-1, key);
		} else {
			return binarySearch(arr, mid+1, high, key);
		}
	}

	static int binarySearchIterative(int[] arr , int low, int high, int key ){
		while(low <= high){
			int mid = low + (high - low)/2;

			if(arr[mid] == key){
				return mid;
			} else if(key < arr[mid]){
				high = mid-1;
			} else{
				low = mid+1;
			}
		}
		return -1;
	}
}