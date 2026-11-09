class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int[] ar = new int[n];
        for(int i = 0; i < n; i++){
            ar[i] = capacity[i]-rocks[i];
        }
        Arrays.sort(ar);
        int bags = 0;

        for(int i = 0; i < n; i++){
            if(ar[i] == 0){
                bags++;
            }else if(additionalRocks >= ar[i]){
                bags++;
                additionalRocks -= ar[i];
            }else{
                return bags;
            }
        }
        return bags;
    }
}