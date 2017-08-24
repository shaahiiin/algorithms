// print leaders in an array - an element is a leader if it is greater than all of the elements to its right

class Main{
	public static void main(String[] args){
		int[] arr = new int[] {16, 17, 4, 3, 5, 2};
		printLeaders(arr);
	}

	static String printLeaders(int[] arr){
		int maxRight = Integer.MIN_VALUE;
		for(int i = arr.length-1; i >= 0; i--){
			if(arr[i] > maxRight){
				System.out.print(arr[i] + " ");
				maxRight = arr[i];
			}
		}
		System.out.println();
	}
}