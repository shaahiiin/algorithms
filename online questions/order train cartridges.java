// given input of 2d arrays representing train cartridges, we have to connect the cartridges such that
// back number one cartridge is equal to the front number of the next cartridge.
// The output must be the index of the cartridges in the correct connected order

class Main{
    public static void main(String[] args){
        int[][] arr = {{8,3}, {3,1}, {9,8}};

        func(arr);

    }

    public static boolean func(int[][] arr){
        int[] list = new int[10000];

        // increment every first number and decrement every back number in the list array
        for(int i = 0; i < arr.length; i++){
            list[arr[i][0]]++;
            list[arr[i][1]]--;
        }

        // after above operation only the first cartridges first index will be having 1 in list array
        int i = 0;
        for(i = 0; i < arr.length; i++){
            if(list[arr[i][0]] == 1)
                break;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(i);
        while(list[arr[i][1]] != -1){	// last cartridges second index will be -1 in list array
            int connIdx = arr[i][1];
            i = 0;
            while(arr[i][0] != connIdx){
                i++;
            }
            sb.append(i);
        }

        System.out.println(sb);

        return true;

    }
}
