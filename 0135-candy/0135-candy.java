class Solution {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int count = 0;

        Arrays.fill(left, 1);

        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }
        }
        for(int i = ratings.length-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                left[i] = Math.max(left[i+1]+1, left[i]);
            }
        }
        for(int x : left){
            count += x;
        }
        return count;
    }
}