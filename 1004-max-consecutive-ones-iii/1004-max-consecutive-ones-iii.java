class Solution {
    public int longestOnes(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int left = 0;
        int maxlen = 0;

        for(int i = 0; i < nums.length; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);

            while(mp.containsKey(0) && mp.get(0) > k){
                mp.put(nums[left], mp.get(nums[left])-1);
                left++;
            }
            maxlen = Math.max(maxlen, i-left+1);
        }
        return maxlen;
    }
}