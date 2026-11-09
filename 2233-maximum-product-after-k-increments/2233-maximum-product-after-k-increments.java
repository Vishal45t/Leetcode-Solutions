class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long mul = 1;
        int mod = 1000000007;

        for(int x : nums){
            pq.offer(x);
        }

        for(int i = 0; i < k; i++){
            int num = pq.poll();
            num += 1;
            pq.offer(num);
        }

        while(!pq.isEmpty()){
            mul = (mul*pq.poll())%mod;
        }
        return (int)mul;
    }
}