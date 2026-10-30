/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        int levels = 1;

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        while (!pq.isEmpty()) {
            int currentLevel = pq.size();
            List<Integer> res = new ArrayList<>();
            Stack<Integer> st = new Stack<>();

            while (currentLevel > 0) {
                TreeNode ele = pq.poll();
                if (ele.left != null) {
                    pq.add(ele.left);
                }
                if (ele.right != null) {
                    pq.add(ele.right);
                }
                if (levels % 2 != 0) {
                    res.add(ele.val);
                } else {
                    st.add(ele.val);
                }
                currentLevel--;
            }
            if (levels%2 == 0) {
                while(!st.empty()){
                    int x = st.pop();
                    res.add(x);
                }
            }
            ans.add(new ArrayList<>(res));
            levels++;
        }
        return ans;
    }
}