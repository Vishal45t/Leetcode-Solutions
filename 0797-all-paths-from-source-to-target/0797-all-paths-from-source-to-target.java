class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        dfs(graph, 0, graph.length - 1, ans, res);

        return res;
    }

    public void dfs(int[][] graph, int curr, int dest,
            List<Integer> ans, List<List<Integer>> res) {

        ans.add(curr);

        if (curr == dest) {
            res.add(new ArrayList<>(ans));
            ans.remove(ans.size() - 1);
            return;
        }

        for (int i = 0; i < graph[curr].length; i++) {
            dfs(graph, graph[curr][i], dest, ans, res);
        }

        ans.remove(ans.size() - 1);
    }
}