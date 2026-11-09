class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        Map<Character, Integer> mp = new HashMap<>();
        int max = 0;
        mp.put('T', 0);
        mp.put('F', 0);
        int maxFreq = 0;
        int j = 0;

        for(int i = 0; i < answerKey.length(); i++){
            mp.put(answerKey.charAt(i), mp.getOrDefault(answerKey.charAt(i), 0)+1);
            maxFreq = Math.max(maxFreq, mp.get(answerKey.charAt(i)));

            int winLen = i-j+1;

            if(winLen - maxFreq > k){
                mp.put(answerKey.charAt(j), mp.get(answerKey.charAt(j))-1);
                j++;
            }

            max = Math.max(max, i-j+1);
        }
        return max;
    }
}