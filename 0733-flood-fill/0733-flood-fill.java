class Solution {
    public static void check(int[][] image, int i, int j, int color, int orgColor){
        if(i < 0 || j < 0 || i > image.length-1 || j > image[0].length-1 || image[i][j] != orgColor || image[i][j] == color){
            return;
        }

        image[i][j] = color;
        check(image, i+1, j, color, orgColor);
        check(image, i-1, j, color, orgColor);
        check(image, i, j+1, color, orgColor);
        check(image, i, j-1, color, orgColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgColor = image[sr][sc];
        check(image, sr, sc, color, orgColor);

        return image;
    }
}