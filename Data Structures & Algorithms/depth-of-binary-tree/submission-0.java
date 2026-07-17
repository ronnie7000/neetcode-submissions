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
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        solve(root, 1);
        return maxDepth;
    }

    private void solve(TreeNode node, int depth) {
        if(node == null) {
            return;
        }
        maxDepth = Math.max(depth, maxDepth);
        solve(node.left, depth + 1);
        solve(node.right, depth + 1);
    }
}
