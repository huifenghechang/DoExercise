package code_001_TwoSum;

import java.util.HashMap;

import static utils.utils.printfArray;

/*
* 本页代码采用时间复杂度为O(n)的算法，采用了Map类型的数据结构来实现 ~
*
* */


public class TwoSum_good {
    public static int[] twosum_n(int[] nums, int target){

        // 对数据合法性判断
        if (nums == null){
            return  null;
        }

        // 遍历一遍数组，找出数组中符合要求的下标
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            Integer index = hashMap.get(nums[i]);
            if (index != null){
                return new int[]{index,i};
            }else {
                // 存储第i个数所期望的“对应的数值”，从而在上一个判断中，找出后续中出现期望数字的下标 ~
                hashMap.put(target- nums[i],i);
            }
        }
        return null;
    }


    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = twosum_n(nums,target);
        printfArray(res);
    }
}
