class Solution {
    public void combination(int[] candidates, int target,
            List<Integer> ans, List<List<Integer>> res, int i) {

        int n = candidates.length;

        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }

        if (i == n || target < 0) {
            return;
        }

        for (int j = i; j < n; j++) {

            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }

            if (candidates[j] > target) {
                break;
            }

            ans.add(candidates[j]);

            combination(candidates, target - candidates[j],
                    ans, res, j + 1);

            ans.remove(ans.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        combination(candidates, target, ans, res, 0);

        return res;
    }
}