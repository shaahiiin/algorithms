// find subarry with given sum (non-negative number)

class Main{
	public static void main(String[] args){
		int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int n = arr.length;
        int sum = 23;
        subArraySum(arr, n, sum);	// should print 3 to 6
	}

	static void subArraySum(int[] arr, int n, int sum){
		int i = 0;
		int j = 1;
		int s = arr[0];
		while(j < n){
			if(s == sum){
				System.out.println("Sum found between " + i + " and " + --j);
				return;
			}
			else if(s < sum){
				s += arr[j];
				j++;    // j is always pointing to next array element to avoid IndexOutOfBoundsException
			}
			else if(s > sum){
				s -= arr[i];
				i++;
			}
		}
	}

}