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
    public int minDepth(TreeNode root) {
        int currDepth = 1;
        Queue<TreeNode> pq = new LinkedList<>();

        pq.add(root);
        if (root == null) {
            return 0;
        }

        while (!pq.isEmpty()) {
            int levels = pq.size();

            while (levels > 0) {
                TreeNode ele = pq.poll();
                if (ele.left == null && ele.right == null) {
                    return currDepth;
                }
                if (ele.left != null) {
                    pq.add(ele.left);
                }
                if (ele.right != null) {
                    pq.add(ele.right);
                }
                levels--;
            }
            currDepth++;
        }
        return 0;
    }
}