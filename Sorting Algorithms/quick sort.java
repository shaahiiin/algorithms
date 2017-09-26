// quick sort algorithm

class Quicksort{
    void quicksort(int[] arr, int p, int r){
        if(p < r){
            int q = partition(arr, p, r);
            quicksort(arr, p, q-1);
            quicksort(arr, q+1, r);
        }
    }
    int partition(int[] arr, int p, int r){
        int x = arr[r];
        int i = p - 1;
        for(int j = p; j < r; j++){
            if(arr[j] <= x){
                i += 1;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, r);
        return i+1;
    }
    void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j] ^ (arr[j] = arr[i]);
    }
}

class Main{
    public static void main(String[] args){
        int[] arr = new int[]{10, 6, 1, 7, 11, 3, 15, 9, 2, 4};
        new Quicksort().quicksort(arr, 0, arr.length-1);
        printArr(arr);
    }

    static void printArr(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
