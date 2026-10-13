class Solution {
    public static void getper(List<List<Integer>> ans, int[] nums, boolean[] vis, List<Integer> cur){
        if(cur.size() == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(vis[i]){
                continue;
            }
            cur.add(nums[i]);
            vis[i] = true;
            getper(ans, nums, vis, cur);

            cur.remove(cur.size()-1);
            vis[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        getper(ans, nums, vis, cur);
        return ans;
    }
}