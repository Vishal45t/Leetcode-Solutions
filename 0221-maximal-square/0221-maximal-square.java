class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSide = Integer.MIN_VALUE;

        int[][] ans = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        ans[i][j] = 1;
                    }else{
                        ans[i][j] = 1 + Math.min(Math.min(ans[i-1][j], ans[i][j-1]), ans[i-1][j-1]);
                    }
                }
                maxSide = Math.max(maxSide, ans[i][j]);
            }
        }
        return maxSide*maxSide;
    }
}