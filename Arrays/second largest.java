// second largest element in an array

class Main{
    public static void main(String[] args){

        int[] arr = new int[]{3,1,6,7,2,12,90,3,13};
        int max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max2 = max;
                max = arr[i];
            } else if(arr[i] > max2){
                max2 = arr[i];
            }
        }

        System.out.println(max2);

    }
}
