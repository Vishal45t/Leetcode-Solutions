class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += cardPoints[i];
        }
        int maxSum = sum;
        int j = k-1;
        int l = cardPoints.length-1;
        int count = 0;
        while(count < k){
            sum -= cardPoints[j--];
            sum += cardPoints[l--];
            maxSum = Math.max(maxSum, sum);
            count++;
        }
        return maxSum;
    }
}