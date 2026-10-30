class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (j == 0) {
                    dp[i][j] = Math.min(matrix[i][j] + dp[i - 1][j + 1], matrix[i][j] + dp[i - 1][j]);
                } else if (j == n - 1) {
                    dp[i][j] = Math.min(matrix[i][j] + dp[i - 1][j - 1], matrix[i][j] + dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.min(matrix[i][j] + dp[i - 1][j - 1], matrix[i][j] + dp[i - 1][j]);

                    dp[i][j] = Math.min(matrix[i][j] + dp[i - 1][j + 1], dp[i][j]);
                }
            }
        }
        for (int j = 0; j < m; j++) {
            minVal = Math.min(minVal, dp[n - 1][j]);
        }
        return minVal;
    }
}