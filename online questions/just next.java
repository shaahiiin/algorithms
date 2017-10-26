// SPOJ :: Problem Code: JNEXT

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {
		    int n = Integer.parseInt(br.readLine());
			int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			int idx = findFirstDescNum(arr);

			if(idx == -1) {
				System.out.println(idx);
				continue;
			}

			int swapIdx = findJustGreaterNum(arr, idx);
			swap(arr, idx, swapIdx);
			
			reverse(arr, idx+1, arr.length-1);

			printArr(arr);

		}
	}

	static int findFirstDescNum(int[] arr) {
		for(int i = arr.length-1; i > 0; i--) {
			if(arr[i-1] < arr[i]) {
				return i-1;
			}
		}
		return -1;
	}

	static int findJustGreaterNum(int[] arr, int idx) {
		int justGreaterNum = idx+1;
		for(int i = idx+2; i < arr.length; i++) {
			if(arr[i] > arr[idx] && arr[i] < arr[justGreaterNum]) {
				justGreaterNum = i;
			}
		}
		return justGreaterNum;
	}

	static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j] ^ (arr[j] = arr[i]);
	}

	static void reverse(int[] arr, int i, int j) {
		while(i < j) {
			swap(arr, i, j);

			i++;
			j--;
		}
	}

	static void printArr(int[] arr) {
		for(int i : arr) {
			System.out.print(i);
		}
		System.out.println();
	}
}