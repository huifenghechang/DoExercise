import java.util.HashMap;

public class T1_AddTwoNumber_array {

    /*
    *
 给定一个整数数组 nums 和一个目标值 target，
 请你在该数组中找出和为目标值的那 两个整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
    * */


 /*
 * HashMap的用法：
 *
 *
 * */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i=0 ; i< nums.length; i++){
            Integer index = hashMap.get(nums[i]);
            if (index != null){
                return new int[] {index,i};
            }else {
                hashMap.put(target - nums[i],i);
            }
        }
        return null;
    }

    /*
    * 使用Map的时候，一定搞清楚 key 与 value之间的对应关系。
    * */
    public static int[] twoSum_190325(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i=0 ; i< nums.length; i++){
            if (hashMap.containsKey(nums[i])){
                int index = hashMap.get(nums[i]);
                return new int[] {index,i};
            }else {
                hashMap.put(target - nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args){
        int[] arr = {1,6,2,4,5,3,7,8};
        int target = 8;
        twoSum_190325(arr,target);
    }

}
