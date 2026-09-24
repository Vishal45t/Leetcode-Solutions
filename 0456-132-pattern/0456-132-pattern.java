class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int second = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            // nums[i] is the "1"
            if (nums[i] < second) {
                return true;
            }

            // Find the "2"
            while (!st.empty() && st.peek() < nums[i]) {
                second = st.pop();
            }

            // nums[i] can be the "3"
            st.push(nums[i]);
        }

        return false;
    }
}