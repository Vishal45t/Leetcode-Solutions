class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st1.push(i); 
            }
            else if(ch == '*') {
                st2.push(i);
            }
            else {
                if(!st1.empty()) {
                    st1.pop();
                }
                else if(!st2.empty()) {
                    st2.pop();
                }
                else {
                    return false;
                }
            }
        }
        while(!st1.empty() && !st2.empty()) {    // for *((
            if(st1.pop() > st2.pop()) {
                return false;
            }
        }
        return st1.empty();
    }
}