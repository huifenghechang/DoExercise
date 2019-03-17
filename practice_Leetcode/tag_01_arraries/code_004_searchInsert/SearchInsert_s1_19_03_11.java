package tag_01_arraries.code_004_searchInsert;

public class SearchInsert_s1_19_03_11 {

    public int searchInsert(int[] nums, int target) {
        if (nums == null){
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int midIndex = (left + right) / 2;

        // 折半查找法,最终“中点”坐标的位置，是待插入位置
        while (left < right){
            if (nums[midIndex] == target){
                return midIndex;
            }else if (nums[midIndex] < target){
                left = midIndex + 1;
                midIndex = (left + right)/2;
            }else {
                right = midIndex - 1;
                midIndex = (left + right)/2;
            }
        }
        if (nums[midIndex] < target){
            return midIndex + 1;
        }else {
            return midIndex;
        }
    }
}
