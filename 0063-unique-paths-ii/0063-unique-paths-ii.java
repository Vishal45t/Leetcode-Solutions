
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] res = new int[n][m];

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        res[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (obstacleGrid[i][j] == 1) {
                    res[i][j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) {
                    continue;
                }

                if (i > 0) {
                    res[i][j] += res[i - 1][j];
                }

                if (j > 0) {
                    res[i][j] += res[i][j - 1];
                }
            }
        }

        return res[n - 1][m - 1];
    }
}
