class Solution {
    public int jump(int[] nums) {
        int currEnd = 0;
        int maxJump = 0;
        int count = 0;

        if(nums.length == 1){
            return count;
        }

        for(int i = 0; i < nums.length; i++){
            maxJump = Math.max(maxJump, nums[i]+i);

            if(currEnd == i){
                count++;
                currEnd = maxJump;
            }

            if(currEnd >= nums.length-1){
                return count;
            }
        }
        return count;
    }
}