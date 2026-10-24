class Solution {
    public static void dfs(int[][] image, int r, int c, int newColor, int orgColor){
        int n = image.length;
        int m = image[0].length;
        if(r < 0 || c < 0 || r > n-1 || c > m-1 || image[r][c] != orgColor || image[r][c] == newColor){
            return;
        }

        image[r][c] = newColor;

        dfs(image, r-1, c, newColor, orgColor);
        dfs(image, r+1, c, newColor, orgColor);
        dfs(image, r, c-1, newColor, orgColor);
        dfs(image, r, c+1, newColor, orgColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc]);

        return image;
    }
}