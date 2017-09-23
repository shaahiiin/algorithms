// dynamic programming
// overlapping subproblems =>
// 		memoization - Top down
// 		tabulation - Bottom up

// fibonacci number

class Main{
	static int[] lookup = new int[100];

	static int memoizationFib(int n){

		if(lookup[n] == 0){
			if(n <= 1)
				lookup[n] = n;
			else
				lookup[n] = memoizationFib(n-1) + memoizationFib(n-2);
		}

		return lookup[n];
	}

	static int tabulatedFib(int n){

		int[] fib = new int[n+1];
		fib[0] = 0;
		fib[1] = 1;

		for(int i = 2; i < n+1; i++){
			fib[i] = fib[i-1] + fib[i-2];
		}

		return fib[n];
	}

	public static void main(String[] args){

		System.out.println(memoizationFib(9));
		System.out.println(tabulatedFib(9));
	}
}