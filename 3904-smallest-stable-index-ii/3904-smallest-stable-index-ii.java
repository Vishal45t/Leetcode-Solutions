class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(nums[i], left[i-1]);
        }
        right[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            right[i] = Math.min(nums[i], right[i+1]);
        }

        for(int i = 0; i < n; i++){
            int diff = left[i]-right[i];
            if(diff <= k){
                return i;
            }
        }
        return -1;
    }
}