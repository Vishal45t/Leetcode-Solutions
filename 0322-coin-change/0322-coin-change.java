class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = amount;
        int[] ar = new int[n + 1];

        Arrays.fill(ar, amount + 1);
        ar[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = i - coins[j];

                if (coin >= 0) {
                    ar[i] = Math.min(ar[i], 1 + ar[coin]);
                }
            }
        }

        return ar[n] > amount ? -1 : ar[n];
    }
}