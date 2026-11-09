class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0;

        for(int x : students){
            mp.put(x, mp.getOrDefault(x, 0)+1);
        }

        for(int i = 0; i < sandwiches.length; i++){
            int val = sandwiches[i];
            if(mp.containsKey(val) && mp.get(val) > 0){
                mp.put(val, mp.get(val)-1);
            }else{
                break;
            }
        }
        for(int x : mp.values()){
            sum += x;
        }
        return sum;
    }
}