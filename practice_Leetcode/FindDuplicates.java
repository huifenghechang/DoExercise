import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicates {
    public static List<Integer> findDuplicates1(int[] nums) {
        if (nums == null || nums.length < 2){
            return null;
        }
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i= 0;i< nums.length;i++){
            while (nums[i]-1 != i){
                if (nums[i] == nums[nums[i]-1]){
                    set.add(nums[i]);
                    break;
                }
                swap(nums,i,nums[i]-1);
            }
        }
        list.addAll(set);
        return list;
    }

    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] nums = new int[] {4,3,2,7,8,2,3,1};
        List<Integer> list = findDuplicates1(nums);

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
