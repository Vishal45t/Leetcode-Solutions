class Solution {

    public static int coin(int amount, int[] coins, int i, int[][] dp) {

        if (amount == 0) {
            return 1;
        }

        if (i == coins.length || amount < 0) {
            return 0;
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        // Include current coin
        int take = coin(amount - coins[i], coins, i, dp);

        // Exclude current coin
        int notTake = coin(amount, coins, i + 1, dp);

        return dp[i][amount] = take + notTake;
    }

    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return coin(amount, coins, 0, dp);
    }
}