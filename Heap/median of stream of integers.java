// Find median of elements read so far
// insertion sort, augmented self-balanced BST (AVL, RB, etc...)
// Heaps (below implementation)

import java.util.PriorityQueue;
import java.util.Collections;

class MedianUsingHeap{
    private PriorityQueue<Integer> leftHeap;
    private PriorityQueue<Integer> rightHeap;
    protected int median;

    MedianUsingHeap(){
        rightHeap = new PriorityQueue<>();
        leftHeap = new PriorityQueue<>(11, Collections.reverseOrder(rightHeap.comparator()));
        median = 0;
    }

    int sig(int leftCount, int rightCount){
        if(leftCount == rightCount)
            return 0;
        return leftCount < rightCount ? -1 : 1;
    }

    void insert(int newVal){
        int sig = sig(leftHeap.size(), rightHeap.size());
        switch(sig){
            case -1:    // left has lesser elements
                if(newVal < median){
                    leftHeap.offer(newVal);
                } else {
                    leftHeap.offer(rightHeap.poll());
                    rightHeap.offer(newVal);
                }
                break;
            case 0:     // same no. of elements
                if(newVal < median)
                    leftHeap.offer(newVal);
                else
                    rightHeap.offer(newVal);
                break;
            case 1:     // rightHeap has less elements
                if(newVal < median){
                    rightHeap.offer(leftHeap.poll());
                    leftHeap.offer(newVal);
                } else {
                    rightHeap.offer(newVal);
                }
                break;
        }
        // System.out.println("leftHeap : " + leftHeap);
        // System.out.println("rightHeap : " + rightHeap);
        median = calculateMedian();
    }

    private int calculateMedian(){
        int leftTop = leftHeap.peek() == null ? 0 : leftHeap.peek();
        int rightTop = rightHeap.peek() == null ? 0 : rightHeap.peek();

        int sig = sig(leftHeap.size(), rightHeap.size());
        if(sig == -1)
            return rightTop;
        else if(sig == 1)
            return leftTop;
        else
            return (leftTop + rightTop) / 2;
    }
}


// Driver code
class Main{
    public static void main(String[] args){
        MedianUsingHeap heaps = new MedianUsingHeap();
        int[] arr = new int[]{5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        for(int i = 0; i < arr.length; i++){
            heaps.insert(arr[i]);
            System.out.print(heaps.median + " ");
        }
        System.out.println();
    }
}
