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
    public int rob(TreeNode root) {
        int[] options = travel(root);
        return Math.max(options[0], options[1]);
    }

    private int[] travel(TreeNode root) {
        // Base case
        if (root == null) {
            return new int[2];
        }

        // First, process the left and right subtrees
        int[] left_node_choices = travel(root.left);
        int[] right_node_choices = travel(root.right);

        int[] options = new int[2];

        // Choice 1: Rob the current node
        options[0] = root.val
                   + left_node_choices[1]
                   + right_node_choices[1];

        // Choice 2: Skip the current node
        options[1] = Math.max(left_node_choices[0], left_node_choices[1])
                   + Math.max(right_node_choices[0], right_node_choices[1]);

        return options;
    }
}
