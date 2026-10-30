class Solution {

    public static boolean check(int[] str, int[] str2) {
        for (int i = 0; i < 128; i++) {
            if (str2[i] < str[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {

        if (t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        int[] str = new int[128];

        // Store required character frequencies
        for (int i = 0; i < t.length(); i++) {
            str[t.charAt(i)]++;
        }

        int[] str2 = new int[128];

        int j = 0;
        int start = -1;
        int length = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {

            // Add current character
            str2[s.charAt(i)]++;

            // Shrink window while it contains all required characters
            while (check(str, str2)) {

                int currLength = i - j + 1;

                // Update minimum window
                if (currLength < length) {
                    length = currLength;
                    start = j;
                }

                // Remove leftmost character
                str2[s.charAt(j)]--;
                j++;
            }
        }

        return start == -1 ? "" : s.substring(start, start + length);
    }
}