class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int i = 0; i < stones.length; i++){
            pq.add(stones[i]);
        }

        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();
            if(x != y){
                int n = x-y;
                pq.add(n);
            }
        }

        return pq.size() == 1 ? pq.peek() : 0 ;
    }
}