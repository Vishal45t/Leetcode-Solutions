class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int score = 0;
        int j = piles.length - 2;

        for(int i = 0; i < piles.length / 3; i++) {
            score += piles[j];
            j -= 2;
        }

        return score;
    }
}