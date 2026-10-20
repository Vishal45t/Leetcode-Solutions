class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> tm = new TreeMap<>(Collections.reverseOrder());
        int n = position.length;

        for(int i = 0; i < n; i++){
            int pos = position[i];
            int dis = target - pos;
            double time = (double) dis / speed[i];

            tm.put(pos, time);
        }

        Set<Integer> st = tm.keySet();
        double maxkey = Double.MIN_VALUE;
        int fleets = 0;

        for(int k : st){
            if(tm.get(k) > maxkey){
                maxkey = tm.get(k);
                fleets++;
            }
        }
        return fleets;
    }
}