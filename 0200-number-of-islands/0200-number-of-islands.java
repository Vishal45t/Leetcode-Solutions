class Solution {

    public static void dfs(char[][] grid, boolean[][] vis, int i, int j) {

        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m ||
            vis[i][j] || grid[i][j] != '1') {
            return;
        }

        vis[i][j] = true;

        dfs(grid, vis, i - 1, j);
        dfs(grid, vis, i + 1, j);
        dfs(grid, vis, i, j + 1);
        dfs(grid, vis, i, j - 1);
    }

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    dfs(grid, vis, i, j);
                }
            }
        }

        return count;
    }
}