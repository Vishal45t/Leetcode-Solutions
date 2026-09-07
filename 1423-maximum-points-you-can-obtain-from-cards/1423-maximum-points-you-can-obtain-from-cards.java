class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int left = k - 1;
        int right = n - 1;

        int sum = 0;
        int maxSum = 0;

        // Take k cards from left
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        maxSum = sum;

        // Replace left cards with right cards
        for (int i = 0; i < k; i++) {

            sum -= cardPoints[left];
            left--;

            sum += cardPoints[right];
            right--;

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}