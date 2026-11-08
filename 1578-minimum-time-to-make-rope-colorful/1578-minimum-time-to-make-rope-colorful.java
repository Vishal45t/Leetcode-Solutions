class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost = 0;
        int j = 0;

        for(int i = 0; i < colors.length(); i++){
            char ch = colors.charAt(i);
            int sum = 0;
            int max = 0;

            while(j < colors.length() && colors.charAt(j) == ch){
                sum += neededTime[j];
                max = Math.max(max, neededTime[j]);
                j++;
            }
            cost += sum-max;
            i = j-1;
        }
        return cost;
    }
}