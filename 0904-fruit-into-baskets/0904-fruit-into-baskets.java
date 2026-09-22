class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = fruits.length;
        int left = 0;
        int count = 0;
        int maxfruits = 0;

        for(int i = 0; i < n; i++){
            mp.put(fruits[i], mp.getOrDefault(fruits[i], 0)+1);
            count++;

            while(mp.size() > 2){
                int ele = fruits[left++];
                mp.put(ele, mp.get(ele)-1);
                if(mp.get(ele) == 0){
                    mp.remove(ele);
                }
                count--;
            }
            maxfruits = Math.max(maxfruits, count);
        }
        return maxfruits;
    }
}