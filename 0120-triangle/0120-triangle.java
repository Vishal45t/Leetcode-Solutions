class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] ar = new int[n+1][n+1];

        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                ar[i][j] = triangle.get(i).get(j)+Math.min(ar[i+1][j], ar[i+1][j+1]);
            }
        }
        return ar[0][0];
    }
}