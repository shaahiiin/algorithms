// linear search
/*
	Time complexity : O(n)
	Space complexity: 0(1)
*/
class Main{
	public static void main(String[] args){
		int[] arr = new int[]{1, 4 ,2 ,6 ,7, 3, 5, 9};
		int key = 5;
		int idx = linearSearch(arr, key);
		if(idx != -1)
			System.out.println("Index of key : " + ++idx);
		else
			System.out.println("Key Not found");
	}

	static int linearSearch(int[] arr, int key){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == key){
				return i;
			}
		}
		return -1;
	}
}