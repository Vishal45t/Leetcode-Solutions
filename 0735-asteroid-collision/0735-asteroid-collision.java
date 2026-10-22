class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        List<Integer> ls = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (asteroids[i] > 0) {
                st.add(asteroids[i]);
            }

            if (asteroids[i] < 0) {
                boolean survive = true;
                while (!st.empty() && st.peek() > 0) {
                    if (-(asteroids[i]) > st.peek()) {
                        st.pop();
                        survive = true;
                    } else if (-(asteroids[i]) == st.peek()) {
                        survive = false;
                        st.pop();
                        break;
                    } else {
                        survive = false;
                        break;
                    }
                }
                if (survive) {
                    st.add(asteroids[i]);
                }
            }
        }

        int[] res = new int[st.size()];
        int i = 0;
        for (int x : st) {
            res[i++] = x;
        }
        return res;
    }
}