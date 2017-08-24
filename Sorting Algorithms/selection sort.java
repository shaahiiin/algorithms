// selection sort
// O(n^2)

class Main{
	public static void main (String[] args){
		int[] arr = new int[] {3, 2, 6, 14, 1, 8, 7, 2};

		sort(arr);

		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	static void sort(int[] arr){
		for(int i = 0; i < arr.length - 1; i++){
			int min = i;
			for(int j = i+1; j < arr.length; j++){
				if(arr[j] < arr[min]){
					min = j;
				}
			}
			// one line swap
			arr[i] = arr[min] ^ arr[i] ^ (arr[min] = arr[i]);
		}
	}
}