// check if a number y is power of another number x
// TODO - other algos for same problem
class Main {
	public static void main (String[] args) {
	    int x = 2, y = 8;

		System.out.println(isPower(x, y) ? 1 : 0);
	}

    static boolean isPower(int x, int y){
		if(x == 1)
			return y == 1;

		int pow = 1;
		while(pow < y){
			pow = pow * x;
		}
		return pow == y;
    }
}
