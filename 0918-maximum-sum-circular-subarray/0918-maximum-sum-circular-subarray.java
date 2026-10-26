class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int total = 0;

        int currMax = 0;
        int maxSum = nums[0];

        int currMin = 0;
        int minSum = nums[0];

        for (int num : nums) {

            // Find maximum subarray sum using Kadane's algorithm
            currMax = Math.max(currMax + num, num);
            maxSum = Math.max(maxSum, currMax);

            // Find minimum subarray sum
            currMin = Math.min(currMin + num, num);
            minSum = Math.min(minSum, currMin);

            // Calculate the sum of the entire array
            total += num;
        }

        // If all elements are negative, return the largest element
        if (maxSum < 0) {
            return maxSum;
        }

        // Circular maximum = total sum - minimum subarray sum
        // Return the maximum between circular and normal subarray sums
        return Math.max(maxSum, total - minSum);
    }
}