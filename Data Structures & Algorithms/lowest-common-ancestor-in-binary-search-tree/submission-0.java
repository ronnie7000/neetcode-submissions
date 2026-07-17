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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return root;
        }

        List<TreeNode> pathA = new ArrayList<>();
        List<TreeNode> pathB = new ArrayList<>();

        getPath(root, p.val, pathA);
        getPath(root, q.val, pathB);

        if(pathA.isEmpty() || pathB.isEmpty()) {
            return null;
        }

        int idx = 0;
        TreeNode commonAncestor = null;

        while(idx < Math.min(pathA.size(), pathB.size())) {
            if(pathA.get(idx) != pathB.get(idx)) {
                break;
            }
            commonAncestor = pathA.get(idx);
            idx++;
        }
        return commonAncestor;
    }

    private void getPath(TreeNode node, int target, List<TreeNode> path) {
        if(node == null) {
            return;
        }
        path.add(node);

        if(node.val == target) {
            return;
        }
        else if(node.val < target) {
            getPath(node.right, target, path);
        } else {
            getPath(node.left, target, path);
        }
    }

}
