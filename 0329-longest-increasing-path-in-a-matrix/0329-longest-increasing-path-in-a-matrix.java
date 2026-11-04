class Solution {

    public static int path(int[][] matrix, int i, int j, int[][] dp) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Already calculated
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int max = 0;

        // Bottom
        if (i + 1 < n && matrix[i + 1][j] > matrix[i][j]) {
            max = Math.max(max, path(matrix, i + 1, j, dp));
        }

        // Top
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            max = Math.max(max, path(matrix, i - 1, j, dp));
        }

        // Left
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            max = Math.max(max, path(matrix, i, j - 1, dp));
        }

        // Right
        if (j + 1 < m && matrix[i][j + 1] > matrix[i][j]) {
            max = Math.max(max, path(matrix, i, j + 1, dp));
        }

        return dp[i][j] = max + 1;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        int maxPath = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int currPath = path(matrix, i, j, dp);
                maxPath = Math.max(maxPath, currPath);
            }
        }

        return maxPath;
    }
}