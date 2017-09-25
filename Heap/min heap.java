// min heap and basic functions of a min heap
class MinHeap{
    int[] arr;
    int heapSize;
    MinHeap(){
        arr = new int[1000];  // can make one more constructor for more capacity
        heapSize = 0;
    }
    int parent(int i){
        return (i-1)/2;
    }
    int leftChild(int i){
        return 2*i+1;
    }
    int rightChild(int i){
        return 2*i+2;
    }
    int getMin(){
        return arr[0];
    }
    int extractMin(){
        if(heapSize == 0)
            return Integer.MIN_VALUE;
        if(heapSize == 1){
            heapSize--;
            return arr[0];
        }

        int min = arr[0];
        arr[0] = arr[heapSize-1];
        heapSize--;
        minHeapify(0);

        return min;
    }

    void insertKey(int value){
        if(heapSize == arr.length){
            System.out.println("Overflow");
            return;
        }

        heapSize++;
        int i = heapSize-1;
        arr[i] = value;
        while(i != 0 && arr[parent(i)] > arr[i]){
            swap(i, parent(i));
            i = parent(i);
        }
    }
    void deleteKey(int i){
        // int lastIdx = heapSize-1;
        // if(arr[lastIdx] > arr[i]){
        //     // push it down the heap
        //     arr[i] = arr[lastIdx];
        //     heapSize--;
        //     minHeapify(i);
        // }
        // else{
        //     // push it up the heap
        //     arr[i] = arr[lastIdx];
        //     heapSize--;
        //     while(i != 0 && arr[parent(i)] > arr[i]){
        //         swap(i, parent(i));
        //         i = parent(i);
        //     }
        // }
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }
    // decrease value at index i to value val
    void decreaseKey(int i, int val){
        arr[i] = val;
        while(i != 0 && arr[parent(i)] > arr[i]){
            swap(i, parent(i));
            i = parent(i);
        }
    }
    // increase value at index i to value val
    void increaseKey(int i, int val){
        arr[i] = val;
        minHeapify(i);
    }
    void minHeapify(int i){
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;
        if(left < heapSize && arr[left] < arr[smallest]){
            smallest = left;
        }
        if(right < heapSize && arr[right] < arr[smallest]){
            smallest = right;
        }
        if(smallest != i){
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    // swaps heap value at index i and j
    void swap(int i, int j){
        arr[i] = arr[i] ^ arr[j] ^ (arr[j] = arr[i]);
    }

    // util function to print heap, which is needlessly complicated
    void printHeap(){
        int h = 0;
        int i = 0;
        System.out.println("Heap :");
        while(i < heapSize){
            for(int j = 0; j < Math.pow(2, h) && i < heapSize; j++){
                System.out.print(arr[i] + " ");
                i++;
            }
            System.out.println();
            h++;
        }
        System.out.println();
    }
}

class Main{
    public static void main(String[] args){
        MinHeap heap = new MinHeap();
        heap.insertKey(3);
        heap.insertKey(2);
        heap.deleteKey(1);
        heap.insertKey(15);
        heap.insertKey(5);
        heap.insertKey(4);
        heap.insertKey(45);
        System.out.println("Extract min: " + heap.extractMin());
        heap.printHeap();
        System.out.println("Get min: " + heap.getMin());
        heap.decreaseKey(2, 1);
        System.out.println("Get min after decreaseKey(2,1) " + heap.getMin());
        heap.printHeap();

        // Manually building new heap
        heap.arr[0] = 1;
        heap.arr[1] = 2;
        heap.arr[2] = 20;
        heap.arr[3] = 3;
        heap.arr[4] = 4;
        heap.arr[5] = 50;
        heap.arr[6] = 60;
        heap.arr[7] = 5;
        heap.arr[8] = 6;
        heap.arr[9] = 7;
        heap.arr[10] = 8;

        heap.heapSize = 11;
        heap.deleteKey(5);
        heap.printHeap();
    }
}
