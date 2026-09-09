class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        List<Character> ar = new ArrayList<>();
        for(char x : s.toCharArray()){
            mp.put(x, mp.getOrDefault(x, 0)+1);
            ar.add(x);
        }

        Collections.sort(ar, (a, b) -> {
            if(mp.get(b).equals(mp.get(a))){
                return a-b;
            }else{
                return mp.get(b)-mp.get(a);
            }});

        StringBuilder ans = new StringBuilder();
        for(char x : ar){
            ans.append(x);
        }

        return ans.toString();
    }
}