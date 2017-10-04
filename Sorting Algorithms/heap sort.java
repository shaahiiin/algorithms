// HeapSort

class Heapsort{
    int parent(int i){
        return (i-1)/2;
    }
    int leftChild(int i){
        return 2*i + 1;
    }
    int rightChild(int i){
        return 2*i + 2;
    }
    void swap(int[] arr, int i, int j){
        arr[i] = arr[j] ^ arr[i] ^ (arr[j] = arr[i]);
    }

    void heapsort(int[] arr){
        int n = arr.length;

        // maxHeapify all nodes except leaf nodes
        for(int i = n/2 - 1; i >= 0; i--){
            maxHeapify(arr, i, arr.length);
        }

        // replace first value (max) with last node
        // then call maxHeapify on first value for array size i-1
        for(int i = n-1; i > 0; i--){
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }
    }

    void maxHeapify(int[] arr, int i, int n) {
        int highest = i;
        int left = leftChild(i);
        int right = rightChild(i);
        if(left < n && arr[highest] < arr[left])
            highest = left;
        if(right < n && arr[highest] < arr[right])
            highest = right;

        if(highest != i){
            swap(arr, highest, i);
            maxHeapify(arr, highest, n);
        }
    }
}

// Driver function
class Main{
    public static void main(String[] args){
        int[] arr = new int[]{10, 6, 1, 7, 11, 3, 15, 9, 2, 4};
        new Heapsort().heapsort(arr);
        System.out.println(java.util.Arrays.toString(arr));
    }
}
