// ternary search
/*
	Time complexity : O(log(n))
	Space complexity: 0(1)	for iterative, else
					: O(log(n)) for recursion call stack space
*/
class Main{
	public static void main(String[] args){
		int[] arr = new int[]{1, 2, 4, 5, 6, 9, 11, 15, 23};
		int key = 23;
		int idx = ternarySearch(arr, 0, arr.length-1,  key);
		if(idx != -1)
			System.out.println("Index of key : " + ++idx);
		else
			System.out.println("Key Not found");
	}

	static int ternarySearch(int[] arr, int low, int high, int key){
		if(low > high)
			return -1;

		int mid1 = low + (high-low)/2;
		int mid2 = mid1 + (high-low)/2;

		if(key == arr[mid1])
			return mid1;
		if(key == arr[mid2])
			return mid2;

		if(key < arr[mid1])
			return ternarySearch(arr, low, mid1-1, key);
		else if(key > arr[mid2])
			return ternarySearch(arr, mid2+1, high, key);
		else
			return ternarySearch(arr, mid1+1, mid2-1, key);
	}
}