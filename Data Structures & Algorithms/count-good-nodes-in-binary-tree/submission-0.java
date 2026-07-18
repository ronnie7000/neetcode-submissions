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
    int goodNodesCount = 0;
    public int goodNodes(TreeNode root) {
        solve(root, Integer.MIN_VALUE);
        return goodNodesCount;
    }

    private void solve(TreeNode node, int maxSoFar) {
        if(node == null) {
            return;
        }

        if(node.val >= maxSoFar) {
            goodNodesCount++;
            maxSoFar = Math.max(maxSoFar, node.val);
        }
        solve(node.left, maxSoFar);
        solve(node.right, maxSoFar);
    }

}
