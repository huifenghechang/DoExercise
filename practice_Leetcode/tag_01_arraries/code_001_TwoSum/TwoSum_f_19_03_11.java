package tag_01_arraries.code_001_TwoSum;

import static utils.utils.printfArray;

public class TwoSum_f_19_03_11 {
    public static int[] twosum(int[] nums, int target){
        if (nums ==null){
            System.out.println("Error Input");
            return null;
        }
        // 遍历数组，找到最终符合要求的数字。
        int m1 = 0;
        int m2 = 0;

        // 由于一定存在，所以必定会在两重循环中返回~
        for (int k = 0; k < nums.length ; k++){
            m1 = k;
            for ( int j = k + 1; j < nums.length ;j++){
                if ( nums[m1] + nums[j] == target){
                    m2 = j;
                    return new int[]{m1,m2};
                }
            }
        }

        return  null;
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = twosum(nums,target);
        printfArray(res);
    }
}
