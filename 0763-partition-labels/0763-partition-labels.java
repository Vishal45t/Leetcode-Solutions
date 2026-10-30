class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIdx = new int[26];
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        int j = 0;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            lastIdx[ch-'a'] = i;
        }

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            int idx = lastIdx[ch-'a'];
            while(i < idx && i < n){
                if(lastIdx[s.charAt(i)-'a'] > idx){
                    idx = lastIdx[s.charAt(i)-'a'];
                }
                i++;
            }
            res.add(i-j+1);
            j = idx+1;
            i = idx;
        }
        return res;
    }
}