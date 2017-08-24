// insertion sort
// O(n^2)

class Main{
	public static void main(String[] args){
		int[] arr = new int[]{12, 11, 13, 5, 6};

		insertionSort(arr);

		// print array
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	static void insertionSort(int[] arr){
		for(int i = 1; i < arr.length; i++){
			int key = arr[i];
			int j = i-1;

			while(j >= 0 && arr[j] > key){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
}