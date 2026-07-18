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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        TreeNode lastNode = root;

        while(!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if(node.left != null) {
                deque.add(node.left);
            }
            if(node.right != null) {
                deque.add(node.right);
            }

            if(node.equals(lastNode)) {
                res.add(node.val);
                lastNode = deque.peekLast();
            }
        }
        return res;
    }
}
