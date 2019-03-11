package tag_01_arraries.code_001_twoSum;

import java.util.HashMap;
import java.util.Map;

import static utils.utils.printfArray;

public class TwoSum_s2_19_03_11 {

    // 求两数之和
    public static int[] twoSum_Half(int[] nums, int target) {

        if (nums == null || nums.length < 2){
            return null;
        }

        Map<Integer,Integer> map = new HashMap<>();

        // 第一次迭代,不能采取第一次将所有数字权全部放入哈希表中。
        // 因为哈希Map中的key必须是唯一的，而数组中的值可能是重复的。
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }

        // 第二次迭代
        for (int i = 0; i < nums.length; i++){
            int aimedNum = target - nums[i];
            if(map.containsValue(aimedNum)&&map.get(aimedNum)!= i){
                return new int[]{i,map.get(aimedNum)};
            }

        }

        throw new IllegalArgumentException("no two sum solution");

    }

    // 本方法采用一次迭代即可完成
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2){
            throw new IllegalArgumentException("the argument is illegal");
        }
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i< nums.length; i++){
            Integer index = map.get(nums[i]);
            if (index != null){
                return new int[]{index,i};
            }else {
                int aimedNum = target - nums[i];
                map.put(aimedNum,i);
            }
        }
        throw new IllegalArgumentException("the argument is illegal");
    }

    public static void main(String[] args){
        int[] nums = {3,3};
        int target = 6;
        int[] res = twoSum(nums,target);
        printfArray(res);
    }
}
