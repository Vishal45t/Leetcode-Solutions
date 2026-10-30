class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] dp = new int[m];

        for (int j = 0; j < m; j++) {
            dp[j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            int[] temp = new int[m];

            for (int j = 0; j < m; j++) {

                int min = dp[j];

                if (j > 0) {
                    min = Math.min(min, dp[j - 1]);
                }

                if (j < m - 1) {
                    min = Math.min(min, dp[j + 1]);
                }

                temp[j] = matrix[i][j] + min;
            }

            dp = temp;
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, dp[j]);
        }

        return ans;
    }
}