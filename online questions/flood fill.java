// flood fill algorithm

import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0){

			String[] ins = br.readLine().split(" ");
			int m = Integer.parseInt(ins[0]);
			int n = Integer.parseInt(ins[1]);
			int[][] matrix = new int[m][n];
            int color;


			ins = br.readLine().split(" ");
			int insCount = 0;
			
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					matrix[i][j] = Integer.parseInt(ins[insCount++]);
				}
			}
    
			ins = br.readLine().split(" ");
			int i = Integer.parseInt(ins[0]);
			int j = Integer.parseInt(ins[1]);
			color = Integer.parseInt(ins[2]);

			floodFill(matrix, i, j, matrix[i][j], color);
			
            for(int[] row: matrix){
            	for(int value: row){
            		System.out.print(value + " ");
            	}
            }
            System.out.println();

		}
	}
	static int count(int[][] matrix, int val){
		int count = 0;
		for(int[] i: matrix){
			for(int j: i)
				if(j == val)
					count++;
		}
		return count;
	}

	static void floodFill(int[][] matrix, int i, int j, int prevColor, int color){
		//Main logic
		if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length)
			return;
		if(matrix[i][j] != prevColor){
			return;
		} else {
            matrix[i][j] = color;
    		floodFill(matrix, i+1, j, prevColor, color);
    		floodFill(matrix, i, j+1, prevColor, color);
    		floodFill(matrix, i-1, j, prevColor, color);
    		floodFill(matrix, i, j-1, prevColor, color);
		}
	}

}