class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxEle = 0;

        for(int i = 1; i < n; i++){
            for(int j = i-1; j >= 0; j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        for(int i = 0; i < dp.length; i++){
            maxEle = Math.max(maxEle, dp[i]);
        }
        return maxEle;
    }
}