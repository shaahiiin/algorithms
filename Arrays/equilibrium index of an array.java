// equilibrium index of an array

class Main{
	public static void main(String[] args){
		int arr[] = {-7, 1, 5, 2, -4, 3, 0};
		int ans = eqIdx(arr);
        System.out.println(ans);
	}

	static int eqIdx(int[] arr){
		int left = 0;
		int right = 0;

		for(int i = 0; i < arr.length; i++){
			right += arr[i];
		}

		for(int i = 0; i < arr.length; i++){
            right -= arr[i];
            if(left == right){
                return i;
                // for getting all possible indices continue loop
                // System.out.println("eq idx: " + i);
            }
            left += arr[i];
		}
		
        return -1;
	}
}