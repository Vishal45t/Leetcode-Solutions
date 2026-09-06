class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int x : stones){
            pq.offer(x);
        }

        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();

            if(first != second){
                int val = first-second;
                pq.offer(val);
            }

        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}