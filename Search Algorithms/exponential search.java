// exp search
/*
	time complexity : O(log n)
	space compelxity: O(1) if binarySearch is not recursive
*/
import java.util.Arrays;

class Main{
	public static void main(String[] args){
		int[] arr = new int[]{1, 2, 4, 5, 6, 9, 11, 15, 23, 27, 31};
		int key = 23;

		int idx = exponentialSearch(arr, key);
		if(idx != -1)
			System.out.println("Index of key : " + ++idx);
		else
			System.out.println("Key Not found");
	}

	static int exponentialSearch(int[] arr, int key){
		if(arr[0] == key)
			return 0;

		int i = 1;
		
		while(i < arr.length && arr[i] <= key){
			i = i*2;
		}

		return Arrays.binarySearch(arr, i/2, Math.min(i,arr.length), key);

	}
}