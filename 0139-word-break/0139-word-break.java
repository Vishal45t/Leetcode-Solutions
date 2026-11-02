class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>();
        int maxLen = 0;
        for(String word : wordDict){
            maxLen =  Math.max(maxLen, word.length());
            st.add(word);
        }
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = i-1; j >= Math.max(0, i-maxLen); j--){
                if(dp[j] && st.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}