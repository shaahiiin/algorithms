// flood fill algorithm

import java.util.Arrays;
import java.io.*;

class Main{
	public static void main(String[] args){
		// int t = br.readLine();
		int t = 1;
		while(t-- > 0){
			// int n = br.readLine();

			int m = 3, n = 4;
            // int[][] arr = {{0,1,1,0},{1,1,1,1},{0,1,2,3}};
            int arr[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                      {1, 1, 1, 1, 1, 1, 0, 0},
                      {1, 0, 0, 1, 1, 0, 1, 1},
                      {1, 2, 2, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 2, 2, 0},
                      {1, 1, 1, 1, 1, 2, 1, 1},
                      {1, 1, 1, 1, 1, 2, 2, 1},
                     };
            // System.out.println(Arrays.deepToString(arr));

            int initial = count(arr, 1);
            printArr(arr);
            int i = -1, j = -1;
            outer:
			for(i = 0; i < m; i++){
				for(j = 0; j < n; j++){
					if(arr[i][j] == 1)
						break;
				}
			}

			floodFill(arr, i, j);
            // System.out.println(Arrays.deepToString(arr));
            printArr(arr);

            int current = count(arr, 7);
            System.out.println(initial == current);

		}
	}
	static int count(int[][] arr, int val){
		int count = 0;
		for(int[] i: arr){
			for(int j: i)
				if(j == val)
					count++;
		}
		return count;
	}

	static void floodFill(int[][] arr, int i, int j){
		//Main logic
		if(i < 0 || j < 0 || i >= arr.length || j >= arr.length)
			return;
		if(arr[i][j] != 1){
			return;
		} else {
		    // System.out.println("i => "+i+ " j => "+ j);
            arr[i][j] = 7;
    		floodFill(arr, i+1, j);
    		floodFill(arr, i, j+1);
    		floodFill(arr, i-1, j);
    		floodFill(arr, i, j-1);	
		}
	}
	static void printArr(int[][] arr){
		for(int[] i: arr){
			for(int val: i){
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
}