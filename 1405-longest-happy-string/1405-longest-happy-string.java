class Solution {
    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x, y) -> y[1] - x[1]
        );

        if(a > 0) pq.offer(new int[]{'a', a});
        if(b > 0) pq.offer(new int[]{'b', b});
        if(c > 0) pq.offer(new int[]{'c', c});

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {

            int[] curr = pq.poll();

            char ch = (char) curr[0];
            int freq = curr[1];

            int n = sb.length();

            // Check whether adding this character creates three consecutive same characters
            if(n >= 2 && sb.charAt(n-1) == ch && sb.charAt(n-2) == ch) {

                if(pq.isEmpty()) break;

                int[] second = pq.poll();

                char ch2 = (char) second[0];
                int freq2 = second[1];

                sb.append(ch2);
                freq2--;

                if(freq2 > 0) {
                    pq.offer(new int[]{ch2, freq2});
                }

                pq.offer(new int[]{ch, freq});
            }
            else {
                sb.append(ch);
                freq--;

                if(freq > 0) {
                    pq.offer(new int[]{ch, freq});
                }
            }
        }

        return sb.toString();
    }
}