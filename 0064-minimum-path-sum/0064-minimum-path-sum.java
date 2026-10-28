class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] res = new int[n][m];

        res[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;

                int up = (i > 0) ? res[i - 1][j] : Integer.MAX_VALUE;
                int left = (j > 0) ? res[i][j - 1] : Integer.MAX_VALUE;

                res[i][j] = grid[i][j] + Math.min(up, left);
            }
        }

        return res[n - 1][m - 1];
    }
}
