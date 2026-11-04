/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode leftLCA = LCA(root.left, p, q);
        TreeNode rightLCA = LCA(root.right, p, q);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        if (leftLCA != null) {
            return leftLCA;
        }

        if (rightLCA != null) {
            return rightLCA;
        }

        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root, p, q);
    }
}