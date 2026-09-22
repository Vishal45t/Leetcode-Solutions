class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxPoints = 0;
        int points = 0;
        int left = k-1;
        int n = cardPoints.length;
        for(int i = 0; i < k; i++){
            points += cardPoints[i];
        }

        maxPoints = Math.max(maxPoints, points);

        for(int j = cardPoints.length-1; j >= n-k; j--){
            points -= cardPoints[left--];
            points += cardPoints[j];

            maxPoints = Math.max(maxPoints, points);
        }
        return maxPoints;
    }
}