class Solution {
    public int numberOfSubstrings(String s) {
        int[] last = {-1, -1, -1};
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;

            int min = Math.min(last[0], last[1]);
            min = Math.min(min, last[2]);

            if (min != -1) {
                count += min + 1;
            }
        }

        return count;
    }
}