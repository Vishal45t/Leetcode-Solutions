class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int left = 1;
        int right = max;
        int minSum = Integer.MAX_VALUE;

        while(left <= right) {

            int mid = left + (right - left) / 2;

            int sum = 0;

            for(int i = 0; i < nums.length; i++) {
                double val = (double) nums[i] / mid;
                sum += Math.ceil(val);
            }

            if(sum <= threshold) {
                minSum = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return minSum;
    }
}