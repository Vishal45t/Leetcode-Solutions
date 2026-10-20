class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i]%2 == 0){
                nums[i] = 0;
            }else{
                nums[i] = 1;
            }
        }

        int sum = 0;
        int count = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            if(mp.containsKey(sum-k)){
                count += mp.get(sum-k);
            }

            mp.put(sum, mp.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}