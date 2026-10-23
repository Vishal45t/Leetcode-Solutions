class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        int[] lastIdx = new int[26];
        String ans = "";
        Set<Character> se = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastIdx[ch - 'a'] = i;
        }

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(se.contains(ch)){
                continue;
            }

            while(!st.empty() && lastIdx[st.peek()-'a'] > i && ch < st.peek()){
                se.remove(st.peek());
                st.pop();
            }

            if(!se.contains(ch)){
                se.add(ch);
            }
            st.add(ch);
        }
        for(char x : st){
            ans += x;
        }
        return ans;
    }
}