package code_01_minSum;

public class MinSum_S01 {
    public static void main(String[] args){
        int[] nums = {1,3,4,2,5};
        if (!validity(nums)){
            System.out.println("The array is inValidity!");
        }else {
            System.out.println("The minMax is"+minMax(nums,nums.length));
        }
    }

    public static boolean validity(int[] args){
        if (args.length<1 || args==null){
            return false;
        }else {
            return true;
        }
    }

    public static int minMax(int[] args,int length){
        int sum = 0;
        if (length == 1){
            return 0;
        }
        int[] count = new int[length-1];
        for(int i=0;i<length;i++){
            int num = args[i];
            for(int j=i+1;j<length;j++){
                if (args[j]>num){
                    count[i]++;
                }
            }
        }

        for (int i=0;i<length-1;i++){
            sum += args[i]*count[i];
        }
        return sum;
    }
}
