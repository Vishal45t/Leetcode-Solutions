class Solution {
    public int pivotIndex(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] prefix = new int[nums.length];
        int sum = 0;
        int n = nums.length;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            prefix[i] = sum;
        }

        for(int i = 0; i < nums.length; i++){
            int prev = 0;
            if(i-1 == -1){
                prev = 0;
            }else{
                prev = prefix[i-1];
            }
            int next = prefix[n-1]-prefix[i];

            if(prev == next){
                return i;
            }
        }
        return -1;
    }
}