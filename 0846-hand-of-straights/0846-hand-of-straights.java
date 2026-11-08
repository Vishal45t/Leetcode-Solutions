class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> mp = new HashMap<>();
        Arrays.sort(hand);
        for(int x : hand){
            mp.put(x, mp.getOrDefault(x, 0)+1);
        }

        for(int i = 0; i < hand.length; i++){
            if(mp.get(hand[i]) > 0){
                mp.put(hand[i], mp.get(hand[i])-1);
                int count = hand[i]+1;
                int seq = 1;
                while(mp.containsKey(count) && mp.get(count) > 0 && seq != groupSize){
                    mp.put(count, mp.get(count)-1);
                    count += 1;
                    seq++;
                }
                if(seq != groupSize){
                    return false;
                }
            }
        }
        return true;
    }
}