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
    public boolean isValidBST(TreeNode root) {
        return solve(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean solve(TreeNode node, int minValue, int maxValue) {
        if(node == null) {
            return true;
        }
        if(node.val <= minValue || maxValue <= node.val) {
            return false;
        }

        boolean left = solve(node.left, minValue, node.val);
        boolean right = solve(node.right, node.val, maxValue);
        
        return left && right;
    }
}
