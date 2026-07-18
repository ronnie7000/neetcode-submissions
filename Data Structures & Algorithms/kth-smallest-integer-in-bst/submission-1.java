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
    int count = 0, ans = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return ans;
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if(node == null || ans != -1) {
            return;
        }

        inOrderTraversal(node.left, k);

        count++;
        if(count == k) {
            ans = node.val;
            return;
        }
        
        inOrderTraversal(node.right, k);
    }
}
