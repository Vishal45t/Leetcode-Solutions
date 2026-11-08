class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int j = piles.length-1;
        int score = 0;
        int i = 0;
        int count = piles.length-2;

        while(i < j){
            if(j == count){
                score += piles[j];
                count -= 2;
                i++;
            }
            j--;
        }
        return score;
    }
}