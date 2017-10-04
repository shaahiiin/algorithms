// Sort elements by frequency
// O(nLogN)

import java.util.Arrays;
import java.util.Comparator;

class Main{
    class Element{
        int index;
        int value;
        int count;
    }
    class NaturalComparator implements Comparator<Element>{
        @Override
        public int compare(Element o1, Element o2){
            if(o1.value == o2.value)
                return 0;
            return o1.value < o2.value ? -1 : 1;
        }
    }
    class FrequencyComparator implements Comparator<Element>{
        @Override
        public int compare(Element o1, Element o2){
            if(o1.count == o2.count){
                if(o1.index == o2.index)
                    return 0;
                return o1.index < o2.index ? -1 : 1;    // priority to earlier indices
            }
            return o1.count < o2.count ? 1 : -1;    // decreasing order sort
        }
    }
    void frequencySort(int[] arr){
        Element[] elements = new Element[arr.length];
        for(int i = 0; i < arr.length; i++){
            elements[i] = new Element();
            elements[i].index = i;
            elements[i].value = arr[i];
            elements[i].count = 0;
        }
        Arrays.sort(elements, new NaturalComparator());

        elements[0].count = 1;
        for(int i = 1; i < elements.length; i++){
            if(elements[i].value == elements[i-1].value){
                elements[i].count = elements[i-1].count + 1;
                elements[i-1].count = -1;
                elements[i].index = elements[i-1].index;
            } else {
                elements[i].count = 1;
            }
        }

        Arrays.sort(elements, new FrequencyComparator());

        for(int i = 0, index = 0; i < elements.length; i++){
            if(elements[i].count != -1)
                for(int j = 0; j < elements[i].count; j++)
                    arr[index++] = elements[i].value;
        }
    }



    public static void main(String[] args){
        int[] arr = new int[]{2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};

        System.out.println("Before sorting :");
        System.out.println(Arrays.toString(arr));
        System.out.println();

        new Main().frequencySort(arr);

        System.out.println("After sorting :");
        System.out.println(Arrays.toString(arr));
    }
}
