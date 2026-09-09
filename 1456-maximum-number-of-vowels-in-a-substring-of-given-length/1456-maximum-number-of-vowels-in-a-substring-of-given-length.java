class Solution {
    public int maxVowels(String s, int k) {
        int maxCount = 0;
        int count = 0;
        int m = 0;
        int[] freq = new int[26];
        for(int i = 0; i < k; i++){
            freq[s.charAt(i)-'a']++;
        }

        for(int j = 0; j < 26; j++){
            if(j== 0 || j==4 || j == 8 || j == 14 || j == 20){
                count +=freq[j];
            }
        }
        maxCount = count;

        for(int i = k; i < s.length(); i++){
            count = 0;
            freq[s.charAt(m++)-'a']--;
            freq[s.charAt(i)-'a']++;

            for(int j = 0; j < 26; j++){
            if(j== 0 || j==4 || j == 8 || j == 14 || j == 20){
                count +=freq[j];
            }
        }
        maxCount = Math.max(maxCount, count);

        }
        return maxCount;
    }
}