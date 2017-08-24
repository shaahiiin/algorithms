// sort an array of 0s, 1s and 2s
// method 1: counting sort - will require 2 passes of array (not implemented in this code)
// method 2: swap elements as they occur, will require 3 passes of array (3 = no. of elements to sort)
// method 3: Dutch national flag algorithm aka. 3-way partitioning algorithm
//			-> small optimization: check if element to swap are same to avoid unnecessary swaps
class Main{
	public static void main(String[] args){
		int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        // sort012(arr);
        threeWayPartition(arr);
        System.out.println("Array after seggregation ");
        printArray(arr);
	}

	// method 2
	static void sort012(int[] arr){
		int i = 0;
		int j = 0;

		while(j < arr.length){
			if(arr[j] == 0){
				arr[i] = arr[j] ^ arr[i] ^ (arr[j] = arr[i]);	// one line swap (java)
				i++;
			}
			j++;
		}

		j = i;
		while(j < arr.length){
			if(arr[j] == 1){
				arr[i] = arr[j] ^ arr[i] ^ (arr[j] = arr[i]);
				i++;
			}
			j++;
		}

		j = i;
		while(j < arr.length){
			if(arr[j] == 2){
				arr[i] = arr[j] ^ arr[i] ^ (arr[j] = arr[i]);
				i++;
			}
			j++;
		}
	}

	// method 3
	static void threeWayPartition(int[] arr){
		int lo = 0;
		int mid = 0;
		int hi = arr.length-1;

		while(mid <= hi){
			switch(arr[mid]){
				case 0:
					arr[lo] = arr[mid] ^ arr[lo] ^ (arr[mid] = arr[lo]);	// one line swap (java)
					lo++;
					mid++;
					break;
				case 1:
					mid++;
					break;
				case 2:
					arr[hi] = arr[mid] ^ arr[hi] ^ (arr[mid] = arr[hi]);
					hi--;
					break;
			}
		}

	}

	static void printArray(int[] arr){
		for(int elem: arr){
			System.out.print(elem + " ");
		}
		System.out.println();
	}
}