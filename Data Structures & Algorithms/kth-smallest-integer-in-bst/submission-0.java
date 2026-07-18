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
    private List<Integer> inOrder = new ArrayList();

    public int kthSmallest(TreeNode root, int k) {
        if(k < 1 || root == null) {
            return -1;
        }
        getInOrderTraversal(root);
        if(k > inOrder.size()) {
            return -1;
        }
        return inOrder.get(k - 1);
    }

    private void getInOrderTraversal(TreeNode node) {
        if(node == null) {
            return;
        }
        getInOrderTraversal(node.left);
        inOrder.add(node.val);
        getInOrderTraversal(node.right);
    }
}
