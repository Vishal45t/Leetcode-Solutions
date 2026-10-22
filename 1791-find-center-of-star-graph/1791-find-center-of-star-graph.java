class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for(int[] ar : edges){
            int n1 = ar[0];
            int n2 = ar[1];

            if(mp.containsKey(n1)){
                mp.get(n1).add(n2);
            }else{
                mp.put(n1, new ArrayList<>());
                mp.get(n1).add(n2);
            }

            if(mp.containsKey(n2)){
                mp.get(n2).add(n1);
            }else{
                mp.put(n2, new ArrayList<>());
                mp.get(n2).add(n1);
            }
        }
        Set<Integer> st = mp.keySet();
        int k = mp.size();

        for(int x : st){
            int n = mp.get(x).size();

            if(n == k-1){
                return x;
            }
        }
        return -1;
    }
}