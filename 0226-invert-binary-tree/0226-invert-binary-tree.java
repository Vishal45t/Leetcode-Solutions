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
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> pq = new LinkedList<>();

        pq.add(root);

        if (root == null) {
            return null;
        }

        while (!pq.isEmpty()) {
            TreeNode curr = pq.poll();

            TreeNode temp = curr.left;
            TreeNode temp1 = curr.right;
            TreeNode left = curr.left;
            TreeNode right = curr.right;

            curr.right = temp;
            curr.left = temp1;

            if (curr.left != null) {
                pq.offer(curr.left);
            }

            if (curr.right != null) {
                pq.offer(curr.right);
            }
        }
        return root;
    }
}