class Solution {
    public static void print(int[] nums, List<Integer> curr, boolean[] visited, List<List<Integer>> ans){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            curr.add(nums[i]);
            visited[i] = true;

            print(nums, curr, visited, ans);
            curr.remove(curr.size()-1);
            visited[i] = false;

        }
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        print(nums, curr, visited, ans);

        return ans;
    }
}