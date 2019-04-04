public class T53_MaxSubArray {

    public int maxSubArray(int[] nums) {
        if(nums.length <1){
            return -1;
        }
        int[] dp = new int[nums.length];
        int max_result = nums[0];
        dp[0] = nums[0];
        for(int i=1; i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max_result = max_result < dp[i] ? dp[i] : max_result;
        }
        return max_result;
    }
}
