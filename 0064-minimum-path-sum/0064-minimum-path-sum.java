class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    res[i][j] = grid[i][j];
                }else if(i == 0){
                    res[i][j] = res[i][j-1] + grid[i][j];
                }else if(j == 0){
                    res[i][j] = res[i-1][j] + grid[i][j];
                }else{
                    res[i][j] = Math.min(res[i][j-1], res[i-1][j]) + grid[i][j];
                }
            }
        }
        return res[n-1][m-1];
    }
}