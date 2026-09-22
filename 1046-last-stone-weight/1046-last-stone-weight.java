class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int x : stones){
            pq.add(x);
        }

        while(pq.size() > 1){
            int n1 = pq.poll();
            int n2 = pq.poll();

            if(n1 != n2){
                pq.add(n1-n2);
            }
        }

        return pq.size() == 0 ? 0 : pq.peek();
    }
}