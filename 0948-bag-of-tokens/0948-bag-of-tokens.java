class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        int score = 0;
        int maxScore = 0;

        while (i <= j) {
            if (tokens[i] <= power) {
                score++;
                maxScore = Math.max(score, maxScore);
                power -= tokens[i];
                i++;
            } else if (score > 0 && i < j) {
                score--;
                power += tokens[j];
                j--;
            } else {
                return maxScore;
            }
        }
        return maxScore;
    }
}