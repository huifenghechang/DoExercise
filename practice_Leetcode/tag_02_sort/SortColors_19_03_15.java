package tag_02_sort;

public class SortColors_19_03_15 {

    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 2){
            return;
        }

        int redEdge = -1;
        int buleEdge = nums.length;
        int cur = 0;
        while (cur < buleEdge){
            if (nums[cur]==0){
                swap(nums,++redEdge,cur++);
            }else if (nums[cur]==2){
                swap(nums,--buleEdge,cur);
            }else {
                cur++;
            }
        }
    }

    public void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
