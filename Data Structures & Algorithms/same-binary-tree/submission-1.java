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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        solve(p, q);
        return ans;
    }

    private void solve(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) {
            return;
        }

        if(
            (node1 != null && node2 == null) ||
            (node1 == null && node2 != null) ||
            (node1.val != node2.val)
        ) {
            ans = false;
            return;
        }
        
        solve(node1.left, node2.left);
        solve(node1.right, node2.right);
    }
}
