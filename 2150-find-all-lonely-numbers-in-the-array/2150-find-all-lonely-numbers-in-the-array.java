class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int x : nums){
            mp.put(x, mp.getOrDefault(x, 0)+1);
        }

        for(int i = 0; i < nums.length; i++){
            if(mp.get(nums[i]) == 1 && !mp.containsKey(nums[i]-1) && !mp.containsKey(nums[i]+1)){
                result.add(nums[i]);
            }
        }
        return result;
    }
}