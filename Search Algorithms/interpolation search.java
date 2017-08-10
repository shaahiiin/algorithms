// interpolation search
/*
	time complexity : O(log log n) Worse case O(n)
	space compelxity: O(1)
*/
class Main{
	public static void main(String[] args){
		int[] arr = new int[]{1, 2, 4, 5, 6, 9, 11, 15, 23, 27, 31};
		int key = 23;

		int idx = interpolationSearch(arr, key);
		if(idx != -1)
			System.out.println("Index of key : " + ++idx);
		else
			System.out.println("Key Not found");
	}

	static int interpolationSearch(int[] arr, int key){
		int low = 0, high = arr.length-1;

		while(low <= high && key >= arr[low] && key <= arr[high]){
			// (y-y1)/(x-x1) = (y2-y1)/(x2-x1) => x = x1 + (y-y1)*(x2-x1)/(y2-y1)
			int pos = low + ((key-arr[low])*(high - low))/ (arr[high] - arr[low]);

			if(key == arr[pos]){
				return pos;
			} else if(key < arr[pos]){
				high = pos - 1;
			} else {
				low = pos + 1;
			}
		}
		return -1;
	}
}