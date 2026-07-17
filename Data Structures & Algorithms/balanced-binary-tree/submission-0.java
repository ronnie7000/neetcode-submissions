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
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        solve(root);
        return ans;
    }

    private int solve(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftSubTree = solve(node.left);
        int rightSubTree = solve(node.right);

        if(Math.abs(leftSubTree - rightSubTree) > 1) {
            ans = false;
        }

        return 1 + Math.max(leftSubTree, rightSubTree);
    }
}
