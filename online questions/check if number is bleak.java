// check if a number is bleak

class Main{
	public static void main(String[] args){
		int n = 4;

		System.out.println(isBleak(n));
	}

	public static boolean isBleak(int n){
		// for(int i = 0; i < n; i++){	// naive implementation
		int ceillog2 = (int)Math.ceil(Math.log(n) / Math.log(2));	// log base 2 n = log base x n / log base x 2
		for(int i = n - ceillog2; i < n; i++){	// if i is lower than n - ceillog2, the sum will never become  n
			int setBitCount = setBitCount(i);	// can use Integer.bitCount(i)
			if(i + setBitCount == n){
				return false;
			}
		}
		return true;
	}

	private static int setBitCount(int n){
		int count = 0;
		while(n > 0){
			n &= (n-1);
			count++;
		}
		return count;
	}
}