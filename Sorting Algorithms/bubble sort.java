// bubble sort
// O(n^2)

class Main{
	public static void main(String[] args){
		int[] arr = new int[] {64, 34, 25, 12, 22, 11, 90};

		bubbleSort(arr);

		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	static void bubbleSort(int[] arr){
		for(int p = 0; p < arr.length-1; p++){
			boolean swapped = false;
			for(int i = 0; i < arr.length-p-1; i++){
				// comparisons and swaps on mismatch
				if(arr[i] > arr[i+1]){
					arr[i] = arr[i+1] ^ arr[i] ^ (arr[i+1] = arr[i]); // swap one liner
					swapped = true;
				}

			}
			// if no swaps in one pass => break
			if(!swapped)
				break;
		}
	}
}