class Solution {
    public int characterReplacement(String s, int k) {
        int j = 0;
        int n = s.length();
        int maxLen = 0;
        int maxfreq = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
            int windLen = i-j+1;
            maxfreq = Math.max(maxfreq, mp.get(ch));
            if(windLen-maxfreq > k){
                int m = mp.get(s.charAt(j));
                mp.put(s.charAt(j), m-1);
                j++;
            }
            maxLen = Math.max(maxLen, i-j+1);
        }
        return maxLen;
    }
}