package dynamic_plan;

public class T300_LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums.length==0 || nums.length==1){
            return nums.length;
        }

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int max_len = 1;
        for (int i=1; i<len;i++){
            dp[i] = 1;
            for (int j=0; j<i;j++){
                if (nums[i] > nums[j] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] +1;
                }
            }
            if (max_len < dp[i]){
                max_len = dp[i];
            }
        }
        return max_len;
    }
}
