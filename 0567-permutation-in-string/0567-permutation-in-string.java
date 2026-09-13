class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length())
            return false;

        int[] st1 = new int[26];

        for(char ch : s1.toCharArray()){
            st1[ch - 'a']++;
        }

        for(int i = 0; i <= s2.length() - s1.length(); i++){

            int[] st2 = new int[26];

            for(int k = i; k < i + s1.length(); k++){
                st2[s2.charAt(k) - 'a']++;
            }

            boolean found = true;

            for(int j = 0; j < 26; j++){
                if(st1[j] != st2[j]){
                    found = false;
                    break;
                }
            }

            if(found){
                return true;
            }
        }

        return false;
    }
}