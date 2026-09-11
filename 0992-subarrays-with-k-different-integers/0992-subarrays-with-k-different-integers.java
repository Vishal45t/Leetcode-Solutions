class Solution {
    public static int countSub(int[] nums, int k){
        int left = 0;
        int count = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
            while(mp.size() > k){
                int ele = nums[left];
                mp.put(ele, mp.get(ele)-1);
                if(mp.get(ele) == 0){
                    mp.remove(ele);
                }
                left++;
            }
            count += i-left+1;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {   //1358
        return countSub(nums, k) - countSub(nums, k-1);
    }
}