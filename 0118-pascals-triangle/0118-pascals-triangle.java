 class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();


        for(int i = 0; i < numRows; i++){
            List<Integer> ans = new ArrayList<>();

            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    ans.add(1);
                }else{
                    int sum = prev.get(j-1)+prev.get(j);
                    ans.add(sum);
                }
            }
            prev = ans;
            res.add(ans);
        }
        return res;

    }
}