class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int second = Integer.MIN_VALUE;

        for(int i = n-1; i >= 0; i--){
            if(nums[i] < second){
                return true;
            }
            while(!st.empty() && st.peek() < nums[i]){
                second = st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
}